package com.example.fidledemo.dao;

import com.example.fidledemo.DO.GoodsEnshrineDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface GoodsEnshrineDAO {
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
}
