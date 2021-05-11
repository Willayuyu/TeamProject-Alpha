package com.example.fidledemo.login.service;

import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.login.util.LoginResult;

/**
 * 登录相关业务接口
 * @author 11313
 */
public interface LoginService
{

    /**
     * 通过调用api获得登录信息
     * @param code
     * @return
     */
    UserBO loginRequest(String code);

    /**
     * 用户授权（将用户的登录信息存入数据库）
     * @param id
     * @param wechatAccount
     * @param portrait
     * @return
     */
    UserBO userAuth(Long id, String wechatAccount, String portrait);

}
