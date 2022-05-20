/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.records;


import com.shin.blog.jooq.model.generated.tables.TScCategory;
import com.shin.blog.jooq.model.generated.tables.interfaces.IScCategory;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScCategoryRecord extends UpdatableRecordImpl<ScCategoryRecord> implements Record4<Long, String, String, String>, IScCategory {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>shinblog.sc_category.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>shinblog.sc_category.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>shinblog.sc_category.avatar</code>.
     */
    @Override
    public void setAvatar(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shinblog.sc_category.avatar</code>.
     */
    @Override
    public String getAvatar() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shinblog.sc_category.category_name</code>.
     */
    @Override
    public void setCategoryName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shinblog.sc_category.category_name</code>.
     */
    @Override
    public String getCategoryName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shinblog.sc_category.description</code>.
     */
    @Override
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>shinblog.sc_category.description</code>.
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
        return TScCategory.SC_CATEGORY.ID;
    }

    @Override
    public Field<String> field2() {
        return TScCategory.SC_CATEGORY.AVATAR;
    }

    @Override
    public Field<String> field3() {
        return TScCategory.SC_CATEGORY.CATEGORY_NAME;
    }

    @Override
    public Field<String> field4() {
        return TScCategory.SC_CATEGORY.DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getAvatar();
    }

    @Override
    public String component3() {
        return getCategoryName();
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
        return getAvatar();
    }

    @Override
    public String value3() {
        return getCategoryName();
    }

    @Override
    public String value4() {
        return getDescription();
    }

    @Override
    public ScCategoryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ScCategoryRecord value2(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public ScCategoryRecord value3(String value) {
        setCategoryName(value);
        return this;
    }

    @Override
    public ScCategoryRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ScCategoryRecord values(Long value1, String value2, String value3, String value4) {
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
    public void from(IScCategory from) {
        setId(from.getId());
        setAvatar(from.getAvatar());
        setCategoryName(from.getCategoryName());
        setDescription(from.getDescription());
    }

    @Override
    public <E extends IScCategory> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ScCategoryRecord
     */
    public ScCategoryRecord() {
        super(TScCategory.SC_CATEGORY);
    }

    /**
     * Create a detached, initialised ScCategoryRecord
     */
    public ScCategoryRecord(Long id, String avatar, String categoryName, String description) {
        super(TScCategory.SC_CATEGORY);

        setId(id);
        setAvatar(avatar);
        setCategoryName(categoryName);
        setDescription(description);
    }
}
