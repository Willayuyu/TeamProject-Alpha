package com.example.fidledemo.sort.service;

import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.VO.TaskTagVO;
import com.example.fidledemo.dao.TaskInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11313
 */
@Service
public class TaskSortServiceImpl implements TaskSortService
{
  @Autowired
  TaskInfoDAO taskInfoDAO;

  @Override
  public List<TaskItemVO> listGoodsInfoBySearchOrderByDateDesc(TaskInformationDO infoDO, TagOfTaskDO tagDO)
  {
    List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearchOrderByDateDESC(infoDO, tagDO);
    List<TaskItemVO> taskItemVOS=new ArrayList<>();
    for (TaskInfoBO taskInfoBO:taskInfoBOS) {
      TaskItemVO taskItemVO = new TaskItemVO();
      taskItemVO.setId(taskInfoBO.getId());
      taskItemVO.setPulisherId(taskInfoBO.getPubId());
      taskItemVO.setTitle(taskInfoBO.getTitle());
      taskItemVO.setReward(taskInfoBO.getReward());
      taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());
      List<TagBO> tagList = taskInfoBO.getTagList();
      List<TaskTagVO> taskTagVOS=new ArrayList<>();
      for (TagBO tagBO:tagList) {
        TaskTagVO taskTagVO = new TaskTagVO();
        taskTagVO.setId(tagBO.getId());
        taskTagVO.setContent(tagBO.getContent());
        taskTagVOS.add(taskTagVO);
      }
      taskItemVO.setTagList(taskTagVOS);
      taskItemVOS.add(taskItemVO);
    }
    return taskItemVOS;
  }

  @Override
  public List<TaskItemVO> listGoodsInfoBySearchOrderByDateASC(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
    List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearchOrderByDateASC(infoDO, tagDO);
    List<TaskItemVO> taskItemVOS=new ArrayList<>();
    for (TaskInfoBO taskInfoBO:taskInfoBOS) {
      TaskItemVO taskItemVO = new TaskItemVO();
      taskItemVO.setId(taskInfoBO.getId());
      taskItemVO.setPulisherId(taskInfoBO.getPubId());
      taskItemVO.setTitle(taskInfoBO.getTitle());
      taskItemVO.setReward(taskInfoBO.getReward());
      taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());
      List<TagBO> tagList = taskInfoBO.getTagList();
      List<TaskTagVO> taskTagVOS=new ArrayList<>();
      for (TagBO tagBO:tagList) {
        TaskTagVO taskTagVO = new TaskTagVO();
        taskTagVO.setId(tagBO.getId());
        taskTagVO.setContent(tagBO.getContent());
        taskTagVOS.add(taskTagVO);
      }
      taskItemVO.setTagList(taskTagVOS);
      taskItemVOS.add(taskItemVO);
    }
    return taskItemVOS;
  }

  @Override
  public List<TaskItemVO> listTaskInfoBySearchOrderByRewardDesc(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
    List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearchOrderByRewardDESC(infoDO, tagDO);
    List<TaskItemVO> taskItemVOS=new ArrayList<>();
    for (TaskInfoBO taskInfoBO:taskInfoBOS) {
      TaskItemVO taskItemVO = new TaskItemVO();
      taskItemVO.setId(taskInfoBO.getId());
      taskItemVO.setPulisherId(taskInfoBO.getPubId());
      taskItemVO.setTitle(taskInfoBO.getTitle());
      taskItemVO.setReward(taskInfoBO.getReward());
      taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());
      List<TagBO> tagList = taskInfoBO.getTagList();
      List<TaskTagVO> taskTagVOS=new ArrayList<>();
      for (TagBO tagBO:tagList) {
        TaskTagVO taskTagVO = new TaskTagVO();
        taskTagVO.setId(tagBO.getId());
        taskTagVO.setContent(tagBO.getContent());
        taskTagVOS.add(taskTagVO);
      }
      taskItemVO.setTagList(taskTagVOS);
      taskItemVOS.add(taskItemVO);
    }
    return taskItemVOS;
  }

  @Override
  public List<TaskItemVO> listTaskInfoBySearchOrderByRewardASC(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
    List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearchOrderByRewardASC(infoDO, tagDO);
    List<TaskItemVO> taskItemVOS=new ArrayList<>();
    for (TaskInfoBO taskInfoBO:taskInfoBOS) {
      TaskItemVO taskItemVO = new TaskItemVO();
      taskItemVO.setId(taskInfoBO.getId());
      taskItemVO.setPulisherId(taskInfoBO.getPubId());
      taskItemVO.setTitle(taskInfoBO.getTitle());
      taskItemVO.setReward(taskInfoBO.getReward());
      taskItemVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());
      List<TagBO> tagList = taskInfoBO.getTagList();
      List<TaskTagVO> taskTagVOS=new ArrayList<>();
      for (TagBO tagBO:tagList) {
        TaskTagVO taskTagVO = new TaskTagVO();
        taskTagVO.setId(tagBO.getId());
        taskTagVO.setContent(tagBO.getContent());
        taskTagVOS.add(taskTagVO);
      }
      taskItemVO.setTagList(taskTagVOS);
      taskItemVOS.add(taskItemVO);
    }
    return taskItemVOS;
  }
}
