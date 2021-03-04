package com.dzc.admin.controller;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.Result;
import com.dzc.admin.common.jwt.JwtUtil;
import com.dzc.admin.model.User;
import com.dzc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 董政辰
 * @date: 2021/3/3 17:18
 * @description: 用户账号相关controller
 * @email：532587041@qq.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public Result userLogin(User user) {
        Result oneUser = userService.isUser(user);
        return oneUser;
    }

    @PostMapping("/signup")
    public Result signUp(User user){
        return null;
    }

}
