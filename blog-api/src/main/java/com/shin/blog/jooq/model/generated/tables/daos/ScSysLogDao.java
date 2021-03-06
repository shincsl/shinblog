/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.daos;


import com.shin.blog.jooq.learn.extend.ExtendDAOImpl;
import com.shin.blog.jooq.model.entity.ScSysLog;
import com.shin.blog.jooq.model.generated.tables.TScSysLog;
import com.shin.blog.jooq.model.generated.tables.records.ScSysLogRecord;

import java.util.List;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ScSysLogDao extends ExtendDAOImpl<ScSysLogRecord, ScSysLog, Long> {

    /**
     * Create a new ScSysLogDao without any configuration
     */
    public ScSysLogDao() {
        super(TScSysLog.SC_SYS_LOG, ScSysLog.class);
    }

    /**
     * Create a new ScSysLogDao with an attached configuration
     */
    @Autowired
    public ScSysLogDao(Configuration configuration) {
        super(TScSysLog.SC_SYS_LOG, ScSysLog.class, configuration);
    }

    @Override
    public Long getId(ScSysLog object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ScSysLog> fetchById(Long... values) {
        return fetch(TScSysLog.SC_SYS_LOG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ScSysLog fetchOneById(Long value) {
        return fetchOne(TScSysLog.SC_SYS_LOG.ID, value);
    }

    /**
     * Fetch records that have <code>create_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfCreateDate(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.CREATE_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_date IN (values)</code>
     */
    public List<ScSysLog> fetchByCreateDate(Long... values) {
        return fetch(TScSysLog.SC_SYS_LOG.CREATE_DATE, values);
    }

    /**
     * Fetch records that have <code>ip BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfIp(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.IP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ip IN (values)</code>
     */
    public List<ScSysLog> fetchByIp(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.IP, values);
    }

    /**
     * Fetch records that have <code>method BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfMethod(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.METHOD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>method IN (values)</code>
     */
    public List<ScSysLog> fetchByMethod(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.METHOD, values);
    }

    /**
     * Fetch records that have <code>module BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfModule(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.MODULE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>module IN (values)</code>
     */
    public List<ScSysLog> fetchByModule(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.MODULE, values);
    }

    /**
     * Fetch records that have <code>nickname BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfNickname(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.NICKNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>nickname IN (values)</code>
     */
    public List<ScSysLog> fetchByNickname(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.NICKNAME, values);
    }

    /**
     * Fetch records that have <code>operation BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfOperation(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.OPERATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>operation IN (values)</code>
     */
    public List<ScSysLog> fetchByOperation(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.OPERATION, values);
    }

    /**
     * Fetch records that have <code>params BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfParams(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.PARAMS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>params IN (values)</code>
     */
    public List<ScSysLog> fetchByParams(String... values) {
        return fetch(TScSysLog.SC_SYS_LOG.PARAMS, values);
    }

    /**
     * Fetch records that have <code>time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfTime(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>time IN (values)</code>
     */
    public List<ScSysLog> fetchByTime(Long... values) {
        return fetch(TScSysLog.SC_SYS_LOG.TIME, values);
    }

    /**
     * Fetch records that have <code>userid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysLog> fetchRangeOfUserid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysLog.SC_SYS_LOG.USERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userid IN (values)</code>
     */
    public List<ScSysLog> fetchByUserid(Long... values) {
        return fetch(TScSysLog.SC_SYS_LOG.USERID, values);
    }
}
