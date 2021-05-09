package com.example.fidledemo.dao;

import com.example.fidledemo.DO.TaskTagDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface TaskTagDAO {
    /**
     *  更新任务委托-标签关系表
     * @param taskTag
     */
    void updateTaskTag(TaskTagDO taskTag);

    /**
     * 删除任务委托-标签关系表中的一条记录
     * @param id
     */
    void deleteTaskTag(long id);

    /**
     * 向任务委托-标签关系表中插入一条记录
     * @param taskTag
     */
    void insertTaskTag(TaskTagDO taskTag);

    /**
     * 检查任务委托-标签关系表中是否含有某条记录
     * @param tasktag
     * @return
     */
    Boolean checkTaskTag(TaskTagDO tasktag);
}
