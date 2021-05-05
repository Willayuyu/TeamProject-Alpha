package com.example.fidledemo.dao;

import com.example.fidledemo.DO.GoodsTagDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WWJ
 */
@Mapper
@Repository
public interface GoodsTagDAO {
    /**
     *  更新二手物品-标签关系表
     * @param goodsTag
     */
    void updateGoodsTag(GoodsTagDO goodsTag);

    /**
     * 删除二手物品-标签关系表中的一条记录
     * @param id
     */
    void deleteGoodsTag(long id);

    /**
     * 向二手物品-标签关系表中插入一条记录
     * @param goodsTag
     */
    void insertGoodsTag(GoodsTagDO goodsTag);
}
