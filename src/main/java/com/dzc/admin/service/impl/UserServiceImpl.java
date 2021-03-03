package com.dzc.admin.service.impl;

import com.dzc.admin.common.Result;
import com.dzc.admin.dao.UserMapper;
import com.dzc.admin.model.User;
import com.dzc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 董政辰
 * @date: 2021/3/3 17:11
 * @description:
 * @email：532587041@qq.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result getOneUser(User user) {
        return Result.success(user);
    }

}
