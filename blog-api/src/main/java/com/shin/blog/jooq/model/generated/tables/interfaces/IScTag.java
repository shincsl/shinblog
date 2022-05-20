/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScTag extends Serializable {

    /**
     * Setter for <code>shinblog.sc_tag.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>shinblog.sc_tag.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>shinblog.sc_tag.avatar</code>.
     */
    public void setAvatar(String value);

    /**
     * Getter for <code>shinblog.sc_tag.avatar</code>.
     */
    public String getAvatar();

    /**
     * Setter for <code>shinblog.sc_tag.tag_name</code>.
     */
    public void setTagName(String value);

    /**
     * Getter for <code>shinblog.sc_tag.tag_name</code>.
     */
    public String getTagName();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScTag
     */
    public void from(IScTag from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScTag
     */
    public <E extends IScTag> E into(E into);
}
