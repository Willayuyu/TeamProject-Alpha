package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.TaskEnshrineDO;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface TaskEnshrineService {

    /**
     * 更新任务委托收藏夹中的信息
     * @param taskEnshrineDO
     */
    void updateTaskEnshrine(TaskEnshrineDO taskEnshrineDO);

    /**
     * 向任务委托收藏夹中插入一条信息
     * @param taskEnshrineDO
     */
    void insertTaskEnshrine(TaskEnshrineDO taskEnshrineDO);

    /**
     * 删除任务委托收藏夹中的一条信息
     * @param id
     */
    void deleteTaskEnshrine(long id);

    /**
     * 根据DO删除
     * @param taskEnshrineDO
     */
    void deleteTaskEnshrineByDO(TaskEnshrineDO taskEnshrineDO);

    /**
     * 根据TaskEnshrineDO查找
     * @param taskEnshrineDO
     * @return
     */
    Long getTaskEnshrine(TaskEnshrineDO taskEnshrineDO);
}
