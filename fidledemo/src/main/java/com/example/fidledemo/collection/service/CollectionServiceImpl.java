package com.example.fidledemo.collection.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.dao.ActivityInfoDAO;
import com.example.fidledemo.dao.GoodsInfoDAO;
import com.example.fidledemo.dao.TaskInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WWJ20
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    ActivityInfoDAO activityInfoDAO;
    @Autowired
    TaskInfoDAO taskInfoDAO;
    @Autowired
    GoodsInfoDAO goodsInfoDAO;

    @Override
    public List<ActivityInfoBO> listActivityEnshrineByUserDO(UserDO userDO) {
        return activityInfoDAO.listActivityEnshrineByUserDO(userDO);
    }

    @Override
    public List<TaskInfoBO> listTaskEnshrineByUserDO(UserDO userDO) {
        return taskInfoDAO.listTaskEnshrineByUserDO(userDO);
    }

    @Override
    public List<GoodsInfoBO> listGoodsEnshrineByUserDO(UserDO userDO) {
        return goodsInfoDAO.listGoodsEnshrineByUserDO(userDO);
    }
}
