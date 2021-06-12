package com.example.fidledemo.backHomepage.controller;

import com.alibaba.fastjson.JSON;
<<<<<<< Updated upstream
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.BackGoodsItemVO;
import com.example.fidledemo.VO.PageInfoVO;
=======
import com.example.fidledemo.BO.ReportMessage;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.DO.ActivityReportMessageDO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import com.example.fidledemo.DO.TaskReportMessageDO;
>>>>>>> Stashed changes
import com.example.fidledemo.backHomepage.service.AdminService;
import com.example.fidledemo.homepage.utils.DateUtils;
import com.example.fidledemo.homepage.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
=======
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@RestController
@PropertySource("classpath:application.yml")
public class AdminController {

    @Value("${size}")
    private int size;

    @Autowired
    AdminService adminService;

    /**
     * 返回总用户数
     * @return
     */
    @GetMapping("/admin/totalUsersNum")
    public String getTotalUser(){
        try {
            int totalUsersNum=adminService.getUserNums();
            return JSON.toJSONString(Result.successResult(totalUsersNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回总二手物品数
     * @return
     */
    @GetMapping("/admin/totalGoodsNum")
    public String getTotalGoodsNum(){
        try {
            int totalGoodsNum=adminService.getTotalGoodsNum();
            return JSON.toJSONString(Result.successResult(totalGoodsNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回总任务数
     * @return
     */
    @GetMapping("/admin/totalTasksNum")
    public String getTotalTaskNum(){
        try {
            int totalTasksNum=adminService.getTotalTaskNums();
            return JSON.toJSONString(Result.successResult(totalTasksNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回总活动数
     * @return
     */
    @GetMapping("/admin/totalActivitiesNum")
    public String getTotalActivityNum(){
        try {
            int totalActivitiesNum=adminService.getTotalActivityNums();
            return JSON.toJSONString(Result.successResult(totalActivitiesNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回今日新增用户数
     * @return
     */
    @GetMapping("/admin/newUsersNum")
    public String getNewUserNums(){
        try {
            int newUsersNum = adminService.getNewUserNums();
            return JSON.toJSONString(Result.successResult(newUsersNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回今日新发布二手物品数
     * @return
     */
    @GetMapping("/admin/newGoodsNum")
    public String getNewGoodsNums(){
        try {
            int newGoodsNum = adminService.getNewGoodsNum();
            return JSON.toJSONString(Result.successResult(newGoodsNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回今日新发布任务数
     * @return
     */
    @GetMapping("/admin/newTasksNum")
    public String getNewTasksNums(){
        try {
            int newTasksNum = adminService.getNewTaskNums();
            return JSON.toJSONString(Result.successResult(newTasksNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回今日新发布活动数
     * @return
     */
    @GetMapping("/admin/newActivitiesNum")
    public String getNewActivitiesNums(){
        try {
            int newActivitiesNum = adminService.getNewActivityNums();
            return JSON.toJSONString(Result.successResult(newActivitiesNum));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 返回未处理二手物品举报数
     * @return
     */
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

    /**
     * 返回未处理任务举报数
     * @return
     */
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

    /**
     * 返回未处理活动举报数
     * @return
     */
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

    /**
     * 根据给定时间 返回近n天的 二手物品、任务、活动发布数趋势图
     * @param request
     * @return
     * @throws ParseException
     */
    @PostMapping("/admin/releaseNumTrend")
    public String getGoodsNumByTime(HttpServletRequest request) throws ParseException {
        try {
            int days= Integer.parseInt(request.getParameter("dayNum"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sDate=sdf.format(new Date());
            Date endDate=sdf.parse(sDate);
            List<HashMap<String,Object>> goodsReleaseList=new ArrayList<>();
            List<HashMap<String,Object>> tasksReleaseList=new ArrayList<>();
            List<HashMap<String,Object>> activitiesReleaseList=new ArrayList<>();

            /**
             * 时间跨度 如果刚好为7的倍数取(days/7) 否则+1
             */
            int span=(days%7)==0?(days/7):((days/7)+1);

            Date beginDate= DateUtils.addAndSubtractDaysByCalendar(endDate,-(span*7));
            for (int i=1;i<=7;i++){
                HashMap<String,Object> goods=new HashMap<>();
                HashMap<String,Object> task=new HashMap<>();
                HashMap<String,Object> activity=new HashMap<>();
                endDate=DateUtils.addAndSubtractDaysByCalendar(beginDate,span);
                goods.put("beginTime",sdf.format(beginDate));
                goods.put("endTime",sdf.format(endDate));
                goods.put("releaseNum",adminService.getGoodsNumByTime(beginDate,endDate));
                task.put("beginTime",sdf.format(beginDate));
                task.put("endTime",sdf.format(endDate));
                task.put("releaseNum",adminService.getTasksNumByTime(beginDate,endDate));
                activity.put("beginTime",sdf.format(beginDate));
                activity.put("endTime",sdf.format(endDate));
                activity.put("releaseNum",adminService.getActivityNumByTime(beginDate,endDate));
                goodsReleaseList.add(goods);
                tasksReleaseList.add(task);
                activitiesReleaseList.add(activity);
                beginDate=DateUtils.addAndSubtractDaysByCalendar(beginDate,span);
            }

            HashMap<String,Object> map=new HashMap<>();
            map.put("goodsReleaseList",goodsReleaseList);
            map.put("tasksReleaseList",tasksReleaseList);
            map.put("activitiesReleaseList",activitiesReleaseList);
            return JSON.toJSONString(Result.successResult(map));
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据多选框筛选条件获得二手列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/admin/listGoods")
    public String getListGoods(HttpServletRequest request){
        try{
            GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
            TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            int pageid=Integer.parseInt(request.getParameter("pageid"));


            goodsInfoDO.setDistinct(Boolean.TRUE);

            if(categoryId!=0){
                goodsInfoDO.setCategory(categoryId);
            }


            if(days!=0){
                goodsInfoDO.setCreateTimeEnd(new Date());
                goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
            }


            List<BackGoodsItemVO> goodsItemVOS = adminService.listGoodsInfoByDO(goodsInfoDO, tagOfGoodsDO);


            PageHelper<BackGoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
            List<BackGoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);

            for (BackGoodsItemVO goodsItemVO:itemVOList) {
                goodsItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
            }
            return JSON.toJSONString(Result.successResult(itemVOList));
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据多选框筛选条件及关键词获得二手列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/admin/listGoodsByKeyword")
    public String getListGoodsByKeyword(HttpServletRequest request){

        try{
            GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
            TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();

            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            String keyWord=request.getParameter("keyWord");
            int pageid=Integer.parseInt(request.getParameter("pageid"));


            goodsInfoDO.setDistinct(Boolean.TRUE);
            goodsInfoDO.setTitle(keyWord);
            goodsInfoDO.setTitleLike(Boolean.TRUE);
            goodsInfoDO.setDescription(keyWord);
            goodsInfoDO.setDescriptionLike(Boolean.TRUE);

            if(categoryId!=0){
                goodsInfoDO.setCategory(categoryId);
            }


            goodsInfoDO.setSold(GoodsInfoBO.SELLING);

            if(days!=0){
                goodsInfoDO.setCreateTimeEnd(new Date());
                goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
            }

            tagOfGoodsDO.setContent(keyWord);
            tagOfGoodsDO.setContentLike(Boolean.TRUE);

            List<BackGoodsItemVO> goodsItemVOS = adminService.listGoodsInfoBySearch(goodsInfoDO, tagOfGoodsDO);

            PageHelper<BackGoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
            List<BackGoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);

            for (BackGoodsItemVO goodsItemVO:itemVOList) {
                goodsItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
            }

            return JSON.toJSONString(Result.successResult(itemVOList));
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }


}
