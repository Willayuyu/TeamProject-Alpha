package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.DO.AdminDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface AdminService {
    /**
     * 将管理员实体插入管理员表
     * @param admin
     */
    void insertAdmin(AdminDO admin);

    /**
     * 根据DO更新管理员的信息
     * @param adminDO
     */
    void updateAdmin(AdminDO adminDO);

    /**
     * 根据id删除管理员
     * @param id
     */
    void deleteAdminById(long id);

    /**
     * 根据DO查询用户表
     * @param adminDO
     * @return 返回查询到的管理员DO列表
     */
    List<AdminDO> listAdminByDO(AdminDO adminDO);

    /**
     * 根据DO查询用户
     * @param adminDO
     * @return
     */
    AdminBO getAdminBoByDO(AdminDO adminDO);
}
