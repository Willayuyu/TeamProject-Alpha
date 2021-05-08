package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.VO.TaskTagVO;
import com.example.fidledemo.VO.TaskVO;
import com.example.fidledemo.dao.TaskInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class TaskInfoServiceImpl implements TaskInfoService{

    @Autowired
    TaskInfoDAO taskInfoDAO;

    @Override
    public TaskVO getTaskInfoById(Long id) {
        TaskInfoBO taskInfoBO = taskInfoDAO.getTaskInfoById(id);
        TaskVO taskVO = new TaskVO();

        if (taskInfoBO!=null){
            taskVO.setId(taskInfoBO.getId());
            taskVO.setPubId(taskInfoBO.getPubId());
            taskVO.setReward(taskInfoBO.getReward());
            taskVO.setTitle(taskInfoBO.getTitle());
            taskVO.setDescription(taskInfoBO.getDescription());
            taskVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());

            List<TagBO> tagList = taskInfoBO.getTagList();
            List<TaskTagVO> taskTagVOS=new ArrayList<>();
            for (TagBO tagBO:tagList) {
                TaskTagVO taskTagVO = new TaskTagVO();
                taskTagVO.setId(tagBO.getId());
                taskTagVO.setContent(tagBO.getContent());
                taskTagVOS.add(taskTagVO);
            }

            taskVO.setTagList(taskTagVOS);
            taskVO.setStartTime(taskInfoBO.getStartTime());
            taskVO.setEndTime(taskInfoBO.getEndTime());
        }
        return taskVO;
    }

    @Override
    public List<TaskItemVO> listTaskInfoByDO(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
        List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoByDO(infoDO, tagDO);

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
    public List<TaskItemVO> listTaskInfoBySearch(TaskInformationDO infoDO, TagOfTaskDO tagDO) {
        List<TaskInfoBO> taskInfoBOS = taskInfoDAO.listTaskInfoBySearch(infoDO, tagDO);
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
