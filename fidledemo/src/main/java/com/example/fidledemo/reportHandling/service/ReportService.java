package com.example.fidledemo.reportHandling.service;

import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.VO.UserVO;


import java.util.List;

/**
 * @author WWJ
 */
public interface ReportService {
    /**
     * 返回二手物品举报列表
     *
     * @return
     */
    List<ReportMessageBO> listGoodsReports();

    /**
     * 返回任务举报列表
     *
     * @return
     */
    List<ReportMessageBO> listTaskReports();

    /**
     * 返回活动信息举报列表
     *
     * @return
     */
    List<ReportMessageBO> listActivityReports();

    /**
     * 通过物品举报
     *
     * @param reportid
     * @return
     */
    UserVO handleGoodsReport(int reportid);

    /**
     * 通过任务举报
     *
     * @param reportid
     * @return
     */
    UserVO handleTaskReport(int reportid);

    /**
     * 通过活动举报
     *
     * @param reportid
     * @return
     */
    UserVO handleActivityReport(int reportid);

    /**
     * 忽略物品举报
     *
     * @param reportid
     */
    void ignoreGoodsReport(int reportid);

    /**
     * 忽略任务举报
     *
     * @param reportid
     */
    void ignoreTaskReport(int reportid);

    /**
     * 忽略活动举报
     *
     * @param reportid
     */
    void ignoreActivityReport(int reportid);

}
