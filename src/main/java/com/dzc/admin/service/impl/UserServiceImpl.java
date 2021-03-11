package com.dzc.admin.service.impl;

import com.dzc.admin.common.ErrorCode;
import com.dzc.admin.common.Result;
import com.dzc.admin.common.jwt.JwtUtil;
import com.dzc.admin.dao.UserInfoMapper;
import com.dzc.admin.dao.UserMapper;
import com.dzc.admin.model.User;
import com.dzc.admin.model.UserInfo;
import com.dzc.admin.service.UserService;
import com.dzc.admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @Autowired UserInfoMapper userInfoMapper;

    @Override
    public Result logIn(User user) {
        User res = userMapper.selectOneUser(user);
        if (res == null) {
            return Result.fail(ErrorCode.TOKEN_ERROR, "账号或密码错误");
        } else {
            String token = JwtUtil.createToken(res);
            return Result.success(new UserVo(token));
        }
    }

    @Override
    public Result getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("user-token");
        int uid = JwtUtil.getTokenInfo(token);
        System.out.println(token);
        System.out.println(uid);
        if (uid == 0)
            return Result.fail(ErrorCode.TOKEN_EXPIRED, "用户登录已过期");
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
        return Result.success(userInfo);
    }

    @Override
    public Result logOut() {
        try {
            return Result.success("登出成功");
        }catch (Exception exception){
            return Result.fail("登出失败");
        }
    }

    @Override
    public Result getUserInfoById(Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo==null){
            return Result.fail("获取用户信息失败");
        }
        return Result.success(userInfo);
    }

}
