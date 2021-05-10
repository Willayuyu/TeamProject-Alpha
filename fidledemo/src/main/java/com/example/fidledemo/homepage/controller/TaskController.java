package com.example.fidledemo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskEnshrineDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.TaskCategoryVO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.VO.TaskVO;
import com.example.fidledemo.homepage.service.TaskCategoryServiceImpl;
import com.example.fidledemo.homepage.service.TaskEnshrineServiceImpl;
import com.example.fidledemo.homepage.service.TaskInfoServiceImpl;
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
public class TaskController {

    @Autowired
    TaskInfoServiceImpl taskInfoService;

    @Autowired
    TaskEnshrineServiceImpl taskEnshrineService;

    @Autowired
    TaskCategoryServiceImpl taskCategoryService;

    /**
     * 根据多选框筛选条件获得任务列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/task/listTask")
    public String getListTask(HttpServletRequest request){
        try{
            TaskInformationDO taskInformationDO = new TaskInformationDO();
            TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            int pageid=Integer.parseInt(request.getParameter("pageid"));

            taskInformationDO.setLimit(Boolean.TRUE);
            taskInformationDO.setBegin((pageid-1)*10);
            taskInformationDO.setSize(10);
            taskInformationDO.setDistinct(Boolean.TRUE);
            taskInformationDO.setCategory(categoryId);
            taskInformationDO.setTaskState(1);//1未接收
            taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
            taskInformationDO.setCreateTimeEnd(new Date());

            List<TaskItemVO> taskItemVOS = taskInfoService.listTaskInfoByDO(taskInformationDO, tagOfTaskDO);
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
            taskEnshrineDO.setUserId(userId);
            for (TaskItemVO taskItemVO:taskItemVOS) {
                taskEnshrineDO.setTaskId(taskItemVO.getId());
                if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
                    taskItemVO.setCollectState(1);
                }else {
                    taskItemVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(taskItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据多选框筛选条件及关键词获得任务列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/task/listTaskByKeyword")
    public String getListTaskByKeyword(HttpServletRequest request){
        try{
            TaskInformationDO taskInformationDO = new TaskInformationDO();
            TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            String keyWord=request.getParameter("keyWord");
            int pageid=Integer.parseInt(request.getParameter("pageid"));

            taskInformationDO.setLimit(Boolean.TRUE);
            taskInformationDO.setBegin((pageid-1)*10);
            taskInformationDO.setSize(10);
            taskInformationDO.setDistinct(Boolean.TRUE);
            taskInformationDO.setCategory(categoryId);
            taskInformationDO.setTaskState(1);//1未接收
            taskInformationDO.setTitle(keyWord);
            taskInformationDO.setTitleLike(Boolean.TRUE);
            taskInformationDO.setDescription(keyWord);
            taskInformationDO.setDescriptionLike(Boolean.TRUE);
            tagOfTaskDO.setContent(keyWord);
            tagOfTaskDO.setContentLike(Boolean.TRUE);
            taskInformationDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
            taskInformationDO.setCreateTimeEnd(new Date());

            List<TaskItemVO> taskItemVOS = taskInfoService.listTaskInfoBySearch(taskInformationDO, tagOfTaskDO);
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
            taskEnshrineDO.setUserId(userId);
            for (TaskItemVO taskItemVO:taskItemVOS) {
                taskEnshrineDO.setTaskId(taskItemVO.getId());
                if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
                    taskItemVO.setCollectState(1);
                }else {
                    taskItemVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(taskItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 获得任务类别
     * @return
     */
    @UserLoginToken
    @GetMapping("/task/listTaskCategory")
    public String getListTaskCategory(){
        try{
            List<TaskCategoryVO> taskCategoryVOS = taskCategoryService.listAllTaskCategory();
            return JSON.toJSONString(Result.successResult(taskCategoryVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据任务id和用户id收藏任务
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/task/collectTask/{id}")
    public String collectTask(@PathVariable("id") Long id, HttpServletRequest request){
        try {
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(2);
            TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
            taskEnshrineDO.setUserId(userId);
            taskEnshrineDO.setTaskId(id);
            taskEnshrineService.insertTaskEnshrine(taskEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }

    /**
     * 根据任务id和用户id取消收藏任务
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/task/cancelCollectTask/{id}")
    public String cancelCollectTask(@PathVariable("id") Long id, HttpServletRequest request){
        try {
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(2);
            TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
            taskEnshrineDO.setUserId(userId);
            taskEnshrineDO.setTaskId(id);
            taskEnshrineService.deleteTaskEnshrineByDO(taskEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }

    /**
     * 根据Id获得任务详情
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/task/getTaskDetailById/{id}")
    public String getTaskDetailById(@PathVariable("id") Long id,HttpServletRequest request){
        try {
            TaskVO taskVO = taskInfoService.getTaskInfoById(id);
            if (taskVO!=null){
                UserBO user = (UserBO) request.getSession().getAttribute("user");
                Long userId = user.getId();
                //userId= Long.valueOf(2);
                TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
                taskEnshrineDO.setUserId(userId);
                taskEnshrineDO.setTaskId(id);
                if(taskEnshrineService.getTaskEnshrine(taskEnshrineDO)!=null){
                    taskVO.setCollectState(1);
                }else {
                    taskVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(taskVO));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }
}
