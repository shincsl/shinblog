/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.daos;


import com.shin.blog.jooq.learn.extend.ExtendDAOImpl;
import com.shin.blog.jooq.model.entity.ScArticleTag;
import com.shin.blog.jooq.model.generated.tables.TScArticleTag;
import com.shin.blog.jooq.model.generated.tables.records.ScArticleTagRecord;

import java.util.List;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ScArticleTagDao extends ExtendDAOImpl<ScArticleTagRecord, ScArticleTag, Long> {

    /**
     * Create a new ScArticleTagDao without any configuration
     */
    public ScArticleTagDao() {
        super(TScArticleTag.SC_ARTICLE_TAG, ScArticleTag.class);
    }

    /**
     * Create a new ScArticleTagDao with an attached configuration
     */
    @Autowired
    public ScArticleTagDao(Configuration configuration) {
        super(TScArticleTag.SC_ARTICLE_TAG, ScArticleTag.class, configuration);
    }

    @Override
    public Long getId(ScArticleTag object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScArticleTag> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScArticleTag.SC_ARTICLE_TAG.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ScArticleTag> fetchById(Long... values) {
        return fetch(TScArticleTag.SC_ARTICLE_TAG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ScArticleTag fetchOneById(Long value) {
        return fetchOne(TScArticleTag.SC_ARTICLE_TAG.ID, value);
    }

    /**
     * Fetch records that have <code>article_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScArticleTag> fetchRangeOfArticleId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScArticleTag.SC_ARTICLE_TAG.ARTICLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>article_id IN (values)</code>
     */
    public List<ScArticleTag> fetchByArticleId(Long... values) {
        return fetch(TScArticleTag.SC_ARTICLE_TAG.ARTICLE_ID, values);
    }

    /**
     * Fetch records that have <code>tag_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScArticleTag> fetchRangeOfTagId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScArticleTag.SC_ARTICLE_TAG.TAG_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>tag_id IN (values)</code>
     */
    public List<ScArticleTag> fetchByTagId(Long... values) {
        return fetch(TScArticleTag.SC_ARTICLE_TAG.TAG_ID, values);
    }
}
