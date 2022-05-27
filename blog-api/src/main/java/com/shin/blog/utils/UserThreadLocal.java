package com.shin.blog.utils;

import com.shin.blog.jooq.model.entity.ScSysUser;

public class UserThreadLocal {
    private UserThreadLocal(){}

    //线程变量隔离
    private static final ThreadLocal<ScSysUser> LOCAL = new ThreadLocal<>();

    public static void put(ScSysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static ScSysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
