package com.example.fidledemo.backHomepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.ReportMessage;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.DO.ActivityReportMessageDO;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import com.example.fidledemo.DO.TaskReportMessageDO;
import com.example.fidledemo.backHomepage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @Description:
 * @Author: ZSP
 */
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin/login")
    public String login(HttpServletRequest request){
        try {
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            AdminDO adminDo=new AdminDO();
            adminDo.setAccount(account);
            adminDo.setPassword(password);
            AdminBO adminBO = adminService.getAdminBoByDO(adminDo);
            HashMap<String,Object> map=new HashMap<>();
            if (adminBO!=null){
                map.put("id",adminBO.getId());
                map.put("account",adminBO.getAccount());
                return JSON.toJSONString(Result.successResult(map));
            }else {
                return JSON.toJSONString(Result.failureResult(ResultCode.LOGIN_EXCEPTION));

            }
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(Result.failureResult(ResultCode.LOGIN_EXCEPTION));
        }
    }

    @GetMapping("/admin/totalUsersNum")
    public String getTotalUser(){
        try {
            int totalUsersNum=adminService.getUserNums();
            return JSON.toJSONString(Result.successResult(totalUsersNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/totalGoodsNum")
    public String getTotalGoodsNum(){
        try {
            int totalGoodsNum=adminService.getTotalGoodsNum();
            return JSON.toJSONString(Result.successResult(totalGoodsNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/totalTasksNum")
    public String getTotalTaskNum(){
        try {
            int totalTasksNum=adminService.getTotalTaskNums();
            return JSON.toJSONString(Result.successResult(totalTasksNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/totalActivitiesNum")
    public String getTotalActivityNum(){
        try {
            int totalActivitiesNum=adminService.getTotalActivityNums();
            return JSON.toJSONString(Result.successResult(totalActivitiesNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/newUsersNum")
    public String getNewUserNums(){
        try {
            int newUsersNum = adminService.getNewUserNums();
            return JSON.toJSONString(Result.successResult(newUsersNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/newGoodsNum")
    public String getNewGoodsNums(){
        try {
            int newGoodsNum = adminService.getNewGoodsNum();
            return JSON.toJSONString(Result.successResult(newGoodsNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/newTasksNum")
    public String getNewTasksNums(){
        try {
            int newTasksNum = adminService.getNewTaskNums();
            return JSON.toJSONString(Result.successResult(newTasksNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/newActivitiesNum")
    public String getNewActivitiesNums(){
        try {
            int newActivitiesNum = adminService.getNewActivityNums();
            return JSON.toJSONString(Result.successResult(newActivitiesNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/goodsReportNum")
    public String getGoodsReportNum(){
        try{
            GoodsReportMessageDO goodsReportMessageDO = new GoodsReportMessageDO();
            goodsReportMessageDO.setState(ReportMessage.UNTREATED);
            int goodsReportNum = adminService.getGoodsReportNumByDO(goodsReportMessageDO);
            return JSON.toJSONString(Result.successResult(goodsReportNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/tasksReportNum")
    public String getTaskReportNum(){
        try{
            TaskReportMessageDO taskReportMessageDO = new TaskReportMessageDO();
            taskReportMessageDO.setState(ReportMessage.UNTREATED);
            int tasksReportNum=adminService.getTaskReportNumByDO(taskReportMessageDO);
            return JSON.toJSONString(Result.successResult(tasksReportNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    @GetMapping("/admin/activitiesReportNum")
    public String getActivityReportNum(){
        try{
            ActivityReportMessageDO activityReportMessageDO=new ActivityReportMessageDO();
            activityReportMessageDO.setState(ReportMessage.UNTREATED);
            int activitiesReportNum=adminService.getActivityReportNumByDO(activityReportMessageDO);
            return JSON.toJSONString(Result.successResult(activitiesReportNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }


}
