package com.dzc.admin.common.interceptor;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.ErrorCode;
import com.dzc.admin.common.jwt.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 董政辰
 * @date: 2021/3/4 19:37
 * @description:
 * @email：532587041@qq.com
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        boolean res;

        //此部分用于获取方法上是否有ValideToken或者validate属性值是否为true
        //使用ValideToken默认使用token校验
        ValidToken annotation = null;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(ValidToken.class);
        } else {
            return true;
        }
        //没有声明需要权限,或者声明不验证权限
        if (annotation == null || annotation.validate() == false) {
            return true;
        }


        String token = request.getHeader("user-token");

        //判断是否token是否为空
        if (StringUtils.isEmpty(token)) {
            res = false;
        } else {
            res = JwtUtil.verifyToken(token);
        }
        if (!res) {
            response.sendError(ErrorCode.TOKEN_EXPIRED, "用户登陆信息已过期");
        }
        return res;
    }

}
