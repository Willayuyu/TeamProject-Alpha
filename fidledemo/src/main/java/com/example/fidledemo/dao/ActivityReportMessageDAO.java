package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.DO.ActivityReportMessageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Mapper
@Repository
public interface ActivityReportMessageDAO {

    /**
     * 插入活动举报信息
     * @param activityReportMessage
     */
    void insertActivityReportMessage(ActivityReportMessageDO activityReportMessage);

    /**
     * 删除
     * @param id
     */
    void deleteActivityReportMessageById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    ReportMessageBO getActivityReportMessageById(Long id);

    /**
     * 筛选
     * @param activityReportMessage
     * @return
     */
    List<ReportMessageBO> listActivityReportMessageByDO(ActivityReportMessageDO activityReportMessage);

    /**
     * 更新
     * @param activityReportMessage
     */
    void updateActivityReportMessage(ActivityReportMessageDO activityReportMessage);

    /**
     * 根据DO返回举报数
     * @param activityReportMessage
     * @return
     */
    int getActivityReportNumByDO(ActivityReportMessageDO activityReportMessage);

}
