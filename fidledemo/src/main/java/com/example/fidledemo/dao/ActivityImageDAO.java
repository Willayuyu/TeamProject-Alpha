package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.DO.ActivityImageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface ActivityImageDAO {

    /**
     * 根据id获取活动图片
     * @param id 图片id
     * @return 查找所得的图片类
     */
    ImageBO getActivityImage(Long id);

    /**
     * 插入新的活动图片
     * @param activityImageDO 活动图片类
     */
    void insertActivityImage(ActivityImageDO activityImageDO);

    /**
     * 更新活动图片
     * @param activityImageDO 活动图片类
     */
    void updateActivityImage(ActivityImageDO activityImageDO);

    /**
     * 删除活动图片
     * @param activityImageDO 活动图片类
     */
    void deleteActivityImage(ActivityImageDO activityImageDO);

    /**
     * 根据活动id返回全部的活动图片
     * @param activityImageDO 活动图片类
     * @return 图片列表
     */
    List<ImageBO> listActivityImage(ActivityImageDO activityImageDO);
}
