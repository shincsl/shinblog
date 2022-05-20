/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScAdmin;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScAdmin;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScAdminRecord extends UpdatableRecordImpl<ScAdminRecord> implements Record3<Long, String, String>, IScAdmin {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_admin.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_admin.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_admin.username</code>.
     */
    @Override
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_admin.username</code>.
     */
    @Override
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_admin.password</code>.
     */
    @Override
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_admin.password</code>.
     */
    @Override
    public String getPassword() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TScAdmin.SC_ADMIN.ID;
    }

    @Override
    public Field<String> field2() {
        return TScAdmin.SC_ADMIN.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return TScAdmin.SC_ADMIN.PASSWORD;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public ScAdminRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ScAdminRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public ScAdminRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public ScAdminRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScAdmin from) {
        setId(from.getId());
        setUsername(from.getUsername());
        setPassword(from.getPassword());
    }

    @Override
    public <E extends IScAdmin> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScAdminRecord
     */
    public ScAdminRecord() {
        super(TScAdmin.SC_ADMIN);
    }

    /**
     * Create a detached, initialised ScAdminRecord
     */
    public ScAdminRecord(Long id, String username, String password) {
        super(TScAdmin.SC_ADMIN);

        setId(id);
        setUsername(username);
        setPassword(password);
    }
}
