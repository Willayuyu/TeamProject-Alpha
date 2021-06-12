package com.example.fidledemo.report.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.report.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zyf
 */
@RestController
public class ReportController {
    @Autowired
    ReportServiceImpl reportService;

    @PostMapping("/goods/reportGoods")
    @UserLoginToken
    public String reportGoods(HttpServletRequest request, HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        Long id = new Long(request.getParameter("id"));
        String reason = request.getParameter("reason");
        reportService.reportGoods(whistleblowerId,id,reason);

        return JSON.toJSONString(Result.successResult());
    }

    @PostMapping("/task/reportTask")
    @UserLoginToken
    public String reportTask(HttpServletRequest request,HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        Long id = new Long(request.getParameter("id"));
        String reason = request.getParameter("reason");
        reportService.reportTask(whistleblowerId,id,reason);

        return JSON.toJSONString(Result.successResult());
    }

    @PostMapping("/activity/reportActivity")
    @UserLoginToken
    public String reportActivity(HttpServletRequest request,HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        Long id = new Long(request.getParameter("id"));
        String reason = request.getParameter("reason");
        reportService.reportActivity(whistleblowerId,id,reason);

        return JSON.toJSONString(Result.successResult());
    }

}
