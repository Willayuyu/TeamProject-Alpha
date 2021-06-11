package com.example.fidledemo.report.service;


/**
 * @author zyf
 */
public interface ReportService {

    /**
     * 举报二手物品
     * @param whistleblowerId 举报者id
     * @param goodsId 二手物品id
     * @param reason 举报理由
     */
    void reportGoods(Long whistleblowerId,Long goodsId,String reason);

    /**
     * 举报任务委托
     * @param whistleblowerId 举报者id
     * @param taskId 任务委托id
     * @param reason 举报理由
     */
    void reportTask(Long whistleblowerId,Long taskId,String reason);

    /**
     * 举报活动
     * @param whistleblowerId 举报者id
     * @param activityId 活动id
     * @param reason 举报理由
     */
    void reportActivity(Long whistleblowerId,Long activityId,String reason);


}
