/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.daos;


import com.shin.blog.jooq.learn.extend.ExtendDAOImpl;
import com.shin.blog.jooq.model.entity.ScAdminPermission;
import com.shin.blog.jooq.model.generated.tables.TScAdminPermission;
import com.shin.blog.jooq.model.generated.tables.records.ScAdminPermissionRecord;

import java.util.List;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ScAdminPermissionDao extends ExtendDAOImpl<ScAdminPermissionRecord, ScAdminPermission, Long> {

    /**
     * Create a new ScAdminPermissionDao without any configuration
     */
    public ScAdminPermissionDao() {
        super(TScAdminPermission.SC_ADMIN_PERMISSION, ScAdminPermission.class);
    }

    /**
     * Create a new ScAdminPermissionDao with an attached configuration
     */
    @Autowired
    public ScAdminPermissionDao(Configuration configuration) {
        super(TScAdminPermission.SC_ADMIN_PERMISSION, ScAdminPermission.class, configuration);
    }

    @Override
    public Long getId(ScAdminPermission object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScAdminPermission> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScAdminPermission.SC_ADMIN_PERMISSION.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ScAdminPermission> fetchById(Long... values) {
        return fetch(TScAdminPermission.SC_ADMIN_PERMISSION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ScAdminPermission fetchOneById(Long value) {
        return fetchOne(TScAdminPermission.SC_ADMIN_PERMISSION.ID, value);
    }

    /**
     * Fetch records that have <code>admin_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScAdminPermission> fetchRangeOfAdminId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScAdminPermission.SC_ADMIN_PERMISSION.ADMIN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>admin_id IN (values)</code>
     */
    public List<ScAdminPermission> fetchByAdminId(Long... values) {
        return fetch(TScAdminPermission.SC_ADMIN_PERMISSION.ADMIN_ID, values);
    }

    /**
     * Fetch records that have <code>permission_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<ScAdminPermission> fetchRangeOfPermissionId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TScAdminPermission.SC_ADMIN_PERMISSION.PERMISSION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>permission_id IN (values)</code>
     */
    public List<ScAdminPermission> fetchByPermissionId(Long... values) {
        return fetch(TScAdminPermission.SC_ADMIN_PERMISSION.PERMISSION_ID, values);
    }
}
