/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables;


import com.shin.blog.jooq.model.generated.Keys;
import com.shin.blog.jooq.model.generated.Shinblog;
import com.shin.blog.jooq.model.generated.tables.records.ScAdminPermissionRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TScAdminPermission extends TableImpl<ScAdminPermissionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>shinblog.sc_admin_permission</code>
     */
    public static final TScAdminPermission SC_ADMIN_PERMISSION = new TScAdminPermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScAdminPermissionRecord> getRecordType() {
        return ScAdminPermissionRecord.class;
    }

    /**
     * The column <code>shinblog.sc_admin_permission.id</code>.
     */
    public final TableField<ScAdminPermissionRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>shinblog.sc_admin_permission.admin_id</code>.
     */
    public final TableField<ScAdminPermissionRecord, Long> ADMIN_ID = createField(DSL.name("admin_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>shinblog.sc_admin_permission.permission_id</code>.
     */
    public final TableField<ScAdminPermissionRecord, Long> PERMISSION_ID = createField(DSL.name("permission_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private TScAdminPermission(Name alias, Table<ScAdminPermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private TScAdminPermission(Name alias, Table<ScAdminPermissionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>shinblog.sc_admin_permission</code> table reference
     */
    public TScAdminPermission(String alias) {
        this(DSL.name(alias), SC_ADMIN_PERMISSION);
    }

    /**
     * Create an aliased <code>shinblog.sc_admin_permission</code> table reference
     */
    public TScAdminPermission(Name alias) {
        this(alias, SC_ADMIN_PERMISSION);
    }

    /**
     * Create a <code>shinblog.sc_admin_permission</code> table reference
     */
    public TScAdminPermission() {
        this(DSL.name("sc_admin_permission"), null);
    }

    public <O extends Record> TScAdminPermission(Table<O> child, ForeignKey<O, ScAdminPermissionRecord> key) {
        super(child, key, SC_ADMIN_PERMISSION);
    }

    @Override
    public Schema getSchema() {
        return Shinblog.SHINBLOG;
    }

    @Override
    public Identity<ScAdminPermissionRecord, Long> getIdentity() {
        return (Identity<ScAdminPermissionRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ScAdminPermissionRecord> getPrimaryKey() {
        return Keys.KEY_SC_ADMIN_PERMISSION_PRIMARY;
    }

    @Override
    public List<UniqueKey<ScAdminPermissionRecord>> getKeys() {
        return Arrays.<UniqueKey<ScAdminPermissionRecord>>asList(Keys.KEY_SC_ADMIN_PERMISSION_PRIMARY);
    }

    @Override
    public TScAdminPermission as(String alias) {
        return new TScAdminPermission(DSL.name(alias), this);
    }

    @Override
    public TScAdminPermission as(Name alias) {
        return new TScAdminPermission(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TScAdminPermission rename(String name) {
        return new TScAdminPermission(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TScAdminPermission rename(Name name) {
        return new TScAdminPermission(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
