package com.example.fidledemo.dao;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.DO.ActivityCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface ActivityCategoryDAO {
    /**
     * 通过类别id获取类别
     * @param id 类别id
     * @return 查找返回的类别
     */
    CategoryBO getActivityCategory(Long id);

    /**
     * 插入新的活动类别
     * @param activityCategoryDO 要插入的活动类别
     */
    void insertActivityCategory(ActivityCategoryDO activityCategoryDO);

    /**
     * 更新已存在的活动类别
     * @param activityCategoryDO 更新的活动类别
     */
    void updateActivityCategory(ActivityCategoryDO activityCategoryDO);

    /**
     * 删除已有的活动类别
     * @param activityCategoryDO 要删除的活动类别
     */
    void deleteActivityCategory(ActivityCategoryDO activityCategoryDO);

    /**
     * 返回所有已有的活动类别
     */
    List<CategoryBO> listAllActivityCategory();
}
