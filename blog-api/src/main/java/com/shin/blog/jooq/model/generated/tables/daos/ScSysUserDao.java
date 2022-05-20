/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.daos;


import com.shin.blog.jooq.learn.extend.ExtendDAOImpl;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.generated.tables.TScSysUser;
import com.shin.blog.jooq.model.generated.tables.records.ScSysUserRecord;

import java.util.List;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ScSysUserDao extends ExtendDAOImpl<ScSysUserRecord, ScSysUser, Long> {

    /**
     * Create a new ScSysUserDao without any configuration
     */
    public ScSysUserDao() {
        super(TScSysUser.SC_SYS_USER, ScSysUser.class);
    }

    /**
     * Create a new ScSysUserDao with an attached configuration
     */
    @Autowired
    public ScSysUserDao(Configuration configuration) {
        super(TScSysUser.SC_SYS_USER, ScSysUser.class, configuration);
    }

    @Override
    public Long getId(ScSysUser object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ScSysUser> fetchById(Long... values) {
        return fetch(TScSysUser.SC_SYS_USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ScSysUser fetchOneById(Long value) {
        return fetchOne(TScSysUser.SC_SYS_USER.ID, value);
    }

    /**
     * Fetch records that have <code>account BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfAccount(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.ACCOUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>account IN (values)</code>
     */
    public List<ScSysUser> fetchByAccount(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.ACCOUNT, values);
    }

    /**
     * Fetch records that have <code>admin BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfAdmin(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.ADMIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>admin IN (values)</code>
     */
    public List<ScSysUser> fetchByAdmin(Boolean... values) {
        return fetch(TScSysUser.SC_SYS_USER.ADMIN, values);
    }

    /**
     * Fetch records that have <code>avatar BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfAvatar(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.AVATAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>avatar IN (values)</code>
     */
    public List<ScSysUser> fetchByAvatar(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.AVATAR, values);
    }

    /**
     * Fetch records that have <code>create_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfCreateDate(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.CREATE_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_date IN (values)</code>
     */
    public List<ScSysUser> fetchByCreateDate(Long... values) {
        return fetch(TScSysUser.SC_SYS_USER.CREATE_DATE, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<ScSysUser> fetchByDeleted(Boolean... values) {
        return fetch(TScSysUser.SC_SYS_USER.DELETED, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<ScSysUser> fetchByEmail(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.EMAIL, values);
    }

    /**
     * Fetch records that have <code>last_login BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfLastLogin(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.LAST_LOGIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_login IN (values)</code>
     */
    public List<ScSysUser> fetchByLastLogin(Long... values) {
        return fetch(TScSysUser.SC_SYS_USER.LAST_LOGIN, values);
    }

    /**
     * Fetch records that have <code>mobile_phone_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfMobilePhoneNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.MOBILE_PHONE_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>mobile_phone_number IN (values)</code>
     */
    public List<ScSysUser> fetchByMobilePhoneNumber(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.MOBILE_PHONE_NUMBER, values);
    }

    /**
     * Fetch records that have <code>nickname BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfNickname(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.NICKNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>nickname IN (values)</code>
     */
    public List<ScSysUser> fetchByNickname(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.NICKNAME, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<ScSysUser> fetchByPassword(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>salt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfSalt(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.SALT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>salt IN (values)</code>
     */
    public List<ScSysUser> fetchBySalt(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.SALT, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScSysUser> fetchRangeOfStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(TScSysUser.SC_SYS_USER.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<ScSysUser> fetchByStatus(String... values) {
        return fetch(TScSysUser.SC_SYS_USER.STATUS, values);
    }
}