package com.example.fidledemo.dao;

import com.example.fidledemo.DO.ActivityTagDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface ActivityTagDAO {
    /**
     *  更新活动信息-标签关系表
     * @param activityTag
     */
    void updateActivityTag(ActivityTagDO activityTag);

    /**
     * 删除活动信息-标签关系表中的一条记录
     * @param id
     */
    void deleteActivityTag(long id);

    /**
     * 向活动信息-标签关系表中插入一条记录
     * @param activityTag
     */
    void insertActivityTag(ActivityTagDO activityTag);

    /**
     * 删除一个活动的所有标签关系
     * @param activityId
     * @return
     */
    void deleteActivityTagById(Long activityId);
}