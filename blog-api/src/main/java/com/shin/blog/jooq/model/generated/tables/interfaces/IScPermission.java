/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScPermission extends Serializable {

    /**
     * Setter for <code>shinblog.sc_permission.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>shinblog.sc_permission.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>shinblog.sc_permission.name</code>.
     */
    public void setName(String value);

    /**
     * Getter for <code>shinblog.sc_permission.name</code>.
     */
    public String getName();

    /**
     * Setter for <code>shinblog.sc_permission.path</code>.
     */
    public void setPath(String value);

    /**
     * Getter for <code>shinblog.sc_permission.path</code>.
     */
    public String getPath();

    /**
     * Setter for <code>shinblog.sc_permission.description</code>.
     */
    public void setDescription(String value);

    /**
     * Getter for <code>shinblog.sc_permission.description</code>.
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScPermission
     */
    public void from(IScPermission from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScPermission
     */
    public <E extends IScPermission> E into(E into);
}
