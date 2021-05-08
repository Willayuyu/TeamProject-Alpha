package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.ActivityEnshrineDO;
import com.example.fidledemo.dao.ActivityEnshrineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class ActivityEnshrineServiceImpl implements ActivityEnshrineService{

    @Autowired
    ActivityEnshrineDAO activityEnshrineDAO;

    @Override
    public void updateActivityEnshrine(ActivityEnshrineDO activityEnshrineDO) {

    }

    @Override
    public void insertActivityEnshrine(ActivityEnshrineDO activityEnshrineDO) {
        activityEnshrineDAO.insertActivityEnshrine(activityEnshrineDO);
    }

    @Override
    public void deleteActivityEnshrine(long id) {

    }

    @Override
    public void deleteActivityEnshrineByDO(ActivityEnshrineDO activityEnshrineDO) {
        activityEnshrineDAO.deleteActivityEnshrineByDO(activityEnshrineDO);
    }

    @Override
    public Long getActivityEnshrine(ActivityEnshrineDO activityEnshrineDO) {
        return activityEnshrineDAO.getActivityEnshrine(activityEnshrineDO);
    }
}
