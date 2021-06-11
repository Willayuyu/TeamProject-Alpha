package com.example.fidledemo.report.controller;

import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.report.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zyf
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportServiceImpl reportService;

    @PostMapping("/goods")
    @UserLoginToken
    public void reportGoods(Long id, String reason, HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        reportService.reportGoods(whistleblowerId,id,reason);
    }

    @PostMapping("/task")
    @UserLoginToken
    public void reportTask(Long id,String reason,HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        reportService.reportTask(whistleblowerId,id,reason);
    }

    @PostMapping("/activity")
    @UserLoginToken
    public void reportActivity(Long id,String reason,HttpSession session){
        UserBO userBO = (UserBO) session.getAttribute("user");
        Long whistleblowerId = userBO.getId();
        reportService.reportActivity(whistleblowerId,id,reason);
    }

}
