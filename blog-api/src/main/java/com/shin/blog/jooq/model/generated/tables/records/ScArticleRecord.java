/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScArticle;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScArticle;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScArticleRecord extends UpdatableRecordImpl<ScArticleRecord> implements Record13<String, Integer, String, Integer, Timestamp, Timestamp, String, String, Integer, Integer, Long, String, String>, IScArticle {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_article.id</code>.
     */
    @Override
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.id</code>.
     */
    @Override
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_article.deleted</code>. 逻辑删除标识,0标识未删除,1标识已删除
     */
    @Override
    public void setDeleted(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.deleted</code>. 逻辑删除标识,0标识未删除,1标识已删除
     */
    @Override
    public Integer getDeleted() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_article.status</code>. 状态00在用01作废
     */
    @Override
    public void setStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.status</code>. 状态00在用01作废
     */
    @Override
    public String getStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shinblog.sc_article.comment_counts</code>. 评论数量
     */
    @Override
    public void setCommentCounts(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.comment_counts</code>. 评论数量
     */
    @Override
    public Integer getCommentCounts() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>shinblog.sc_article.create_time</code>. 创建时间
     */
    @Override
    public void setCreateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.create_time</code>. 创建时间
     */
    @Override
    public Timestamp getCreateTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>shinblog.sc_article.update_time</code>. 更新时间
     */
    @Override
    public void setUpdateTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.update_time</code>. 更新时间
     */
    @Override
    public Timestamp getUpdateTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>shinblog.sc_article.summary</code>. 简介
     */
    @Override
    public void setSummary(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.summary</code>. 简介
     */
    @Override
    public String getSummary() {
        return (String) get(6);
    }

    /**
     * Setter for <code>shinblog.sc_article.title</code>. 标题
     */
    @Override
    public void setTitle(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.title</code>. 标题
     */
    @Override
    public String getTitle() {
        return (String) get(7);
    }

    /**
     * Setter for <code>shinblog.sc_article.view_counts</code>. 浏览数量
     */
    @Override
    public void setViewCounts(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.view_counts</code>. 浏览数量
     */
    @Override
    public Integer getViewCounts() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>shinblog.sc_article.weight</code>. 是否置顶
     */
    @Override
    public void setWeight(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.weight</code>. 是否置顶
     */
    @Override
    public Integer getWeight() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>shinblog.sc_article.author_id</code>. 作者id
     */
    @Override
    public void setAuthorId(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.author_id</code>. 作者id
     */
    @Override
    public Long getAuthorId() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>shinblog.sc_article.body_id</code>. 内容id
     */
    @Override
    public void setBodyId(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.body_id</code>. 内容id
     */
    @Override
    public String getBodyId() {
        return (String) get(11);
    }

    /**
     * Setter for <code>shinblog.sc_article.category_id</code>. 类别id
     */
    @Override
    public void setCategoryId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>shinblog.sc_article.category_id</code>. 类别id
     */
    @Override
    public String getCategoryId() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<String, Integer, String, Integer, Timestamp, Timestamp, String, String, Integer, Integer, Long, String, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<String, Integer, String, Integer, Timestamp, Timestamp, String, String, Integer, Integer, Long, String, String> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TScArticle.SC_ARTICLE.ID;
    }

    @Override
    public Field<Integer> field2() {
        return TScArticle.SC_ARTICLE.DELETED;
    }

    @Override
    public Field<String> field3() {
        return TScArticle.SC_ARTICLE.STATUS;
    }

    @Override
    public Field<Integer> field4() {
        return TScArticle.SC_ARTICLE.COMMENT_COUNTS;
    }

    @Override
    public Field<Timestamp> field5() {
        return TScArticle.SC_ARTICLE.CREATE_TIME;
    }

    @Override
    public Field<Timestamp> field6() {
        return TScArticle.SC_ARTICLE.UPDATE_TIME;
    }

    @Override
    public Field<String> field7() {
        return TScArticle.SC_ARTICLE.SUMMARY;
    }

    @Override
    public Field<String> field8() {
        return TScArticle.SC_ARTICLE.TITLE;
    }

    @Override
    public Field<Integer> field9() {
        return TScArticle.SC_ARTICLE.VIEW_COUNTS;
    }

    @Override
    public Field<Integer> field10() {
        return TScArticle.SC_ARTICLE.WEIGHT;
    }

    @Override
    public Field<Long> field11() {
        return TScArticle.SC_ARTICLE.AUTHOR_ID;
    }

    @Override
    public Field<String> field12() {
        return TScArticle.SC_ARTICLE.BODY_ID;
    }

    @Override
    public Field<String> field13() {
        return TScArticle.SC_ARTICLE.CATEGORY_ID;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getDeleted();
    }

    @Override
    public String component3() {
        return getStatus();
    }

    @Override
    public Integer component4() {
        return getCommentCounts();
    }

    @Override
    public Timestamp component5() {
        return getCreateTime();
    }

    @Override
    public Timestamp component6() {
        return getUpdateTime();
    }

    @Override
    public String component7() {
        return getSummary();
    }

    @Override
    public String component8() {
        return getTitle();
    }

    @Override
    public Integer component9() {
        return getViewCounts();
    }

    @Override
    public Integer component10() {
        return getWeight();
    }

    @Override
    public Long component11() {
        return getAuthorId();
    }

    @Override
    public String component12() {
        return getBodyId();
    }

    @Override
    public String component13() {
        return getCategoryId();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getDeleted();
    }

    @Override
    public String value3() {
        return getStatus();
    }

    @Override
    public Integer value4() {
        return getCommentCounts();
    }

    @Override
    public Timestamp value5() {
        return getCreateTime();
    }

    @Override
    public Timestamp value6() {
        return getUpdateTime();
    }

    @Override
    public String value7() {
        return getSummary();
    }

    @Override
    public String value8() {
        return getTitle();
    }

    @Override
    public Integer value9() {
        return getViewCounts();
    }

    @Override
    public Integer value10() {
        return getWeight();
    }

    @Override
    public Long value11() {
        return getAuthorId();
    }

    @Override
    public String value12() {
        return getBodyId();
    }

    @Override
    public String value13() {
        return getCategoryId();
    }

    @Override
    public ScArticleRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ScArticleRecord value2(Integer value) {
        setDeleted(value);
        return this;
    }

    @Override
    public ScArticleRecord value3(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ScArticleRecord value4(Integer value) {
        setCommentCounts(value);
        return this;
    }

    @Override
    public ScArticleRecord value5(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public ScArticleRecord value6(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public ScArticleRecord value7(String value) {
        setSummary(value);
        return this;
    }

    @Override
    public ScArticleRecord value8(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public ScArticleRecord value9(Integer value) {
        setViewCounts(value);
        return this;
    }

    @Override
    public ScArticleRecord value10(Integer value) {
        setWeight(value);
        return this;
    }

    @Override
    public ScArticleRecord value11(Long value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public ScArticleRecord value12(String value) {
        setBodyId(value);
        return this;
    }

    @Override
    public ScArticleRecord value13(String value) {
        setCategoryId(value);
        return this;
    }

    @Override
    public ScArticleRecord values(String value1, Integer value2, String value3, Integer value4, Timestamp value5, Timestamp value6, String value7, String value8, Integer value9, Integer value10, Long value11, String value12, String value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScArticle from) {
        setId(from.getId());
        setDeleted(from.getDeleted());
        setStatus(from.getStatus());
        setCommentCounts(from.getCommentCounts());
        setCreateTime(from.getCreateTime());
        setUpdateTime(from.getUpdateTime());
        setSummary(from.getSummary());
        setTitle(from.getTitle());
        setViewCounts(from.getViewCounts());
        setWeight(from.getWeight());
        setAuthorId(from.getAuthorId());
        setBodyId(from.getBodyId());
        setCategoryId(from.getCategoryId());
    }

    @Override
    public <E extends IScArticle> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScArticleRecord
     */
    public ScArticleRecord() {
        super(TScArticle.SC_ARTICLE);
    }

    /**
     * Create a detached, initialised ScArticleRecord
     */
    public ScArticleRecord(String id, Integer deleted, String status, Integer commentCounts, Timestamp createTime, Timestamp updateTime, String summary, String title, Integer viewCounts, Integer weight, Long authorId, String bodyId, String categoryId) {
        super(TScArticle.SC_ARTICLE);

        setId(id);
        setDeleted(deleted);
        setStatus(status);
        setCommentCounts(commentCounts);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
        setSummary(summary);
        setTitle(title);
        setViewCounts(viewCounts);
        setWeight(weight);
        setAuthorId(authorId);
        setBodyId(bodyId);
        setCategoryId(categoryId);
    }
}
