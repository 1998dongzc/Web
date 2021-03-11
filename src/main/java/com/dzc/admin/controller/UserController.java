package com.dzc.admin.controller;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.Result;
import com.dzc.admin.model.User;
import com.dzc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 用户登录APi
     *
     * @param user
     * @return token 用户token
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user) {
        return userService.logIn(user);
    }

    /**
     * 获取用户信息api
     *
     * @return
     */
    @GetMapping("/info")
    @ValidToken
    public Result userInfo(HttpServletRequest request) {
        return userService.getUserInfo(request);
    }

    /**
     * 登出api
     *
     * @return
     */
    @ValidToken
    @PostMapping("/logout")
    public Result userLogout() {
        return userService.logOut();
    }

    @PostMapping("/signup")
    public Result signUp(User user) {
        return null;
    }

    @GetMapping("/getInfo/{id}")
    public Result getUserName(@PathVariable("id") Integer id){
        return userService.getUserInfoById(id);
    }
}
