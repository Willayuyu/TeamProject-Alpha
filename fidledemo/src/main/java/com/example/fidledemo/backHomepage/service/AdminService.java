package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.DO.ActivityReportMessageDO;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import com.example.fidledemo.DO.TaskReportMessageDO;
import com.example.fidledemo.DO.PermissionDO;
import com.example.fidledemo.DO.RoleDO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface AdminService {

    /**
     * 根据DO查询用户
     * @param adminDO
     * @return
     */
    AdminBO getAdminBoByDO(AdminDO adminDO);

    /**
     * 返回用户总数
     * @return
     */
    int getUserNums();

    /**
     * 返回总二手物品数
     * @return
     */
    int getTotalGoodsNum();

    /**
     * 返回总任务数
     * @return
     */
    int getTotalTaskNums();

    /**
     * 返回总活动数
     * @return
     */
    int getTotalActivityNums();

    /**
     * 返回今日新增用户总数
     * @return
     */
    int getNewUserNums();

    /**
     * 返回今日新增二手物品数
     * @return
     */
    int getNewGoodsNum();

    /**
     * 返回今日新增任务数
     * @return
     */
    int getNewTaskNums();

    /**
     * 返回今日新增活动数
     * @return
     */
    int getNewActivityNums();

    /**
     * 根据DO返回举报数
     * @param goodsReportMessage
     * @return
     */
    int getGoodsReportNumByDO(GoodsReportMessageDO goodsReportMessage);

    /**
     * 根据DO返回举报数
     * @param taskReportMessage
     * @return
     */
    int getTaskReportNumByDO(TaskReportMessageDO taskReportMessage);

    /**
     * 根据DO返回举报数
     * @param activityReportMessage
     * @return
     */
    int getActivityReportNumByDO(ActivityReportMessageDO activityReportMessage);


    /**
     * 根据管理员信息来查询对应的角色
     * @param adminBO
     * @return
     */
    List<RoleDO> getRoleDoByAdminBO(AdminBO adminBO);

    /**
     * 根据角色信息来查询对应的权限
     * @param roleDO
     * @return
     */
    List<PermissionDO> getPermissionDOByRoleDO(RoleDO roleDO);
}
