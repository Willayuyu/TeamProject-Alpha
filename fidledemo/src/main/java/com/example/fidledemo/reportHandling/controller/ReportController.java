package com.example.fidledemo.reportHandling.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.VO.UserVO;
import com.example.fidledemo.homepage.utils.PageHelper;
import com.example.fidledemo.reportHandling.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WWJ
 */
@RestController
@RequestMapping("/admin")
@PropertySource("classpath:application.yml")
public class ReportController {
    @Autowired
    ReportService reportService;
    @Value("${size}")
    private int size;

    @GetMapping("/goodsReport/page/{pageid}")
    public String goodsReport(@PathVariable("pageid") int pageid) {
        List<ReportMessageBO> reportMessageBOS = reportService.listGoodsReports();
        PageHelper<ReportMessageBO> pageHelper = new PageHelper<>(reportMessageBOS, size);
        List<ReportMessageBO> reportMessageBOSLimited = pageHelper.getPageByNum(pageid);
        return JSON.toJSONString(Result.successResult(reportMessageBOSLimited));
    }

    @GetMapping("/tasksReport/page/{pageid}")
    public String tasksReport(@PathVariable("pageid") int pageid) {
        List<ReportMessageBO> reportMessageBOS = reportService.listTaskReports();
        PageHelper<ReportMessageBO> pageHelper = new PageHelper<>(reportMessageBOS, size);
        List<ReportMessageBO> reportMessageBOSLimited = pageHelper.getPageByNum(pageid);
        return JSON.toJSONString(Result.successResult(reportMessageBOSLimited));
    }

    @GetMapping("/activitiesReport/page/{pageid}")
    public String activitiesReport(@PathVariable("pageid") int pageid) {
        List<ReportMessageBO> reportMessageBOS = reportService.listActivityReports();
        PageHelper<ReportMessageBO> pageHelper = new PageHelper<>(reportMessageBOS, size);
        List<ReportMessageBO> reportMessageBOSLimited = pageHelper.getPageByNum(pageid);
        return JSON.toJSONString(Result.successResult(reportMessageBOSLimited));
    }

    @GetMapping("/handleGoodsReport/{reportid}")
    public String handleGoodsReport(@PathVariable("reportid") int reportid) {
        UserVO userVO = reportService.handleGoodsReport(reportid);
        return JSON.toJSONString(Result.successResult(userVO));
    }

    @GetMapping("/handleTaskReport/{reportid}")
    public String handleTaskReport(@PathVariable("reportid") int reportid) {
        UserVO userVO = reportService.handleTaskReport(reportid);
        return JSON.toJSONString(Result.successResult(userVO));
    }

    @GetMapping("/handleActivityReport/{reportid}")
    public String handleActivityReport(@PathVariable("reportid") int reportid) {
        UserVO userVO = reportService.handleActivityReport(reportid);
        return JSON.toJSONString(Result.successResult(userVO));
    }

    @GetMapping("/ignoreGoodsReport/{reportid}")
    public String ignoreGoodsReport(@PathVariable("reportid") int reportid) {
        reportService.ignoreGoodsReport(reportid);
        return JSON.toJSONString(Result.successResult());
    }

    @GetMapping("/ignoreTaskReport/{reportid}")
    public String ignoreTaskReport(@PathVariable("reportid") int reportid) {
        reportService.ignoreTaskReport(reportid);
        return JSON.toJSONString(Result.successResult());
    }

    @GetMapping("/ignoreActivityReport/{reportid}")
    public String ignoreActivityReport(@PathVariable("reportid") int reportid) {
        reportService.ignoreActivityReport(reportid);
        return JSON.toJSONString(Result.successResult());
    }

}
