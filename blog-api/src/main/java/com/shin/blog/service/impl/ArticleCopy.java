package com.shin.blog.service.impl;

import com.shin.blog.dao.mapper.ArticleBodyMapper;
import com.shin.blog.dao.pojo.Article;
import com.shin.blog.dao.pojo.ArticleBody;
import com.shin.blog.dao.pojo.SysUser;
import com.shin.blog.service.CategoryService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.service.TagService;
import com.shin.blog.vo.ArticleBodyVo;
import com.shin.blog.vo.ArticleVo;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleCopy {

    @Autowired
    TagService tagService;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    ArticleBodyMapper articleBodyMapper;

    @Autowired
    CategoryService categoryService;

    public List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record, isTag, isAuthor, false, false));
        }
        return articleVoList;
    }

    public List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record, isTag, isAuthor, isBody, isCategory));
        }
        return articleVoList;
    }

    public ArticleVo copy(Article article, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(String.valueOf(article.getId()));
        BeanUtils.copyProperties(article, articleVo);

        articleVo.setCreateTime(new DateTime(article.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
        articleVo.setUpdateTime(new DateTime(article.getUpdateTime()).toString("yyyy-MM-dd HH:mm"));

        //不是所有的接口都需要标签、作者信息
        if (isTag) {
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if (isAuthor) {
            Long authorId = article.getAuthorId();
            SysUser user = sysUserService.findUserById(authorId);
            articleVo.setAuthor(user.getNickname());
            articleVo.setAvatar(user.getAvatar());
        }
        if (isBody) {
            Long bodyId = article.getBodyId();
            articleVo.setBody(findArticleBodyById(bodyId));
        }
        if (isCategory) {
            Long categoryId = article.getCategoryId();
            articleVo.setCategory(categoryService.findCategoryById(categoryId));
        }
        return articleVo;
    }

    public ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody articleBody = articleBodyMapper.selectById(bodyId);
        ArticleBodyVo articleBodyVo = new ArticleBodyVo();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }
}
