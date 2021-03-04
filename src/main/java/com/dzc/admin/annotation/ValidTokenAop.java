package com.dzc.admin.annotation;

import com.dzc.admin.common.Result;
import com.dzc.admin.common.jwt.JwtUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 董政辰
 * @date: 2021/3/4 16:03
 * @description:
 * @email：532587041@qq.com
 */
@Aspect
@Component
public class ValidTokenAop {

    @Pointcut("@annotation(com.dzc.admin.annotation.ValidToken)")
    public void validToken() {
    }

    @Before("validToken()")
    public void before(JoinPoint jp){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = request.getHeader("user-token");
        JwtUtil.verifyToken(token);

    }

}
