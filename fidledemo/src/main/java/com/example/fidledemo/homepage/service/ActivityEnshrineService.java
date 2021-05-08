package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.ActivityEnshrineDO;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface ActivityEnshrineService {

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

    /**
     * 根据DO删除
     * @param activityEnshrineDO
     */
    void deleteActivityEnshrineByDO(ActivityEnshrineDO activityEnshrineDO);


    /**
     * 根据ActivityEnshrineDO查找
     * @param activityEnshrineDO
     * @return
     */
    Long getActivityEnshrine(ActivityEnshrineDO activityEnshrineDO);
}
