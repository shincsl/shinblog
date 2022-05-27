package com.shin.blog.service.impl;

import com.shin.blog.vo.constants.MqConstants;
import com.shin.blog.jooq.learn.extend.PageResult;
import com.shin.blog.jooq.model.entity.ScArticle;
import com.shin.blog.jooq.model.entity.ScArticleTag;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.entity.ScTag;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScArticle;
import com.shin.blog.jooq.model.generated.tables.TScArticleBody;
import com.shin.blog.jooq.model.generated.tables.TScArticleTag;
import com.shin.blog.jooq.model.generated.tables.daos.ScArticleDao;
import com.shin.blog.jooq.model.generated.tables.daos.ScArticleTagDao;
import com.shin.blog.jooq.model.generated.tables.records.ScArticleBodyRecord;
import com.shin.blog.jooq.model.generated.tables.records.ScArticleRecord;
import com.shin.blog.jooq.model.generated.tables.records.ScArticleTagRecord;
import com.shin.blog.service.ArticleService;
import com.shin.blog.service.ThreadService;
import com.shin.blog.utils.UUIDUtil;
import com.shin.blog.utils.UserThreadLocal;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.ArticleParam;
import com.shin.blog.vo.params.PageParams;
import org.apache.commons.lang3.StringUtils;
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
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SortField;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ThreadService threadService;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ArticleCopy articleCopy;
    @Autowired
    DSLContext dslContext;

    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 分页查询article数据库表
         */
        TScArticle article = Tables.SC_ARTICLE;
        Condition cnd = article.STATUS.eq("00");
        ScArticleDao scArticleDao = new ScArticleDao(dslContext.configuration());
        ScArticleTagDao scArticleTagDao = new ScArticleTagDao(dslContext.configuration());
        if (StringUtils.isNotEmpty(pageParams.getCategoryId())) {
            cnd = cnd.and(article.CATEGORY_ID.eq(pageParams.getCategoryId()));
        }
        List<String> articleIdList = new ArrayList<>();
        if (StringUtils.isNotEmpty(pageParams.getTagId())) {
            List<ScArticleTag> scArticleTags = scArticleTagDao.fetchByTagId(pageParams.getTagId());
            for (ScArticleTag articleTag : scArticleTags) {
                articleIdList.add(articleTag.getArticleId());
            }
            if (articleIdList.size() > 0) {
                cnd = cnd.and(article.ID.in(articleIdList));
            }
        }

        // 按照 是否置顶、创建时间 进行排序
        SortField<Timestamp> sort1 = article.CREATE_TIME.desc();
        SortField<Integer> sort2 = article.WEIGHT.desc();
        List<ScArticle> records = scArticleDao.fetchPage(new PageResult<>(pageParams.getPage(), pageParams.getPageSize()), cnd, sort1, sort2).getData();
        List<ScArticle> scArticleList = articleCopy.copyList(records, true, true);
        return Result.success(scArticleList);
    }

    @Override
    public Result findArticleById(String articleId) {
        /**
         * 1. 根据id查询 文章信息
         * 2. 根据bodyId和categoryid 去做关联查询
         */
        ScArticleDao scArticleDao = new ScArticleDao(dslContext.configuration());
        ScArticle article = scArticleDao.fetchOneById(articleId);
        if (article == null) {
            return Result.error(ErrorCode.ARTICLE_NOT_EXIST.getCode(), ErrorCode.ARTICLE_NOT_EXIST.getMsg());
        }
        ScArticle articleVo = articleCopy.copy(article, true, true, true, true);
//        //查看完文章了，新增阅读数，有没有问题呢？
//        //查看完文章之后，本应该直接返回数据了，这时候做了一个更新操作，更新时加写锁，阻塞其他的读操作，性能就会比较低
//        // 更新 增加了此次接口的 耗时 如果一旦更新出问题，不能影响 查看文章的操作
//        //线程池  可以把更新操作 扔到线程池中去执行，和主线程就不相关了
        threadService.updateArticleViewCount(dslContext, article);
        return Result.success(articleVo);
    }

    @Override
    public Result publish(ArticleParam articleParam) {
        ScSysUser sysUser = UserThreadLocal.get();
        TScArticle article = Tables.SC_ARTICLE;
        TScArticleTag articleTag = Tables.SC_ARTICLE_TAG;
        TScArticleBody articleBody = Tables.SC_ARTICLE_BODY;

        // 插入之后生成文章id
        ScArticleRecord articleRecord = dslContext.newRecord(article);
        articleRecord.set(article.ID, UUIDUtil.creatUUID());
        articleRecord.set(article.AUTHOR_ID, sysUser.getId());
        articleRecord.set(article.WEIGHT, 0);
        articleRecord.set(article.VIEW_COUNTS, 0);
        articleRecord.set(article.TITLE, articleParam.getTitle());
        articleRecord.set(article.SUMMARY, articleParam.getSummary());
        articleRecord.set(article.COMMENT_COUNTS, 0);
        articleRecord.set(article.CREATE_TIME, new Timestamp(System.currentTimeMillis()));
        articleRecord.set(article.UPDATE_TIME, new Timestamp(System.currentTimeMillis()));
        articleRecord.set(article.CATEGORY_ID, articleParam.getCategory().getId());
        articleRecord.insert();
        List<ScTag> tags = articleParam.getTags();
        if (tags != null) {
            for (ScTag tag : tags) {
                ScArticleTagRecord articleTagRecord = dslContext.newRecord(articleTag);
                articleTagRecord.set(articleTag.ID, UUIDUtil.creatUUID());
                articleTagRecord.set(articleTag.ARTICLE_ID, articleRecord.getId());
                articleTagRecord.set(articleTag.TAG_ID, tag.getId());
                articleTagRecord.insert();
            }
        }
        ScArticleBodyRecord articleBodyRecord = dslContext.newRecord(articleBody);
        articleBodyRecord.set(articleBody.ID, UUIDUtil.creatUUID());
        articleBodyRecord.set(articleBody.ARTICLE_ID, articleRecord.getId());
        articleBodyRecord.set(articleBody.CONTENT, articleParam.getBody().getContent());
        articleBodyRecord.set(articleBody.CONTENT_HTML, articleParam.getBody().getContentHtml());
        articleBodyRecord.insert();

        dslContext.update(article)
                .set(article.BODY_ID, articleBodyRecord.getId())
                .where(article.ID.eq(articleRecord.getId()))
                .execute();

        // 发送消息
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGE_NAME, MqConstants.INSERT_ROUTING_KEY, articleRecord.getId());

        Map<String, String> map = new HashMap<>();
        map.put("id", articleRecord.getId());
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
        TScArticle scArticle = Tables.SC_ARTICLE;
        List<ScArticle> articles = dslContext.select(scArticle.ID, scArticle.TITLE, scArticle.CREATE_TIME).from(scArticle).where(scArticle.AUTHOR_ID.eq(userId)).fetchInto(ScArticle.class);
        return Result.success(articles);
    }
}
