package com.example.fidledemo.report.service;

import com.example.fidledemo.DO.ActivityReportMessageDO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import com.example.fidledemo.DO.TaskReportMessageDO;
import com.example.fidledemo.dao.ActivityReportMessageDAO;
import com.example.fidledemo.dao.GoodsReportMessageDAO;
import com.example.fidledemo.dao.TaskReportMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cxx
 */
@Service
public class ReportMessageServiceImpl implements ReportMessageService {
    @Autowired
    GoodsReportMessageDAO goodsReportMessageDAO;
    @Autowired
    TaskReportMessageDAO taskReportMessageDAO;
    @Autowired
    ActivityReportMessageDAO activityReportMessageDAO;


    @Override
    public void reportGoods(Long whistleblowerId, Long goodsId, String reason) {

        //建立DO
        GoodsReportMessageDO messageDO = new GoodsReportMessageDO();
        messageDO.setReason(reason);
        messageDO.setReportedGoodsId(goodsId);
        messageDO.setWhistleblowerId(whistleblowerId);
        messageDO.setState(0);
        messageDO.setTitle("用户"+whistleblowerId+"举报二手物品"+goodsId);

        //插入DO
        goodsReportMessageDAO.insertGoodsReportMessage(messageDO);
    }

    @Override
    public void reportTask(Long whistleblowerId, Long taskId, String reason) {

        //建立DO
        TaskReportMessageDO messageDO = new TaskReportMessageDO();
        messageDO.setReason(reason);
        messageDO.setReportedTaskId(taskId);
        messageDO.setWhistleblowerId(whistleblowerId);
        messageDO.setState(0);
        messageDO.setTitle("用户"+whistleblowerId+"举报任务委托"+taskId);

        //插入DO
        taskReportMessageDAO.insertTaskReportMessage(messageDO);
    }

    @Override
    public void reportActivity(Long whistleblowerId, Long activityId, String reason) {

        //建立DO
        ActivityReportMessageDO messageDO = new ActivityReportMessageDO();
        messageDO.setReason(reason);
        messageDO.setReportedActivityId(activityId);
        messageDO.setWhistleblowerId(whistleblowerId);
        messageDO.setState(0);
        messageDO.setTitle("用户"+whistleblowerId+"举报活动"+activityId);

        //插入DO
        activityReportMessageDAO.insertActivityReportMessage(messageDO);
    }
}
