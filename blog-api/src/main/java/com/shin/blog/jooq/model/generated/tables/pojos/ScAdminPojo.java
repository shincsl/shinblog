/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated.tables.pojos;


import com.shin.blog.jooq.model.generated.tables.interfaces.IScAdmin;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScAdminPojo implements IScAdmin {

    private static final long serialVersionUID = 1L;

    private Long   id;
    private String username;
    private String password;

    public ScAdminPojo() {}

    public ScAdminPojo(IScAdmin value) {
        this.id = value.getId();
        this.username = value.getUsername();
        this.password = value.getPassword();
    }

    public ScAdminPojo(
        Long   id,
        String username,
        String password
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for <code>shinblog.sc_admin.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>shinblog.sc_admin.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>shinblog.sc_admin.username</code>.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter for <code>shinblog.sc_admin.username</code>.
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for <code>shinblog.sc_admin.password</code>.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for <code>shinblog.sc_admin.password</code>.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ScAdminPojo (");

        sb.append(id);
        sb.append(", ").append(username);
        sb.append(", ").append(password);

        sb.append(")");
        return sb.toString();
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
}
