package com.dzc.admin.service;

import com.dzc.admin.common.Result;
import com.dzc.admin.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 董政辰
 * @date: 2021/3/3 17:10
 * @description:
 * @email：532587041@qq.com
 */
public interface UserService {

    public Result logIn(User user);

    public Result getUserInfo(HttpServletRequest request);

    public Result logOut();

    Result getUserInfoById(Integer id);
}
