/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScCategory extends Serializable {

    /**
     * Setter for <code>shinblog.sc_category.id</code>.
     */
    public void setId(String value);

    /**
     * Getter for <code>shinblog.sc_category.id</code>.
     */
    public String getId();

    /**
     * Setter for <code>shinblog.sc_category.avatar</code>.
     */
    public void setAvatar(String value);

    /**
     * Getter for <code>shinblog.sc_category.avatar</code>.
     */
    public String getAvatar();

    /**
     * Setter for <code>shinblog.sc_category.category_name</code>.
     */
    public void setCategoryName(String value);

    /**
     * Getter for <code>shinblog.sc_category.category_name</code>.
     */
    public String getCategoryName();

    /**
     * Setter for <code>shinblog.sc_category.description</code>.
     */
    public void setDescription(String value);

    /**
     * Getter for <code>shinblog.sc_category.description</code>.
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScCategory
     */
    public void from(IScCategory from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScCategory
     */
    public <E extends IScCategory> E into(E into);
}
