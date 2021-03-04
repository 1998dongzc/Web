package com.dzc.admin.service.impl;

import com.dzc.admin.common.Result;
import com.dzc.admin.common.jwt.JwtUtil;
import com.dzc.admin.dao.UserMapper;
import com.dzc.admin.model.User;
import com.dzc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

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
    public Result isUser(User user) {
        User res = userMapper.selectOneUser(user);
        if (StringUtils.isEmpty(res)) {
            return Result.fail(401, "未查到此用户信息");
        } else {
            Map<String, String> map = new HashMap();
            map.put("username", res.getUsername());
            map.put("password", res.getPassword());
            System.out.println(JwtUtil.createToken(map));
        }
        System.out.println(res);
        return Result.success(res);
    }
}
