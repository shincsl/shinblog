/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScArticleBody;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScArticleBody;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScArticleBodyRecord extends UpdatableRecordImpl<ScArticleBodyRecord> implements Record4<Long, String, String, Long>, IScArticleBody {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_article_body.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_article_body.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_article_body.content</code>.
     */
    @Override
    public void setContent(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_article_body.content</code>.
     */
    @Override
    public String getContent() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_article_body.content_html</code>.
     */
    @Override
    public void setContentHtml(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_article_body.content_html</code>.
     */
    @Override
    public String getContentHtml() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shinblog.sc_article_body.article_id</code>.
     */
    @Override
    public void setArticleId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>shinblog.sc_article_body.article_id</code>.
     */
    @Override
    public Long getArticleId() {
        return (Long) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TScArticleBody.SC_ARTICLE_BODY.ID;
    }

    @Override
    public Field<String> field2() {
        return TScArticleBody.SC_ARTICLE_BODY.CONTENT;
    }

    @Override
    public Field<String> field3() {
        return TScArticleBody.SC_ARTICLE_BODY.CONTENT_HTML;
    }

    @Override
    public Field<Long> field4() {
        return TScArticleBody.SC_ARTICLE_BODY.ARTICLE_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getContent();
    }

    @Override
    public String component3() {
        return getContentHtml();
    }

    @Override
    public Long component4() {
        return getArticleId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getContent();
    }

    @Override
    public String value3() {
        return getContentHtml();
    }

    @Override
    public Long value4() {
        return getArticleId();
    }

    @Override
    public ScArticleBodyRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ScArticleBodyRecord value2(String value) {
        setContent(value);
        return this;
    }

    @Override
    public ScArticleBodyRecord value3(String value) {
        setContentHtml(value);
        return this;
    }

    @Override
    public ScArticleBodyRecord value4(Long value) {
        setArticleId(value);
        return this;
    }

    @Override
    public ScArticleBodyRecord values(Long value1, String value2, String value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScArticleBody from) {
        setId(from.getId());
        setContent(from.getContent());
        setContentHtml(from.getContentHtml());
        setArticleId(from.getArticleId());
    }

    @Override
    public <E extends IScArticleBody> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScArticleBodyRecord
     */
    public ScArticleBodyRecord() {
        super(TScArticleBody.SC_ARTICLE_BODY);
    }

    /**
     * Create a detached, initialised ScArticleBodyRecord
     */
    public ScArticleBodyRecord(Long id, String content, String contentHtml, Long articleId) {
        super(TScArticleBody.SC_ARTICLE_BODY);

        setId(id);
        setContent(content);
        setContentHtml(contentHtml);
        setArticleId(articleId);
    }
}
