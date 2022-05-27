package com.shin.blog.service;

import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.generated.tables.records.ScSysUserRecord;
import com.shin.blog.vo.Result;
import org.springframework.web.multipart.MultipartFile;

public interface SysUserService {

    ScSysUser findUserVoById(Long id);

    ScSysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     *
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据输入的账户查找用户
     *
     * @param account
     * @return
     */
    ScSysUserRecord findUserByAccount(String account);

    /**
     * 保存用户
     *
     * @param sysUser
     */
    void save(ScSysUserRecord sysUser);

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    Result updateUserAvatar(MultipartFile file, String token);
}
