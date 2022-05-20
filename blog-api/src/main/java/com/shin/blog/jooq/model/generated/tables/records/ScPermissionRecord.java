/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScPermission;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScPermission;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScPermissionRecord extends UpdatableRecordImpl<ScPermissionRecord> implements Record4<Long, String, String, String>, IScPermission {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_permission.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_permission.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_permission.name</code>.
     */
    @Override
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_permission.name</code>.
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_permission.path</code>.
     */
    @Override
    public void setPath(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_permission.path</code>.
     */
    @Override
    public String getPath() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shinblog.sc_permission.description</code>.
     */
    @Override
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>shinblog.sc_permission.description</code>.
     */
    @Override
    public String getDescription() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TScPermission.SC_PERMISSION.ID;
    }

    @Override
    public Field<String> field2() {
        return TScPermission.SC_PERMISSION.NAME;
    }

    @Override
    public Field<String> field3() {
        return TScPermission.SC_PERMISSION.PATH;
    }

    @Override
    public Field<String> field4() {
        return TScPermission.SC_PERMISSION.DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getPath();
    }

    @Override
    public String component4() {
        return getDescription();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getPath();
    }

    @Override
    public String value4() {
        return getDescription();
    }

    @Override
    public ScPermissionRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ScPermissionRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ScPermissionRecord value3(String value) {
        setPath(value);
        return this;
    }

    @Override
    public ScPermissionRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ScPermissionRecord values(Long value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScPermission from) {
        setId(from.getId());
        setName(from.getName());
        setPath(from.getPath());
        setDescription(from.getDescription());
    }

    @Override
    public <E extends IScPermission> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScPermissionRecord
     */
    public ScPermissionRecord() {
        super(TScPermission.SC_PERMISSION);
    }

    /**
     * Create a detached, initialised ScPermissionRecord
     */
    public ScPermissionRecord(Long id, String name, String path, String description) {
        super(TScPermission.SC_PERMISSION);

        setId(id);
        setName(name);
        setPath(path);
        setDescription(description);
    }
}