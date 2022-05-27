package com.shin.blog.service.impl;

import com.shin.blog.jooq.model.entity.ScTag;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScArticleTag;
import com.shin.blog.jooq.model.generated.tables.TScTag;
import com.shin.blog.jooq.model.generated.tables.daos.ScTagDao;
import com.shin.blog.service.TagService;
import com.shin.blog.vo.Result;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<ScTag> findTagsByArticleId(String articleId) {
        TScTag tag = Tables.SC_TAG;
        TScArticleTag articleTag = Tables.SC_ARTICLE_TAG;
        List<String> tagIds = dslContext.select(articleTag.TAG_ID).from(articleTag).where(articleTag.ARTICLE_ID.eq(articleId)).fetch(articleTag.TAG_ID);
        List<ScTag> tags = dslContext.select().from(tag).where(tag.ID.in(tagIds)).fetchInto(ScTag.class);
        return tags;
    }

    @Override
    public Result hots(int limit) {
        TScArticleTag articleTag = Tables.SC_ARTICLE_TAG;
        TScTag tag = Tables.SC_TAG;
        List<String> hotsTagIds = dslContext.select(articleTag.TAG_ID).from(articleTag).groupBy(articleTag.TAG_ID).orderBy(DSL.count()).limit(limit).fetch(articleTag.TAG_ID);
        if (CollectionUtils.isEmpty(hotsTagIds)){
            return Result.success(Collections.emptyList());
        }
        List<ScTag> tagsList = dslContext.select(tag.ID, tag.TAG_NAME).from(tag).where(tag.ID.in(hotsTagIds)).fetchInto(ScTag.class);
        return Result.success(tagsList);
    }

    @Override
    public Result findAll() {
        TScTag tag = Tables.SC_TAG;
        List<ScTag> tags = dslContext.select(tag.ID, tag.TAG_NAME).from(tag).fetchInto(ScTag.class);
        return Result.success(tags);
    }

    @Override
    public Result findAllDetail() {
        TScTag tag = Tables.SC_TAG;
        List<ScTag> tags = dslContext.select().from(tag).fetchInto(ScTag.class);
        return Result.success(tags);
    }

    @Override
    public Result findAllDetailById(String id) {
        ScTagDao tagDao = new ScTagDao(dslContext.configuration());
        ScTag tag = tagDao.fetchOneById(id);
        return Result.success(tag);
    }

}
