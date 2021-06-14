package com.example.fidledemo.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.backLogin.utils.UUIDUtil;

/**
 * token生成工具类
 *
 * @author 11313
 */
public class TokenUtil
{
    public static String getToken(UserBO user)
    {
        return JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getOpenId()));
    }

    public static String getToken(AdminBO admin)
    {
        return JWT.create().withAudience(String.valueOf(admin.getId()+10000))
                .sign(Algorithm.HMAC256(admin.getAccount()));
    }
}
