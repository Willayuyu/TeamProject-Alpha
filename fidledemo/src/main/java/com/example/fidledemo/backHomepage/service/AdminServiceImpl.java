package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;
    @Override
    public void insertAdmin(AdminDO admin) {

    }

    @Override
    public void updateAdmin(AdminDO adminDO) {

    }

    @Override
    public void deleteAdminById(long id) {

    }

    @Override
    public List<AdminDO> listAdminByDO(AdminDO adminDO) {
        return null;
    }

    @Override
    public AdminBO getAdminBoByDO(AdminDO adminDO) {
        return adminDAO.getAdminBoByDO(adminDO);
    }
}
