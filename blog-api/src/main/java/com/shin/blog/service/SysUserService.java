package com.shin.blog.service;

import com.shin.blog.dao.pojo.SysUser;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;

public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

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
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     *
     * @param sysUser
     */
    void save(SysUser sysUser);

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    Result updateUserAvatar(MultipartFile file, String token);
}
