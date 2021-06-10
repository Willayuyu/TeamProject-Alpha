package com.example.fidledemo.backLogin.service;

import com.example.fidledemo.DO.AdminDO;

/**
 * @author WWJ
 */
public interface LoginService {
    /**
     * 判断用户输入的账号密码是否正确
     * @param adminDO
     * @return
     */
    public boolean isAdminTrue(AdminDO adminDO);
}
