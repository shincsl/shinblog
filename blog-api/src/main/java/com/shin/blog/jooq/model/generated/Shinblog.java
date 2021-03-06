/*
 * This file is generated by jOOQ.
 */
package com.shin.blog.jooq.model.generated;


import com.shin.blog.jooq.model.generated.tables.TScAdmin;
import com.shin.blog.jooq.model.generated.tables.TScAdminPermission;
import com.shin.blog.jooq.model.generated.tables.TScArticle;
import com.shin.blog.jooq.model.generated.tables.TScArticleBody;
import com.shin.blog.jooq.model.generated.tables.TScArticleTag;
import com.shin.blog.jooq.model.generated.tables.TScCategory;
import com.shin.blog.jooq.model.generated.tables.TScComment;
import com.shin.blog.jooq.model.generated.tables.TScPermission;
import com.shin.blog.jooq.model.generated.tables.TScSysLog;
import com.shin.blog.jooq.model.generated.tables.TScSysUser;
import com.shin.blog.jooq.model.generated.tables.TScTag;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Shinblog extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>shinblog</code>
     */
    public static final Shinblog SHINBLOG = new Shinblog();

    /**
     * The table <code>shinblog.sc_admin</code>.
     */
    public final TScAdmin SC_ADMIN = TScAdmin.SC_ADMIN;

    /**
     * The table <code>shinblog.sc_admin_permission</code>.
     */
    public final TScAdminPermission SC_ADMIN_PERMISSION = TScAdminPermission.SC_ADMIN_PERMISSION;

    /**
     * The table <code>shinblog.sc_article</code>.
     */
    public final TScArticle SC_ARTICLE = TScArticle.SC_ARTICLE;

    /**
     * The table <code>shinblog.sc_article_body</code>.
     */
    public final TScArticleBody SC_ARTICLE_BODY = TScArticleBody.SC_ARTICLE_BODY;

    /**
     * The table <code>shinblog.sc_article_tag</code>.
     */
    public final TScArticleTag SC_ARTICLE_TAG = TScArticleTag.SC_ARTICLE_TAG;

    /**
     * The table <code>shinblog.sc_category</code>.
     */
    public final TScCategory SC_CATEGORY = TScCategory.SC_CATEGORY;

    /**
     * The table <code>shinblog.sc_comment</code>.
     */
    public final TScComment SC_COMMENT = TScComment.SC_COMMENT;

    /**
     * The table <code>shinblog.sc_permission</code>.
     */
    public final TScPermission SC_PERMISSION = TScPermission.SC_PERMISSION;

    /**
     * The table <code>shinblog.sc_sys_log</code>.
     */
    public final TScSysLog SC_SYS_LOG = TScSysLog.SC_SYS_LOG;

    /**
     * The table <code>shinblog.sc_sys_user</code>.
     */
    public final TScSysUser SC_SYS_USER = TScSysUser.SC_SYS_USER;

    /**
     * The table <code>shinblog.sc_tag</code>.
     */
    public final TScTag SC_TAG = TScTag.SC_TAG;

    /**
     * No further instances allowed
     */
    private Shinblog() {
        super("shinblog", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            TScAdmin.SC_ADMIN,
            TScAdminPermission.SC_ADMIN_PERMISSION,
            TScArticle.SC_ARTICLE,
            TScArticleBody.SC_ARTICLE_BODY,
            TScArticleTag.SC_ARTICLE_TAG,
            TScCategory.SC_CATEGORY,
            TScComment.SC_COMMENT,
            TScPermission.SC_PERMISSION,
            TScSysLog.SC_SYS_LOG,
            TScSysUser.SC_SYS_USER,
            TScTag.SC_TAG);
    }
}
