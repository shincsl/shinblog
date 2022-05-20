/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScSysUser extends Serializable {

    /**
     * Setter for <code>shinblog.sc_sys_user.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_user.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>shinblog.sc_sys_user.account</code>. 账号
     */
    public void setAccount(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.account</code>. 账号
     */
    public String getAccount();

    /**
     * Setter for <code>shinblog.sc_sys_user.admin</code>. 是否管理员
     */
    public void setAdmin(Boolean value);

    /**
     * Getter for <code>shinblog.sc_sys_user.admin</code>. 是否管理员
     */
    public Boolean getAdmin();

    /**
     * Setter for <code>shinblog.sc_sys_user.avatar</code>. 头像
     */
    public void setAvatar(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.avatar</code>. 头像
     */
    public String getAvatar();

    /**
     * Setter for <code>shinblog.sc_sys_user.create_date</code>. 注册时间
     */
    public void setCreateDate(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_user.create_date</code>. 注册时间
     */
    public Long getCreateDate();

    /**
     * Setter for <code>shinblog.sc_sys_user.deleted</code>. 是否删除
     */
    public void setDeleted(Boolean value);

    /**
     * Getter for <code>shinblog.sc_sys_user.deleted</code>. 是否删除
     */
    public Boolean getDeleted();

    /**
     * Setter for <code>shinblog.sc_sys_user.email</code>. 邮箱
     */
    public void setEmail(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.email</code>. 邮箱
     */
    public String getEmail();

    /**
     * Setter for <code>shinblog.sc_sys_user.last_login</code>. 最后登录时间
     */
    public void setLastLogin(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_user.last_login</code>. 最后登录时间
     */
    public Long getLastLogin();

    /**
     * Setter for <code>shinblog.sc_sys_user.mobile_phone_number</code>. 手机号
     */
    public void setMobilePhoneNumber(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.mobile_phone_number</code>. 手机号
     */
    public String getMobilePhoneNumber();

    /**
     * Setter for <code>shinblog.sc_sys_user.nickname</code>. 昵称
     */
    public void setNickname(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.nickname</code>. 昵称
     */
    public String getNickname();

    /**
     * Setter for <code>shinblog.sc_sys_user.password</code>. 密码
     */
    public void setPassword(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.password</code>. 密码
     */
    public String getPassword();

    /**
     * Setter for <code>shinblog.sc_sys_user.salt</code>. 加密盐
     */
    public void setSalt(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.salt</code>. 加密盐
     */
    public String getSalt();

    /**
     * Setter for <code>shinblog.sc_sys_user.status</code>. 状态
     */
    public void setStatus(String value);

    /**
     * Getter for <code>shinblog.sc_sys_user.status</code>. 状态
     */
    public String getStatus();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScSysUser
     */
    public void from(IScSysUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScSysUser
     */
    public <E extends IScSysUser> E into(E into);
}
