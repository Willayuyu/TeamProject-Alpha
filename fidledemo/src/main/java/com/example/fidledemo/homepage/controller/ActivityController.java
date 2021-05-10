package com.example.fidledemo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.DO.ActivityEnshrineDO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.VO.ActivityCategoryVO;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.ActivityVO;
import com.example.fidledemo.homepage.service.ActivityCategoryServiceImpl;
import com.example.fidledemo.homepage.service.ActivityEnshrineServiceImpl;
import com.example.fidledemo.homepage.service.ActivityInfoServiceImpl;
import com.example.fidledemo.homepage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@RestController
public class ActivityController {

    @Autowired
    ActivityInfoServiceImpl activityInfoService;

    @Autowired
    ActivityEnshrineServiceImpl activityEnshrineService;

    @Autowired
    ActivityCategoryServiceImpl activityCategoryService;

    /**
     * 根据多选框筛选条件获得活动列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/activity/listActivity")
    public String getListActivity(HttpServletRequest request){
        try{
            ActivityInfoDO activityInfoDO = new ActivityInfoDO();
            TagOfActivityDO tagOfActivityDO = new TagOfActivityDO();

            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            int pageid=Integer.parseInt(request.getParameter("pageid"));

            activityInfoDO.setLimit(Boolean.TRUE);
            activityInfoDO.setBegin((pageid-1)*10);
            activityInfoDO.setSize(10);
            activityInfoDO.setDistinct(Boolean.TRUE);
            activityInfoDO.setCategory(categoryId);
            activityInfoDO.setCreateTimeEnd(new Date());
            activityInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));

            List<ActivityItemVO> activityItemVOS = activityInfoService.listActivityInfoByDO(activityInfoDO, tagOfActivityDO);

            //判断是否被该用户收藏
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
            activityEnshrineDO.setUserId(userId);
            for (ActivityItemVO activityItemVO:activityItemVOS) {
                activityEnshrineDO.setActivityId(activityItemVO.getId());
                if(activityEnshrineService.getActivityEnshrine(activityEnshrineDO)!=null){
                    activityItemVO.setCollectState(1);
                }else{
                    activityItemVO.setCollectState(0);
                }
            }

            return JSON.toJSONString(Result.successResult(activityItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据多选框筛选条件和关键词获得活动列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/activity/listActivityByKeyword")
    public String getListActivityByKeyword(HttpServletRequest request){
        try{
            ActivityInfoDO activityInfoDO = new ActivityInfoDO();
            TagOfActivityDO tagOfActivityDO = new TagOfActivityDO();

            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            System.out.println(categoryId);
            int pageid=Integer.parseInt(request.getParameter("pageid"));
            String keyWord=request.getParameter("keyWord");

            activityInfoDO.setLimit(Boolean.TRUE);
            activityInfoDO.setBegin((pageid-1)*10);
            activityInfoDO.setSize(10);
            activityInfoDO.setDistinct(Boolean.TRUE);
            activityInfoDO.setCategory(categoryId);
            activityInfoDO.setCreateTimeEnd(new Date());
            activityInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));

            activityInfoDO.setTitle(keyWord);
            activityInfoDO.setTitleLike(Boolean.TRUE);
            activityInfoDO.setAddress(keyWord);
            activityInfoDO.setAddressLike(Boolean.TRUE);
            activityInfoDO.setDescription(keyWord);
            activityInfoDO.setDescriptionLike(Boolean.TRUE);

            tagOfActivityDO.setContent(keyWord);
            tagOfActivityDO.setContentLike(Boolean.TRUE);

            List<ActivityItemVO> activityItemVOS = activityInfoService.listActivityInfoBySearch(activityInfoDO, tagOfActivityDO);

            //判断是否被该用户收藏
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
            activityEnshrineDO.setUserId(userId);
            for (ActivityItemVO activityItemVO:activityItemVOS) {
                activityEnshrineDO.setActivityId(activityItemVO.getId());
                if(activityEnshrineService.getActivityEnshrine(activityEnshrineDO)!=null){
                    activityItemVO.setCollectState(1);
                }else{
                    activityItemVO.setCollectState(0);
                }
            }

            return JSON.toJSONString(Result.successResult(activityItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 获得活动类别
     * @return
     */
    @UserLoginToken
    @GetMapping("/activity/listActivityCategory")
    public String getListActivityCategory(){
        try{
            List<ActivityCategoryVO> activityCategoryVOS = activityCategoryService.listAllActivityCategory();
            return JSON.toJSONString(Result.successResult(activityCategoryVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据活动id和用户id收藏活动
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/activity/collectActivity/{id}")
    public String collectActivity(@PathVariable("id") Long id, HttpServletRequest request){
        try{
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(2);
            ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
            activityEnshrineDO.setUserId(userId);
            activityEnshrineDO.setActivityId(id);
            activityEnshrineService.insertActivityEnshrine(activityEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }


    /**
     * 根据活动id和用户id取消收藏活动
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/activity/cancelCollectActivity/{id}")
    public String cancelCollectActivity(@PathVariable("id") Long id, HttpServletRequest request){
        try{
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(2);
            ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
            activityEnshrineDO.setUserId(userId);
            activityEnshrineDO.setActivityId(id);
            activityEnshrineService.deleteActivityEnshrineByDO(activityEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }

    /**
     * 根据id获得活动详情
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/activity/getActivityDetailById/{id}")
    public String getActivityDetailById(@PathVariable("id") Long id,HttpServletRequest request){
        try{
            ActivityVO activityVO = activityInfoService.getActivityInfoById(id);
            if (activityVO!=null){
                UserBO user = (UserBO) request.getSession().getAttribute("user");
                Long userId = user.getId();
                //userId= Long.valueOf(2);
                ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
                activityEnshrineDO.setUserId(userId);
                activityEnshrineDO.setActivityId(id);
                if(activityEnshrineService.getActivityEnshrine(activityEnshrineDO)!=null){
                    activityVO.setCollectState(1);
                }else {
                    activityVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(activityVO));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }
}
