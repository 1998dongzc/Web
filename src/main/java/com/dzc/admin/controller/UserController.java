package com.dzc.admin.controller;

import com.dzc.admin.common.Result;
import com.dzc.admin.model.User;
import com.dzc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 董政辰
 * @date: 2021/3/3 17:18
 * @description:
 * @email：532587041@qq.com
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public Result userLogin(User user) {
        Result oneUser = userService.getOneUser(user);
        return oneUser;
    }

}
