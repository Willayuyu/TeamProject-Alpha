package com.example.fidledemo.dao;

import com.example.fidledemo.DO.ActivityEnshrineDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface ActivityEnshrineDAO {
    /**
     * 更新活动信息收藏夹中的信息
     * @param activityEnshrineDO
     */
    void updateActivityEnshrine(ActivityEnshrineDO activityEnshrineDO);

    /**
     * 向活动信息收藏夹中插入一条信息
     * @param activityEnshrineDO
     */
    void insertActivityEnshrine(ActivityEnshrineDO activityEnshrineDO);

    /**
     * 删除活动信息收藏夹中的一条信息
     * @param id
     */
    void deleteActivityEnshrine(long id);
}
