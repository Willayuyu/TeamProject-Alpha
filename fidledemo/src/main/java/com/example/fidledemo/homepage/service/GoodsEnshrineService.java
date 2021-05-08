package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.GoodsEnshrineDO;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface GoodsEnshrineService {

    /**
     * 更新二手物品收藏夹中的信息
     * @param goodsEnshrineDO
     */
    void updateGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO);

    /**
     * 向二手物品收藏夹中插入一条信息
     * @param goodsEnshrineDO
     */
    void insertGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO);

    /**
     * 删除二手物品收藏夹中的一条信息
     * @param id
     */
    void deleteGoodsEnshrine(long id);

    /**
     * 根据DO删除
     * @param goodsEnshrineDO
     */
    void deleteGoodsEnshrineByDO(GoodsEnshrineDO goodsEnshrineDO);

    /**
     * 根据ActivityEnshrineDO查找
     * @param goodsEnshrineDO
     * @return
     */
    Long getGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO);
}
