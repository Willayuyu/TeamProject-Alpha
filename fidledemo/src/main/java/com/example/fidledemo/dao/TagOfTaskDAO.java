package com.example.fidledemo.dao;

import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface TagOfTaskDAO {

    /**
     * 插入任务委托标签
     * @param tagOfTaskDO 插入的二手任务委托类
     */
    void insertTagOfTask(TagOfTaskDO tagOfTaskDO);

    /**
     * 根据id查找单个任务委托标签
     * @param  id 需要查询的标签的id
     * @return TagBO 返回查询到的标签
     */
    TagBO getTagOfTask(Long id);

    /**
     * 更新任务委托标签
     * @param tagOfTaskDO 需要更新的标签
     */
    void updateTagOfTask(TagOfTaskDO tagOfTaskDO);

    /**
     * 删除任务委托标签
     * @param id
     */
    void deleteTagOfTask(Long id);


    /**
     * 根据任务委托id查找该任务委托的所有标签列表
     * @param id 查询的任务委托信息的id
     * @return 返回该任务委托的所有标签
     */
    List<TagBO> listTagOfTask(Long id);
}
