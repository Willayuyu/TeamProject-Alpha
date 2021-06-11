package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.AdminBO;
<<<<<<< Updated upstream
import com.example.fidledemo.DO.*;
import com.example.fidledemo.dao.*;
=======
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.PermissionDO;
import com.example.fidledemo.DO.RoleDO;
import com.example.fidledemo.dao.AdminDAO;
import com.example.fidledemo.dao.PermissionDAO;
import com.example.fidledemo.dao.RoleDAO;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
<<<<<<< Updated upstream
    AdminDAO adminDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    GoodsInfoDAO goodsInfoDAO;

    @Autowired
    TaskInfoDAO taskInfoDAO;

    @Autowired
    ActivityInfoDAO activityInfoDAO;

    @Autowired
    GoodsReportMessageDAO goodsReportMessageDAO;

    @Autowired
    TaskReportMessageDAO taskReportMessageDAO;

    @Autowired
    ActivityReportMessageDAO activityReportMessageDAO;
=======
    private AdminDAO adminDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private PermissionDAO permissionDAO;
>>>>>>> Stashed changes

    @Override
    public AdminBO getAdminBoByDO(AdminDO adminDO) {
        return adminDAO.getAdminBoByDO(adminDO);
    }

    @Override
    public int getUserNums() {
        return userDAO.getUserNums();
    }

    @Override
    public int getTotalGoodsNum() {
        return goodsInfoDAO.getTotalGoodsNum();
    }

    @Override
    public int getTotalTaskNums() {
        return taskInfoDAO.getTotalTaskNums();
    }

    @Override
    public int getTotalActivityNums() {
        return activityInfoDAO.getTotalActivityNums();
    }

    @Override
    public int getNewUserNums() {
        return userDAO.getNewUserNums();
    }

    @Override
    public int getNewGoodsNum() {
        return goodsInfoDAO.getNewGoodsNum();
    }

    @Override
    public int getNewTaskNums() {
        return taskInfoDAO.getNewTaskNums();
    }

    @Override
<<<<<<< Updated upstream
    public int getNewActivityNums() {
        return activityInfoDAO.getNewActivityNums();
    }

    @Override
    public int getGoodsReportNumByDO(GoodsReportMessageDO goodsReportMessage) {
        return goodsReportMessageDAO.getGoodsReportNumByDO(goodsReportMessage);
    }

    @Override
    public int getTaskReportNumByDO(TaskReportMessageDO taskReportMessage) {
        return taskReportMessageDAO.getTaskReportNumByDO(taskReportMessage);
    }

    @Override
    public int getActivityReportNumByDO(ActivityReportMessageDO activityReportMessage) {
        return activityReportMessageDAO.getActivityReportNumByDO(activityReportMessage);
    }


=======
    public List<RoleDO> getRoleDoByAdminBO(AdminBO adminBO) {
        List<RoleDO> roleDOS = roleDAO.listRoleDOByAdminId(adminBO.getId());
        return roleDOS;
    }

    @Override
    public List<PermissionDO> getPermissionDOByRoleDO(RoleDO roleDO) {
        List<PermissionDO> permissionDOS = permissionDAO.listPermissionDOByRoleId((long) 1);
        return permissionDOS;
    }
>>>>>>> Stashed changes
}
