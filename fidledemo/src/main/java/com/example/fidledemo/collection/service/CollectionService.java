package com.example.fidledemo.collection.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.UserDO;

import java.util.List;

/**
 * @author WWJ20
 */
public interface CollectionService {
    /**
     * 根据用户id查找其对应的活动信息收藏夹
     * @param userDO
     * @return
     */
    List<ActivityInfoBO> listActivityEnshrineByUserDO(UserDO userDO);

    /**
     * 根据用户id查找其对应的任务委托收藏夹
     *
     * @param userDO
     * @return
     */
    List<TaskInfoBO> listTaskEnshrineByUserDO(UserDO userDO);

    /**
     * 根据用户id查找其对应的二手物品收藏夹
     *
     * @param userDO
     * @return
     */
    List<GoodsInfoBO> listGoodsEnshrineByUserDO(UserDO userDO);
}
