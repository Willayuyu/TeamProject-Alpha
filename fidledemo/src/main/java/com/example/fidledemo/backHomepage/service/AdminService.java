package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.BackActivityVO;
import com.example.fidledemo.VO.BackGoodsItemVO;
import com.example.fidledemo.VO.BackTaskItemVO;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据时间段返回二手物品数量
     * @param begin
     * @param end
     * @return
     */
    int getGoodsNumByTime(@Param("beginTime")Date begin, @Param("endTime")Date end);

    /**
     * 根据时间段返回任务数量
     * @param begin
     * @param end
     * @return
     */
    int getTasksNumByTime(@Param("beginTime") Date begin, @Param("endTime")Date end);

    /**
     * 根据时间段返回活动数量
     * @param begin
     * @param end
     * @return
     */
    int getActivityNumByTime(@Param("beginTime") Date begin, @Param("endTime")Date end);


    /**
     * 根据DO查询二手物品列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<BackGoodsItemVO> listGoodsInfoByDO(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

    /**
     * 根据DO搜索二手物品列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<BackGoodsItemVO> listGoodsInfoBySearch(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

    /**
     * 根据DO获得任务信息列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<BackTaskItemVO> listTaskInfoByDOForBack(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

    /**
     * 根据DO搜索任务信息列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<BackTaskItemVO> listTaskInfoBySearchForBack(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

    /**
     * 根据DO获取活动信息列表
     * @param infoDO
     * @param tag
     * @return
     */
    List<BackActivityVO> listActivityInfoByDOForBack(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);

    /**
     * 根据DO搜索活动信息列表
     * @param infoDO
     * @param tag
     * @return
     */
    List<BackActivityVO> listActivityInfoBySearchForBack(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);
}
