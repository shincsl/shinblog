package com.shin.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScSysUser;
import com.shin.blog.jooq.model.generated.tables.daos.ScSysUserDao;
import com.shin.blog.jooq.model.generated.tables.records.ScSysUserRecord;
import com.shin.blog.service.LoginService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.utils.QiniuUtils;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    DSLContext dslContext;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LoginService loginService;

    @Autowired
    QiniuUtils qiniuUtils;

    @Override
    public ScSysUser findUserVoById(Long id) {
        TScSysUser sysUser = Tables.SC_SYS_USER;
        ScSysUserDao scSysUserDao = new ScSysUserDao(dslContext.configuration());
        ScSysUser scSysUser = scSysUserDao.fetchOneById(id);
        if (scSysUser == null) {
            dslContext.insertInto(sysUser)
                    .set(sysUser.AVATAR, "/static/admin.png")
                    .set(sysUser.NICKNAME, "佚名")
                    .execute();

        }
        return scSysUser;
    }

    @Override
    public ScSysUser findUser(String account, String password) {
        TScSysUser sysUser = Tables.SC_SYS_USER;
        Record4<Long, String, String, String> record = dslContext.select(sysUser.ID, sysUser.ACCOUNT, sysUser.NICKNAME, sysUser.AVATAR)
                .from(sysUser)
                .where(sysUser.ACCOUNT.eq(account))
                .and(sysUser.PASSWORD.eq(password))
                .limit(1).fetchOne();
        ScSysUser scSysUser = record.into(ScSysUser.class);
        return scSysUser;
    }

    @Override
    public Result findUserByToken(String token) {
        /**
         * token合法性校验
         *      1、是否为空
         *      2、解析是否成功
         *      3、redis是否存在
         * 如果校验失败，返回错误信息
         * 如果成功，返回对应的结果 sysUser
         */
        ScSysUser sysUser = loginService.checkToken(token);
        if (sysUser == null) {
            return Result.error(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }
        return Result.success(sysUser);
    }

    @Override
    public ScSysUserRecord findUserByAccount(String account) {
        TScSysUser sysUser = Tables.SC_SYS_USER;
        ScSysUserRecord sysUserRecord = dslContext.selectFrom(sysUser).where(sysUser.ACCOUNT.eq(account)).limit(1).fetchOne();
        return sysUserRecord;
    }

    @Override
    public void save(ScSysUserRecord sysUser) {
        sysUser.insert();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result updateUserAvatar(MultipartFile file, String token) {
        ScSysUser sysUser = loginService.checkToken(token);
        if (sysUser == null) {
            return Result.error(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }
        // 原始文件名称
        String originalFilename = file.getOriginalFilename();
        // 唯一的文件名称
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");
        // 上传文件位置 七牛云
        boolean upload = qiniuUtils.upload(file, fileName);
        String avatar = "";
        if (upload) {
            // 头像上传oss，返回图片地址
            avatar = QiniuUtils.url + fileName;
            // 更新用户信息
            dslContext.update(Tables.SC_SYS_USER)
                    .set(Tables.SC_SYS_USER.AVATAR, avatar)
                    .where(Tables.SC_SYS_USER.ID.eq(sysUser.getId()))
                    .execute();
            redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 2, TimeUnit.HOURS);
            return Result.success(sysUser);
        } else {
            return Result.error(20001, "上传失败");
        }
    }

}
