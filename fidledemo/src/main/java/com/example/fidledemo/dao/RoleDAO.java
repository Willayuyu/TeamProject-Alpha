package com.example.fidledemo.dao;

import com.example.fidledemo.DO.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface RoleDAO {
    /**
     * 根据管理员id查询对应的角色
     *
     * @param adminId
     * @return
     */
    List<RoleDO> listRoleDOByAdminId(Long adminId);
}
