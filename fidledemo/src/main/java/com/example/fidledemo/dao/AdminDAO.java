package com.example.fidledemo.dao;

import com.example.fidledemo.DO.AdminDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WWJ20
 */
@Mapper
@Repository
public interface AdminDAO {
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
}
