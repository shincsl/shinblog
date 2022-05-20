/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.interfaces;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IScSysLog extends Serializable {

    /**
     * Setter for <code>shinblog.sc_sys_log.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_log.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>shinblog.sc_sys_log.create_date</code>.
     */
    public void setCreateDate(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_log.create_date</code>.
     */
    public Long getCreateDate();

    /**
     * Setter for <code>shinblog.sc_sys_log.ip</code>.
     */
    public void setIp(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.ip</code>.
     */
    public String getIp();

    /**
     * Setter for <code>shinblog.sc_sys_log.method</code>.
     */
    public void setMethod(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.method</code>.
     */
    public String getMethod();

    /**
     * Setter for <code>shinblog.sc_sys_log.module</code>.
     */
    public void setModule(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.module</code>.
     */
    public String getModule();

    /**
     * Setter for <code>shinblog.sc_sys_log.nickname</code>.
     */
    public void setNickname(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.nickname</code>.
     */
    public String getNickname();

    /**
     * Setter for <code>shinblog.sc_sys_log.operation</code>.
     */
    public void setOperation(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.operation</code>.
     */
    public String getOperation();

    /**
     * Setter for <code>shinblog.sc_sys_log.params</code>.
     */
    public void setParams(String value);

    /**
     * Getter for <code>shinblog.sc_sys_log.params</code>.
     */
    public String getParams();

    /**
     * Setter for <code>shinblog.sc_sys_log.time</code>.
     */
    public void setTime(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_log.time</code>.
     */
    public Long getTime();

    /**
     * Setter for <code>shinblog.sc_sys_log.userid</code>.
     */
    public void setUserid(Long value);

    /**
     * Getter for <code>shinblog.sc_sys_log.userid</code>.
     */
    public Long getUserid();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IScSysLog
     */
    public void from(IScSysLog from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IScSysLog
     */
    public <E extends IScSysLog> E into(E into);
}
