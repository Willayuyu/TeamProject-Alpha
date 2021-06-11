package com.example.fidledemo.dao;

import com.example.fidledemo.DO.PermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.security.Permission;
import java.util.List;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface PermissionDAO {
    /**
     * 根据角色的id返回所具有的权限
     *
     * @param roleId
     * @return
     */
    List<PermissionDO> listPermissionDOByRoleId(long roleId);
}
