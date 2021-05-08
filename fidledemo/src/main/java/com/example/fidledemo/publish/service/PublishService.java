package com.example.fidledemo.publish.service;

import com.example.fidledemo.BO.TaskInfoBO;

/**
 * @author WWJ
 */
public interface PublishService {
    /**
     * 将TaskInfoBO转换成TaskInformationDO并插入task_information中
     * @param taskInfoBO
     */
    void insertTask(TaskInfoBO taskInfoBO);

    /**
     * 判断taskTag是否存在
     * @param taskTag
     * @return
     */
    Long checkTaskTag(String taskTag);
}
