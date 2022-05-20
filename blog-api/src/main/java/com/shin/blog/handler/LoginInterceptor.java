package com.shin.blog.handler;

import com.alibaba.fastjson.JSON;
import com.shin.blog.dao.pojo.SysUser;
import com.shin.blog.service.LoginService;
import com.shin.blog.utils.UserThreadLocal;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 1、需要判断 请求的接口路径 是否为 handleMethod（controller方法）
         * 2、判断token是否为空，如果为空 未登录
         * 3、如果token不为空，登录验证 loginService checkToken
         * 4、如果验证成功 放行
         */
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("====================request start====================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}",token);
        log.info("====================request end====================");

        if (StringUtils.isBlank(token)){
            Result result = Result.error(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null){
            Result result = Result.error(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登录验证成功 放行
        UserThreadLocal.put(sysUser);
        return true;
    }
}
