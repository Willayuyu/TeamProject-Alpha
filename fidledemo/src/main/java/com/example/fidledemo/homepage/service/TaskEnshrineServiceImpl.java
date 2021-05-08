package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.TaskEnshrineDO;
import com.example.fidledemo.dao.TaskEnshrineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class TaskEnshrineServiceImpl implements TaskEnshrineService{

    @Autowired
    TaskEnshrineDAO taskEnshrineDAO;

    @Override
    public void updateTaskEnshrine(TaskEnshrineDO taskEnshrineDO) {

    }

    @Override
    public void insertTaskEnshrine(TaskEnshrineDO taskEnshrineDO) {
        taskEnshrineDAO.insertTaskEnshrine(taskEnshrineDO);
    }

    @Override
    public void deleteTaskEnshrine(long id) {

    }

    @Override
    public void deleteTaskEnshrineByDO(TaskEnshrineDO taskEnshrineDO) {
        taskEnshrineDAO.deleteTaskEnshrineByDO(taskEnshrineDO);
    }

    @Override
    public Long getTaskEnshrine(TaskEnshrineDO taskEnshrineDO) {
        return taskEnshrineDAO.getTaskEnshrine(taskEnshrineDO);
    }
}
