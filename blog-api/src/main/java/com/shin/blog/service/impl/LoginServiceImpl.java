package com.shin.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.generated.tables.records.ScSysUserRecord;
import com.shin.blog.service.LoginService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.utils.JWTUtils;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    SysUserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static final String salt = "shin!@#";

    @Override
    public Result login(LoginParam loginParam) {
        /**
         * 检查参数是否合法
         * 根据用户名和密码去user表查询是否存在
         * 如果不存在，登录失败
         * 如果存在，使用jwt 生成token 返回给前端
         * token放入redis中，设置过期时间
         */
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.error(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + salt);
        ScSysUser sysUser = userService.findUser(account, password);
        if (sysUser == null) {
            return Result.error(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());

        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 2, TimeUnit.HOURS);
        return Result.success(token);
    }

    @Override
    public ScSysUser checkToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null) {
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if (StringUtils.isBlank(userJson)) {
            return null;
        }
        ScSysUser sysUser = JSON.parseObject(userJson, ScSysUser.class);
        return sysUser;
    }

    @Override
    public Result logout(String token) {
        redisTemplate.delete("TOKEN_" + token);
        return Result.success(null);
    }

    @Override
    public Result register(LoginParam loginParam) {
        /**
         * 判断参数 是否合法
         * 判断账号 是否存在，若存在 返回用户已经被注册
         * 不存在，注册用户
         * 生成token
         * 存入redis，并返回
         * 要加上事务，一旦中间过程出现问题，注册的用户 需要回滚
         */
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        String nickname = loginParam.getNickname();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(nickname)) {
            return Result.error(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        ScSysUserRecord sysUser = userService.findUserByAccount(account);
        if (sysUser != null) {
            return Result.error(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5Hex(password + salt));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("/static/admin.png");
        sysUser.setAdmin(true); //1 为true
        sysUser.setDeleted(false); // 0 为false
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");
        userService.save(sysUser);

        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
