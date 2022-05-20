package com.shin.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shin.blog.constants.MqConstants;
import com.shin.blog.dao.mapper.ArticleBodyMapper;
import com.shin.blog.dao.mapper.ArticleMapper;
import com.shin.blog.dao.mapper.ArticleTagMapper;
import com.shin.blog.dao.pojo.Article;
import com.shin.blog.dao.pojo.ArticleBody;
import com.shin.blog.dao.pojo.ArticleTag;
import com.shin.blog.dao.pojo.SysUser;
import com.shin.blog.service.ArticleService;
import com.shin.blog.service.ThreadService;
import com.shin.blog.utils.UserThreadLocal;
import com.shin.blog.vo.ArticleVo;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.TagVo;
import com.shin.blog.vo.params.ArticleParam;
import com.shin.blog.vo.params.PageParams;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleBodyMapper articleBodyMapper;

    @Autowired
    ThreadService threadService;

    @Autowired
    ArticleTagMapper articleTagMapper;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ArticleCopy articleCopy;

    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 分页查询article数据库表
         */
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        if (pageParams.getCategoryId() != null) {
            queryWrapper.eq(Article::getCategoryId, pageParams.getCategoryId());
        }
        List<Long> articleIdList = new ArrayList<>();
        if (pageParams.getTagId() != null) {
            LambdaQueryWrapper<ArticleTag> articleTagLambdaQueryWrapper = new LambdaQueryWrapper<>();
            articleTagLambdaQueryWrapper.eq(ArticleTag::getTagId, pageParams.getTagId());
            List<ArticleTag> articleTagList = articleTagMapper.selectList(articleTagLambdaQueryWrapper);
            for (ArticleTag articleTag : articleTagList) {
                articleIdList.add(articleTag.getArticleId());
            }
            if (articleIdList.size() > 0) {
                queryWrapper.in(Article::getId, articleIdList);
            }
        }

        // 按照 是否置顶、创建时间 进行排序
        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateTime);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = articleCopy.copyList(records, true, true);
        return Result.success(articleVoList);
    }

    @Override
    public Result findArticleById(Long articleId) {
        /**
         * 1. 根据id查询 文章信息
         * 2. 根据bodyId和categoryid 去做关联查询
         */
        Article article = this.articleMapper.selectById(articleId);
        if (article == null) {
            return Result.error(ErrorCode.ARTICLE_NOT_EXIST.getCode(), ErrorCode.ARTICLE_NOT_EXIST.getMsg());
        }
        ArticleVo articleVo = articleCopy.copy(article, true, true, true, true);
//        //查看完文章了，新增阅读数，有没有问题呢？
//        //查看完文章之后，本应该直接返回数据了，这时候做了一个更新操作，更新时加写锁，阻塞其他的读操作，性能就会比较低
//        // 更新 增加了此次接口的 耗时 如果一旦更新出问题，不能影响 查看文章的操作
//        //线程池  可以把更新操作 扔到线程池中去执行，和主线程就不相关了
        threadService.updateArticleViewCount(articleMapper, article);
        return Result.success(articleVo);
    }

    @Override
    public Result publish(ArticleParam articleParam) {
        SysUser sysUser = UserThreadLocal.get();
        Article article = new Article();
        article.setAuthorId(sysUser.getId());
        article.setWeight(Article.Article_Common);
        article.setViewCounts(0);
        article.setTitle(articleParam.getTitle());
        article.setSummary(articleParam.getSummary());
        article.setCommentCounts(0);
        article.setCreateTime(System.currentTimeMillis());
        article.setUpdateTime(System.currentTimeMillis());
        article.setCategoryId(Long.parseLong(articleParam.getCategory().getId()));

        // 插入之后生成文章id
        articleMapper.insert(article);
        List<TagVo> tags = articleParam.getTags();
        if (tags != null) {
            for (TagVo tag : tags) {
                Long articleId = article.getId();
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(Long.parseLong(tag.getId()));
                articleTag.setArticleId(articleId);
                articleTagMapper.insert(articleTag);
            }
        }
        ArticleBody articleBody = new ArticleBody();
        articleBody.setArticleId(article.getId());
        articleBody.setContent(articleParam.getBody().getContent());
        articleBody.setContentHtml(articleParam.getBody().getContentHtml());
        articleBodyMapper.insert(articleBody);

        article.setBodyId(articleBody.getId());
        articleMapper.updateById(article);

        // 发送消息
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGE_NAME, MqConstants.INSERT_ROUTING_KEY, article.getId());

        Map<String, String> map = new HashMap<>();
        map.put("id", article.getId().toString());
        return Result.success(map);
    }


    // 获取es中的数据实现搜索功能
    public Result searchArticle(String keyword, int page, int pageSize) throws Exception {
        SearchRequest searchRequest = new SearchRequest("articles");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 精准匹配
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("title", keyword);
        sourceBuilder.query(queryBuilder);

        // 高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);

        // 分页
        sourceBuilder.from((page - 1) * pageSize);
        sourceBuilder.size(pageSize);

        sourceBuilder.highlighter(highlightBuilder);

        ArrayList<Map<String, Object>> list = new ArrayList<>();
        // 执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        if (hits.getHits() != null && hits.getHits().length > 0) {
            for (SearchHit hit : hits.getHits()) {
                // 解析高亮字段，将原来的字段替换成高亮字段
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();//原来的结果
                if (sourceAsMap.containsKey("title")) {
                    HighlightField title = hit.getHighlightFields().get("title");//高亮字段
                    String string = title.getFragments()[0].string();//高亮内容
                    sourceAsMap.put("title", string);
                }
                list.add(sourceAsMap);
            }
        }
        return Result.success(list);
    }

    // 根据用户ID查询文章
    public Result findArticleByUserId(Long userId) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Article::getId, Article::getTitle, Article::getCreateTime);
        queryWrapper.eq(Article::getAuthorId, userId);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        List<ArticleVo> articleVoList = articleCopy.copyList(articles, true, true);
        return Result.success(articleVoList);
    }
}
