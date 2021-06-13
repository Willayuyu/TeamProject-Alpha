package com.example.fidledemo.sort.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskEnshrineDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.PageInfoVO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.homepage.service.TaskEnshrineService;
import com.example.fidledemo.homepage.utils.DateUtils;
import com.example.fidledemo.homepage.utils.PageHelper;
import com.example.fidledemo.sort.service.TaskSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class TaskSortController
{
  @Value("${size}")
  private int size;

  @Autowired
  TaskSortService taskSortService;

  @Autowired
  TaskEnshrineService taskEnshrineService;

  /**
   * 根据报酬降序排序任务列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/task/sortTask/rewardDesc")
  public String sortTaskRD(HttpServletRequest request){
    try{
      TaskInformationDO taskInformationDO = new TaskInformationDO();
      TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      String keyWord=request.getParameter("keyWord");
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      taskInformationDO.setDistinct(Boolean.TRUE);

      if (categoryId!=0){
        taskInformationDO.setCategory(categoryId);
      }

      taskInformationDO.setTaskState(TaskInfoBO.UNACCEPTED);
      taskInformationDO.setTitle(keyWord);
      taskInformationDO.setTitleLike(Boolean.TRUE);
      taskInformationDO.setDescription(keyWord);
      taskInformationDO.setDescriptionLike(Boolean.TRUE);
      tagOfTaskDO.setContent(keyWord);
      tagOfTaskDO.setContentLike(Boolean.TRUE);

      if (days!=0){
        taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
        taskInformationDO.setCreateTimeEnd(new Date());
      }

      List<TaskItemVO> taskItemVOS = taskSortService.listTaskInfoBySearchOrderByRewardDesc(taskInformationDO, tagOfTaskDO);
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
      taskEnshrineDO.setUserId(userId);
      for (TaskItemVO taskItemVO:taskItemVOS) {
        taskEnshrineDO.setTaskId(taskItemVO.getId());
        if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
          taskItemVO.setCollectState(TaskItemVO.COLLECT);
        }else {
          taskItemVO.setCollectState(TaskItemVO.DISCOLLECT);
        }
      }

      PageHelper<TaskItemVO> pageHelper = new PageHelper<>(taskItemVOS,size);
      List<TaskItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (TaskItemVO taskItemVO:itemVOList) {
        taskItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据报酬升序排序任务列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/task/sortTask/rewardAsc")
  public String sortRA(HttpServletRequest request){
    try{
      TaskInformationDO taskInformationDO = new TaskInformationDO();
      TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      String keyWord=request.getParameter("keyWord");
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      taskInformationDO.setDistinct(Boolean.TRUE);

      if (categoryId!=0){
        taskInformationDO.setCategory(categoryId);
      }

      taskInformationDO.setTaskState(TaskInfoBO.UNACCEPTED);
      taskInformationDO.setTitle(keyWord);
      taskInformationDO.setTitleLike(Boolean.TRUE);
      taskInformationDO.setDescription(keyWord);
      taskInformationDO.setDescriptionLike(Boolean.TRUE);
      tagOfTaskDO.setContent(keyWord);
      tagOfTaskDO.setContentLike(Boolean.TRUE);

      if (days!=0){
        taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
        taskInformationDO.setCreateTimeEnd(new Date());
      }

      List<TaskItemVO> taskItemVOS = taskSortService.listTaskInfoBySearchOrderByRewardASC(taskInformationDO, tagOfTaskDO);
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
      taskEnshrineDO.setUserId(userId);
      for (TaskItemVO taskItemVO:taskItemVOS) {
        taskEnshrineDO.setTaskId(taskItemVO.getId());
        if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
          taskItemVO.setCollectState(TaskItemVO.COLLECT);
        }else {
          taskItemVO.setCollectState(TaskItemVO.DISCOLLECT);
        }
      }

      PageHelper<TaskItemVO> pageHelper = new PageHelper<>(taskItemVOS,size);
      List<TaskItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (TaskItemVO taskItemVO:itemVOList) {
        taskItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据时间降序排序任务列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/task/sortTask/dateDesc")
  public String sortTaskDD(HttpServletRequest request){
    try{
      TaskInformationDO taskInformationDO = new TaskInformationDO();
      TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      String keyWord=request.getParameter("keyWord");
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      taskInformationDO.setDistinct(Boolean.TRUE);

      if (categoryId!=0){
        taskInformationDO.setCategory(categoryId);
      }

      taskInformationDO.setTaskState(TaskInfoBO.UNACCEPTED);
      taskInformationDO.setTitle(keyWord);
      taskInformationDO.setTitleLike(Boolean.TRUE);
      taskInformationDO.setDescription(keyWord);
      taskInformationDO.setDescriptionLike(Boolean.TRUE);
      tagOfTaskDO.setContent(keyWord);
      tagOfTaskDO.setContentLike(Boolean.TRUE);

      if (days!=0){
        taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
        taskInformationDO.setCreateTimeEnd(new Date());
      }

      List<TaskItemVO> taskItemVOS = taskSortService.listGoodsInfoBySearchOrderByDateDesc(taskInformationDO, tagOfTaskDO);
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
      taskEnshrineDO.setUserId(userId);
      for (TaskItemVO taskItemVO:taskItemVOS) {
        taskEnshrineDO.setTaskId(taskItemVO.getId());
        if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
          taskItemVO.setCollectState(TaskItemVO.COLLECT);
        }else {
          taskItemVO.setCollectState(TaskItemVO.DISCOLLECT);
        }
      }

      PageHelper<TaskItemVO> pageHelper = new PageHelper<>(taskItemVOS,size);
      List<TaskItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (TaskItemVO taskItemVO:itemVOList) {
        taskItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据时间升序排序任务列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/task/sortTask/dateAsc")
  public String sortDA(HttpServletRequest request){
    try{
      TaskInformationDO taskInformationDO = new TaskInformationDO();
      TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      String keyWord=request.getParameter("keyWord");
      int pageid=Integer.parseInt(request.getParameter("pageid"));
      taskInformationDO.setDistinct(Boolean.TRUE);

      if (categoryId!=0){
        taskInformationDO.setCategory(categoryId);
      }

      taskInformationDO.setTaskState(TaskInfoBO.UNACCEPTED);
      taskInformationDO.setTitle(keyWord);
      taskInformationDO.setTitleLike(Boolean.TRUE);
      taskInformationDO.setDescription(keyWord);
      taskInformationDO.setDescriptionLike(Boolean.TRUE);
      tagOfTaskDO.setContent(keyWord);
      tagOfTaskDO.setContentLike(Boolean.TRUE);

      if (days!=0){
        taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
        taskInformationDO.setCreateTimeEnd(new Date());
      }

      List<TaskItemVO> taskItemVOS = taskSortService.listGoodsInfoBySearchOrderByDateASC(taskInformationDO, tagOfTaskDO);
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
      taskEnshrineDO.setUserId(userId);
      for (TaskItemVO taskItemVO:taskItemVOS) {
        taskEnshrineDO.setTaskId(taskItemVO.getId());
        if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
          taskItemVO.setCollectState(TaskItemVO.COLLECT);
        }else {
          taskItemVO.setCollectState(TaskItemVO.DISCOLLECT);
        }
      }

      PageHelper<TaskItemVO> pageHelper = new PageHelper<>(taskItemVOS,size);
      List<TaskItemVO> itemVOList = pageHelper.getPageByNum(pageid);

      for (TaskItemVO taskItemVO:itemVOList) {
        taskItemVO.setPageInfo(new PageInfoVO(pageid,pageHelper.getTotalPage(),pageHelper.getTotalNum()));
      }

      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

}
