package com.example.fidledemo.reportHandling.service;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.ActivityReportMessageDO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import com.example.fidledemo.DO.TaskReportMessageDO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.VO.UserVO;
import com.example.fidledemo.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WWJ
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    GoodsReportMessageDAO goodsReportMessageDAO;
    @Autowired
    TaskReportMessageDAO taskReportMessageDAO;
    @Autowired
    ActivityReportMessageDAO activityReportMessageDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CreditDAO creditDAO;

    @Override
    public List<ReportMessageBO> listGoodsReports() {
        List<ReportMessageBO> reportMessageBOS = goodsReportMessageDAO.listGoodsReportMessageByDO(new GoodsReportMessageDO());
        List<ReportMessageBO> reportMessageBOList = new ArrayList<>();
        for (ReportMessageBO reportMessageBO : reportMessageBOS) {
            reportMessageBO.setType(ReportMessageBO.GOODS);
            if (reportMessageBO.getState().equals(ReportMessageBO.UNTREATED)) {
                reportMessageBOList.add(reportMessageBO);
            }
        }
        return reportMessageBOList;
    }

    @Override
    public List<ReportMessageBO> listTaskReports() {
        List<ReportMessageBO> reportMessageBOS = taskReportMessageDAO.listTaskReportMessageByDO(new TaskReportMessageDO());
        List<ReportMessageBO> reportMessageBOList = new ArrayList<>();
        for (ReportMessageBO reportMessageBO : reportMessageBOS) {
            reportMessageBO.setType(ReportMessageBO.TASK);
            if (reportMessageBO.getState().equals(ReportMessageBO.UNTREATED)) {
                reportMessageBOList.add(reportMessageBO);
            }
        }
        return reportMessageBOList;
    }

    @Override
    public List<ReportMessageBO> listActivityReports() {
        List<ReportMessageBO> reportMessageBOS = activityReportMessageDAO.listActivityReportMessageByDO(new ActivityReportMessageDO());
        List<ReportMessageBO> reportMessageBOList = new ArrayList<>();
        for (ReportMessageBO reportMessageBO : reportMessageBOS) {
            reportMessageBO.setType(ReportMessageBO.ACTIVITY);
            if (reportMessageBO.getState().equals(ReportMessageBO.UNTREATED)) {
                reportMessageBOList.add(reportMessageBO);
            }
        }
        return reportMessageBOList;
    }

    @Override
    public UserVO handleGoodsReport(int reportid) {
        ReportMessageBO goodsReportMessage = goodsReportMessageDAO.getGoodsReportMessageById((long) reportid);
        goodsReportMessage.setState(ReportMessageBO.BANNED);
        goodsReportMessageDAO.updateGoodsReportMessage(goodsReportMessage.getGoodsReportMessageDO());
        Long whistleblowerId = goodsReportMessage.getWhistleblowerId();
        UserBO user = userDAO.getUserById(whistleblowerId);
        CreditBO credit = creditDAO.getCreditByWhisId(whistleblowerId);
        credit.setCreditScore(credit.getCreditScore() - 2);
        user.getCredit().setCreditScore(credit.getCreditScore());
        creditDAO.updateCredit(credit.getCreditDO());
        return new UserVO(user.getUsername(), user.getCredit().getCreditScore());
    }

    @Override
    public UserVO handleTaskReport(int reportid) {
        ReportMessageBO taskReportMessage = taskReportMessageDAO.getTaskReportMessageById((long) reportid);
        taskReportMessage.setState(ReportMessageBO.BANNED);
        taskReportMessageDAO.updateTaskReportMessage(taskReportMessage.getTaskReportMessageDO());
        Long whistleblowerId = taskReportMessage.getWhistleblowerId();
        UserBO user = userDAO.getUserById(whistleblowerId);
        CreditBO credit = creditDAO.getCreditByWhisId(whistleblowerId);
        credit.setCreditScore(credit.getCreditScore() - 2);
        user.getCredit().setCreditScore(credit.getCreditScore());
        creditDAO.updateCredit(credit.getCreditDO());
        return new UserVO(user.getUsername(), user.getCredit().getCreditScore());
    }

    @Override
    public UserVO handleActivityReport(int reportid) {
        ReportMessageBO activityReportMessage = activityReportMessageDAO.getActivityReportMessageById((long) reportid);
        activityReportMessage.setState(ReportMessageBO.BANNED);
        activityReportMessageDAO.updateActivityReportMessage(activityReportMessage.getActivityReportMessageDO());
        Long whistleblowerId = activityReportMessage.getWhistleblowerId();
        UserBO user = userDAO.getUserById(whistleblowerId);
        CreditBO credit = creditDAO.getCreditByWhisId(whistleblowerId);
        credit.setCreditScore(credit.getCreditScore() - 2);
        user.getCredit().setCreditScore(credit.getCreditScore());
        creditDAO.updateCredit(credit.getCreditDO());
        return new UserVO(user.getUsername(), user.getCredit().getCreditScore());
    }

    @Override
    public void ignoreGoodsReport(int reportid) {
        ReportMessageBO goodsReportMessage = goodsReportMessageDAO.getGoodsReportMessageById((long) reportid);
        goodsReportMessage.setState(ReportMessageBO.IGNORE);
        goodsReportMessageDAO.updateGoodsReportMessage(goodsReportMessage.getGoodsReportMessageDO());
    }

    @Override
    public void ignoreTaskReport(int reportid) {
        ReportMessageBO taskReportMessage = taskReportMessageDAO.getTaskReportMessageById((long) reportid);
        taskReportMessage.setState(ReportMessageBO.IGNORE);
        taskReportMessageDAO.updateTaskReportMessage(taskReportMessage.getTaskReportMessageDO());
    }

    @Override
    public void ignoreActivityReport(int reportid) {
        ReportMessageBO activityReportMessage = activityReportMessageDAO.getActivityReportMessageById((long) reportid);
        activityReportMessage.setState(ReportMessageBO.IGNORE);
        activityReportMessageDAO.updateActivityReportMessage(activityReportMessage.getActivityReportMessageDO());
    }
}
