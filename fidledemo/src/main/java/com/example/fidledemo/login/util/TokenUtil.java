package com.example.fidledemo.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.fidledemo.BO.UserBO;

/**
 * token生成工具类
 * @author 11313
 */
public class TokenUtil
{
  public static String getToken(UserBO user)
  {
    String token= JWT.create().withAudience(String.valueOf(user.getId()))
        .sign(Algorithm.HMAC256(user.getOpenId()));
    return token;
  }
}
