package com.example.fidledemo.dao;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.DO.TaskCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface TaskCategoryDAO {

    /**
     * 通过类别id获取类别
     * @param id 类别id
     * @return 查找返回的类别
     */
    CategoryBO getTaskCategory(Long id);

    /**
     * 插入新的任务委托 类别
     * @param taskCategoryDO 要插入的任务委托类别
     */
    void insertTaskCategory(TaskCategoryDO taskCategoryDO);

    /**
     * 更新已存在的任务委托类别
     * @param taskCategoryDO 更新的任务委托类别
     */
    void updateTaskCategory(TaskCategoryDO taskCategoryDO);

    /**
     * 删除已有的任务委托类别
     * @param id
     */
    void deleteTaskCategory(Long id);

    /**
     * 返回所有已有的任务委托类别
     */
    List<CategoryBO> listAllTaskCategory();
}
