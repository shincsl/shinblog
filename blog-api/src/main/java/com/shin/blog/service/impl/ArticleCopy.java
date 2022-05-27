package com.shin.blog.service.impl;

import com.shin.blog.jooq.model.entity.ScArticle;
import com.shin.blog.jooq.model.entity.ScArticleBody;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.entity.ScTag;
import com.shin.blog.jooq.model.generated.tables.daos.ScArticleBodyDao;
import com.shin.blog.jooq.model.generated.tables.daos.ScCategoryDao;
import com.shin.blog.jooq.model.generated.tables.daos.ScSysUserDao;
import com.shin.blog.service.CategoryService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.service.TagService;
import com.shin.blog.vo.ArticleBodyVo;
import org.jooq.DSLContext;
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
    CategoryService categoryService;

    @Autowired
    DSLContext dslContext;

    public List<ScArticle> copyList(List<ScArticle> records, boolean isTag, boolean isAuthor) {
        List<ScArticle> scArticleList = new ArrayList<>();
        for (ScArticle record : records) {
            scArticleList.add(copy(record, isTag, isAuthor, false, false));
        }
        return scArticleList;
    }

    public List<ScArticle> copyList(List<ScArticle> records, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        List<ScArticle> articleVoList = new ArrayList<>();
        for (ScArticle record : records) {
            articleVoList.add(copy(record, isTag, isAuthor, isBody, isCategory));
        }
        return articleVoList;
    }

    public ScArticle copy(ScArticle article, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        //不是所有的接口都需要标签、作者信息
        if (isTag) {
            String articleId = article.getId();
            List<ScTag> tags = tagService.findTagsByArticleId(articleId);
            article.setTags(tags);
        }
        if (isAuthor) {
            Long authorId = article.getAuthorId();
            ScSysUserDao scSysUserDao = new ScSysUserDao(dslContext.configuration());
            ScSysUser scSysUser = scSysUserDao.fetchOneById(authorId);
            article.setAuthor(scSysUser.getNickname());
            article.setAvatar(scSysUser.getAvatar());
        }
        if (isBody) {
            String bodyId = article.getBodyId();
            article.setBody(findArticleBodyById(bodyId));
        }
        if (isCategory) {
            String categoryId = article.getCategoryId();
            ScCategoryDao scCategoryDao = new ScCategoryDao(dslContext.configuration());
            article.setCategory(scCategoryDao.fetchOneById(categoryId));
        }
        return article;
    }

    public ArticleBodyVo findArticleBodyById(String bodyId) {
        ScArticleBodyDao scArticleBodyDao = new ScArticleBodyDao(dslContext.configuration());
        ScArticleBody scArticleBody = scArticleBodyDao.fetchOneById(bodyId);
        ArticleBodyVo articleBodyVo = new ArticleBodyVo();
        articleBodyVo.setContent(scArticleBody.getContent());
        return articleBodyVo;
    }
}
