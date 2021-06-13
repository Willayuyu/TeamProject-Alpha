package com.example.fidledemo.sort.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.PageInfoVO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.homepage.service.ActivityEnshrineService;
import com.example.fidledemo.homepage.service.ActivityEnshrineServiceImpl;
import com.example.fidledemo.homepage.service.ActivityInfoServiceImpl;
import com.example.fidledemo.homepage.utils.DateUtils;
import com.example.fidledemo.homepage.utils.PageHelper;
import com.example.fidledemo.sort.service.ActivitySortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author 11313
 */
@RestController
public class ActivitySortController
{
  @Value("${size}")
  private int size;

  @Autowired
  ActivitySortService activitySortService;

  @Autowired
  ActivityEnshrineService activityEnshrineService;

  /**
   * 根据时间降序排序活动列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/activity/sortActivity/dateDesc")
  public String sortActivityDD(HttpServletRequest request){
    try{
      ActivityInfoDO activityInfoDO = new ActivityInfoDO();
      TagOfActivityDO tagOfActivityDO = new TagOfActivityDO();

      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      String keyWord=request.getParameter("keyWord");

            /*activityInfoDO.setLimit(Boolean.TRUE);
            activityInfoDO.setBegin((pageid-1)*size);
            activityInfoDO.setSize(size);*/

      activityInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        activityInfoDO.setCategory(categoryId);
      }

      if(days!=0){
        activityInfoDO.setCreateTimeEnd(new Date());
        activityInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }

      activityInfoDO.setTitle(keyWord);
      activityInfoDO.setTitleLike(Boolean.TRUE);
      activityInfoDO.setAddress(keyWord);
      activityInfoDO.setAddressLike(Boolean.TRUE);
      activityInfoDO.setDescription(keyWord);
      activityInfoDO.setDescriptionLike(Boolean.TRUE);

      tagOfActivityDO.setContent(keyWord);
      tagOfActivityDO.setContentLike(Boolean.TRUE);

      List<ActivityItemVO> activityItemVOS = activitySortService.listActivityInfoBySearchOrderByDateDesc(activityInfoDO, tagOfActivityDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
      activityEnshrineDO.setUserId(userId);
      for (ActivityItemVO activityItemVO:activityItemVOS) {
        activityEnshrineDO.setActivityId(activityItemVO.getId());
        if(activityEnshrineService.getActivityEnshrine(activityEnshrineDO)!=null){
          activityItemVO.setCollectState(ActivityItemVO.COLLECT);
        }else{
          activityItemVO.setCollectState(ActivityItemVO.DISCOLLECT);
        }
      }

      PageHelper<ActivityItemVO> pageHelper = new PageHelper<>(activityItemVOS,size);
      List<ActivityItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (ActivityItemVO activityItemVO:itemVOList) {
        activityItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据时间升序排序活动列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/activity/sortActivity/dateAsc")
  public String sortDA(HttpServletRequest request){
    try{
      ActivityInfoDO activityInfoDO = new ActivityInfoDO();
      TagOfActivityDO tagOfActivityDO = new TagOfActivityDO();

      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      String keyWord=request.getParameter("keyWord");

            /*activityInfoDO.setLimit(Boolean.TRUE);
            activityInfoDO.setBegin((pageid-1)*size);
            activityInfoDO.setSize(size);*/

      activityInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        activityInfoDO.setCategory(categoryId);
      }

      if(days!=0){
        activityInfoDO.setCreateTimeEnd(new Date());
        activityInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }

      activityInfoDO.setTitle(keyWord);
      activityInfoDO.setTitleLike(Boolean.TRUE);
      activityInfoDO.setAddress(keyWord);
      activityInfoDO.setAddressLike(Boolean.TRUE);
      activityInfoDO.setDescription(keyWord);
      activityInfoDO.setDescriptionLike(Boolean.TRUE);

      tagOfActivityDO.setContent(keyWord);
      tagOfActivityDO.setContentLike(Boolean.TRUE);

      List<ActivityItemVO> activityItemVOS = activitySortService.listActivityBySearchOrderByDateASC(activityInfoDO, tagOfActivityDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
      activityEnshrineDO.setUserId(userId);
      for (ActivityItemVO activityItemVO:activityItemVOS) {
        activityEnshrineDO.setActivityId(activityItemVO.getId());
        if(activityEnshrineService.getActivityEnshrine(activityEnshrineDO)!=null){
          activityItemVO.setCollectState(ActivityItemVO.COLLECT);
        }else{
          activityItemVO.setCollectState(ActivityItemVO.DISCOLLECT);
        }
      }

      PageHelper<ActivityItemVO> pageHelper = new PageHelper<>(activityItemVOS,size);
      List<ActivityItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (ActivityItemVO activityItemVO:itemVOList) {
        activityItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }
}
