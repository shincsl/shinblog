/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScAdminPermission extends Serializable {

    /**
     * Setter for <code>shinblog.sc_admin_permission.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>shinblog.sc_admin_permission.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>shinblog.sc_admin_permission.admin_id</code>.
     */
    public void setAdminId(Long value);

    /**
     * Getter for <code>shinblog.sc_admin_permission.admin_id</code>.
     */
    public Long getAdminId();

    /**
     * Setter for <code>shinblog.sc_admin_permission.permission_id</code>.
     */
    public void setPermissionId(Long value);

    /**
     * Getter for <code>shinblog.sc_admin_permission.permission_id</code>.
     */
    public Long getPermissionId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScAdminPermission
     */
    public void from(IScAdminPermission from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScAdminPermission
     */
    public <E extends IScAdminPermission> E into(E into);
}
