package com.shin.blog.service;

import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    ScSysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    Result register(LoginParam loginParam);
}
