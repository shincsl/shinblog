/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.pojos;


import com.shin.blog.jooq.model.generated.tables.interfaces.IScArticleTag;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScArticleTagPojo implements IScArticleTag {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long articleId;
    private Long tagId;

    public ScArticleTagPojo() {}

    public ScArticleTagPojo(IScArticleTag value) {
        this.id = value.getId();
        this.articleId = value.getArticleId();
        this.tagId = value.getTagId();
    }

    public ScArticleTagPojo(
        Long id,
        Long articleId,
        Long tagId
    ) {
        this.id = id;
        this.articleId = articleId;
        this.tagId = tagId;
    }

    /**
     * Getter for <code>shinblog.sc_article_tag.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>shinblog.sc_article_tag.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>shinblog.sc_article_tag.article_id</code>.
     */
    @Override
    public Long getArticleId() {
        return this.articleId;
    }

    /**
     * Setter for <code>shinblog.sc_article_tag.article_id</code>.
     */
    @Override
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * Getter for <code>shinblog.sc_article_tag.tag_id</code>.
     */
    @Override
    public Long getTagId() {
        return this.tagId;
    }

    /**
     * Setter for <code>shinblog.sc_article_tag.tag_id</code>.
     */
    @Override
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ScArticleTagPojo (");

        sb.append(id);
        sb.append(", ").append(articleId);
        sb.append(", ").append(tagId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScArticleTag from) {
        setId(from.getId());
        setArticleId(from.getArticleId());
        setTagId(from.getTagId());
    }

    @Override
    public <E extends IScArticleTag> E into(E into) {
        into.from(this);
        return into;
    }
}