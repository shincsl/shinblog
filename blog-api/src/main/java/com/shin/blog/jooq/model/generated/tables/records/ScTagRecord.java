/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScTag;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScTag;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScTagRecord extends UpdatableRecordImpl<ScTagRecord> implements Record3<String, String, String>, IScTag {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_tag.id</code>.
     */
    @Override
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_tag.id</code>.
     */
    @Override
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_tag.avatar</code>.
     */
    @Override
    public void setAvatar(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_tag.avatar</code>.
     */
    @Override
    public String getAvatar() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_tag.tag_name</code>.
     */
    @Override
    public void setTagName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_tag.tag_name</code>.
     */
    @Override
    public String getTagName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TScTag.SC_TAG.ID;
    }

    @Override
    public Field<String> field2() {
        return TScTag.SC_TAG.AVATAR;
    }

    @Override
    public Field<String> field3() {
        return TScTag.SC_TAG.TAG_NAME;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getAvatar();
    }

    @Override
    public String component3() {
        return getTagName();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getAvatar();
    }

    @Override
    public String value3() {
        return getTagName();
    }

    @Override
    public ScTagRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ScTagRecord value2(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public ScTagRecord value3(String value) {
        setTagName(value);
        return this;
    }

    @Override
    public ScTagRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScTag from) {
        setId(from.getId());
        setAvatar(from.getAvatar());
        setTagName(from.getTagName());
    }

    @Override
    public <E extends IScTag> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScTagRecord
     */
    public ScTagRecord() {
        super(TScTag.SC_TAG);
    }

    /**
     * Create a detached, initialised ScTagRecord
     */
    public ScTagRecord(String id, String avatar, String tagName) {
        super(TScTag.SC_TAG);

        setId(id);
        setAvatar(avatar);
        setTagName(tagName);
    }
}
