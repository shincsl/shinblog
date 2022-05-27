package com.shin.blog.controller;

import com.shin.blog.service.SysUserService;
import com.shin.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    SysUserService userService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token) {
        return userService.findUserByToken(token);
    }

    @PostMapping("avatar/{token}")
    public Result updateUserInfo(@RequestParam("image") MultipartFile file, @PathVariable("token") String token) {
        return userService.updateUserAvatar(file, token);
    }
}
