package com.shin.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shin.blog.dao.mapper.SysUserMapper;
import com.shin.blog.dao.pojo.SysUser;
import com.shin.blog.service.LoginService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.utils.QiniuUtils;
import com.shin.blog.utils.StringUtil;
import com.shin.blog.vo.ErrorCode;
import com.shin.blog.vo.LoginUserVo;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
    SysUserMapper sysUserMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LoginService loginService;

    @Autowired
    QiniuUtils qiniuUtils;

    @Override
    public UserVo findUserVoById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/admin.png");
            sysUser.setNickname("佚名");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(sysUser, userVo);
        userVo.setId(String.valueOf(sysUser.getId()));
        return userVo;
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("佚名");
        }
        return sysUser;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount, account);
        queryWrapper.eq(SysUser::getPassword, password);
        queryWrapper.select(SysUser::getAccount, SysUser::getId, SysUser::getAvatar, SysUser::getNickname);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        /**
         * token合法性校验
         *      1、是否为空
         *      2、解析是否成功
         *      3、redis是否存在
         * 如果校验失败，返回错误信息
         * 如果成功，返回对应的结果 LoginUserVo
         */
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null) {
            return Result.error(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setId(String.valueOf(sysUser.getId()));
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setNickname(sysUser.getNickname());
        loginUserVo.setAvatar(sysUser.getAvatar());
        return Result.success(loginUserVo);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount, account);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserMapper.insert(sysUser);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result updateUserAvatar(MultipartFile file, String token) {
        SysUser sysUser = loginService.checkToken(token);
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
            sysUser.setAvatar(avatar);
            sysUserMapper.updateById(sysUser);
            redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 2, TimeUnit.HOURS);
            return Result.success(sysUser);
        } else {
            return Result.error(20001, "上传失败");
        }
    }

}
