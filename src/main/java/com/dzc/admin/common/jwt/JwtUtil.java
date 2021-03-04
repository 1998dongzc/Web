package com.dzc.admin.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dzc.admin.common.ErrorCode;
import com.dzc.admin.common.Result;
import sun.misc.Cleaner;

import java.util.Calendar;
import java.util.Map;

/**
 * @author: 董政辰
 * @date: 2021/3/4 10:36
 * @description:
 * @email：532587041@qq.com
 */
public class JwtUtil {

    /**
     * 自定义 JWT私钥
     */
    private static String SECRET = "admin^&^";

    /**
     * 生成token
     */
    public static String createToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        // 设置过期时间 10S
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH, 30);
        builder.withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token是否合法
     */
    public static void verifyToken(String token) {

        try {
            DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        } catch (JWTVerificationException e) {
            System.out.println("登陆过期");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对token的解密
     * @Param: 传入token
     */
    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }
}
