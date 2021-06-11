package com.example.fidledemo.backLogin.service;

import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WWJ
 */
public class LoginServiceImpl implements LoginService{
    @Autowired
    AdminDAO adminDAO;

    @Override
    public boolean isAdminTrue(AdminDO adminDO) {
//        String account=adminDO.getAccount();
//        String password=adminDO.getPassword();
//        String salt=adminDO.getSalt();
        return true;
    }
}
