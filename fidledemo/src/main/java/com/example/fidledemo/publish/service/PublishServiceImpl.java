package com.example.fidledemo.publish.service;

import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.DO.TaskTagDO;
import com.example.fidledemo.dao.TagOfTaskDAO;
import com.example.fidledemo.dao.TaskInfoDAO;
import com.example.fidledemo.dao.TaskTagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WWJ
 */
@Service
public class PublishServiceImpl implements PublishService{
    @Autowired
    TaskInfoDAO taskInfoDAO;
    @Autowired
    TaskTagDAO taskTagDAO;
    @Autowired
    TagOfTaskDAO tagOfTaskDAO;

    @Override
    public void insertTask(TaskInfoBO taskInfoBO) {
        //将task的详细信息插入task_information
        TaskInformationDO taskInformationDO = taskInfoBO.getTaskInformationDO();
        taskInfoDAO.insertTaskInfo(taskInformationDO);

        //将task与tag的对应关系数组数组插入task_tag
        List<TaskTagDO> taskTagDOList = taskInfoBO.getTaskTagDOList();
        for (TaskTagDO taskTagDO : taskTagDOList) {
            taskTagDAO.insertTaskTag(taskTagDO);
        }
    }

    @Override
    public Long checkTaskTag(String content) {
        return tagOfTaskDAO.checkTaskTag(content);
    }
}
