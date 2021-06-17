package com.example.fidledemo.backHomepage.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.*;
import com.example.fidledemo.dao.*;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.PermissionDO;
import com.example.fidledemo.DO.RoleDO;
import com.example.fidledemo.dao.AdminDAO;
import com.example.fidledemo.dao.PermissionDAO;
import com.example.fidledemo.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
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

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PermissionDAO permissionDAO;

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

    @Override
    public List<RoleDO> getRoleDoByAdminBO(AdminBO adminBO) {
        List<RoleDO> roleDOS = roleDAO.listRoleDOByAdminId(adminBO.getId());
        return roleDOS;
    }

    @Override
    public List<PermissionDO> getPermissionDOByRoleDO(RoleDO roleDO) {
        List<PermissionDO> permissionDOS = permissionDAO.listPermissionDOByRoleId((long) 1);
        return permissionDOS;
    }

    @Override
    public int getGoodsNumByTime(Date begin, Date end) {
        return goodsInfoDAO.getGoodsNumByTime(begin,end);
    }

    @Override
    public int getTasksNumByTime(Date begin, Date end) {
        return taskInfoDAO.getTasksNumByTime(begin,end);
    }

    @Override
    public int getActivityNumByTime(Date begin, Date end) {
        return activityInfoDAO.getActivityNumByTime(begin,end);
    }


    /**
     * 无关键词筛选
     * @param infoDO
     * @param tagDO
     * @return
     */
    @Override
    public List<BackGoodsItemVO> listGoodsInfoByDO(GoodsInfoDO infoDO, TagOfGoodsDO tagDO) {
        List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoByDO(infoDO, tagDO);
        List<BackGoodsItemVO> goodsItemVOS=new ArrayList<>();

        for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
            BackGoodsItemVO goodsItemVO = new BackGoodsItemVO();
            goodsItemVO.setId(goodsInfoBO.getId());
            goodsItemVO.setSellerId(goodsInfoBO.getPubId());
            goodsItemVO.setTitle(goodsInfoBO.getTitle());

            goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

            goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
            goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

            goodsItemVOS.add(goodsItemVO);
        }
        return goodsItemVOS;
    }

    /**
     * 关键词搜索
     * @param infoDO
     * @param tagDO
     * @return
     */
    @Override
    public List<BackGoodsItemVO> listGoodsInfoBySearch(GoodsInfoDO infoDO, TagOfGoodsDO tagDO) {
        List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearch(infoDO, tagDO);

        List<BackGoodsItemVO> goodsItemVOS=new ArrayList<>();

        for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
            BackGoodsItemVO goodsItemVO = new BackGoodsItemVO();
            goodsItemVO.setId(goodsInfoBO.getId());
            goodsItemVO.setSellerId(goodsInfoBO.getPubId());
            goodsItemVO.setTitle(goodsInfoBO.getTitle());

            goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

            goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
            goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

            goodsItemVOS.add(goodsItemVO);
        }
        return goodsItemVOS;
    }

    @Override
    public List<BackTaskItemVO> listTaskInfoByDOForBack(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
        List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoByDOForBack(infoDO, tagDO);

        List<BackTaskItemVO> taskItemVOS=new ArrayList<>();

        for (TaskInfoBO taskInfoBO:taskInfoBOS) {
            BackTaskItemVO taskItemVO = new BackTaskItemVO();
            taskItemVO.setId(taskInfoBO.getId());
            taskItemVO.setPulisherId(taskInfoBO.getPubId());
            taskItemVO.setTitle(taskInfoBO.getTitle());
            taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());

            taskItemVO.setGmt_create(taskInfoBO.getGmtInfo().getGmtCreate());
            taskItemVO.setAnnouncer(taskInfoBO.getPubName());

            taskItemVOS.add(taskItemVO);
        }
        return taskItemVOS;
    }

    @Override
    public List<BackTaskItemVO> listTaskInfoBySearchForBack(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
        List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearchForBack(infoDO, tagDO);

        List<BackTaskItemVO> taskItemVOS=new ArrayList<>();

        for (TaskInfoBO taskInfoBO:taskInfoBOS) {
            BackTaskItemVO taskItemVO = new BackTaskItemVO();
            taskItemVO.setId(taskInfoBO.getId());
            taskItemVO.setPulisherId(taskInfoBO.getPubId());
            taskItemVO.setTitle(taskInfoBO.getTitle());
            taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());

            taskItemVO.setGmt_create(taskInfoBO.getGmtInfo().getGmtCreate());
            taskItemVO.setAnnouncer(taskInfoBO.getPubName());

            taskItemVOS.add(taskItemVO);
        }
        return taskItemVOS;
    }

    @Override
    public List<BackActivityVO> listActivityInfoByDOForBack(ActivityInfoDO infoDO, TagOfActivityDO tag) {
        List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoByDOForBack(infoDO, tag);

        List<BackActivityVO> activityItemVOS=new ArrayList<>();

        for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
            BackActivityVO activityItemVO = new BackActivityVO();
            activityItemVO.setId(activityInfoBO.getId());
            activityItemVO.setTitle(activityInfoBO.getTitle());
            activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

            activityItemVO.setGmt_create(activityInfoBO.getGmtInfo().getGmtCreate());
            activityItemVO.setAnnouncer(activityInfoBO.getPubName());
            activityItemVO.setPublisherId(activityInfoBO.getPubId());

            activityItemVOS.add(activityItemVO);
        }
        return activityItemVOS;
    }

    @Override
    public List<BackActivityVO> listActivityInfoBySearchForBack(ActivityInfoDO infoDO, TagOfActivityDO tag) {
        List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoBySearchForBack(infoDO, tag);

        List<BackActivityVO> activityItemVOS=new ArrayList<>();

        for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
            BackActivityVO activityItemVO = new BackActivityVO();
            activityItemVO.setId(activityInfoBO.getId());
            activityItemVO.setTitle(activityInfoBO.getTitle());
            activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

            activityItemVO.setGmt_create(activityInfoBO.getGmtInfo().getGmtCreate());
            activityItemVO.setAnnouncer(activityInfoBO.getPubName());
            activityItemVO.setPublisherId(activityInfoBO.getPubId());

            activityItemVOS.add(activityItemVO);
        }
        return activityItemVOS;
    }

}
