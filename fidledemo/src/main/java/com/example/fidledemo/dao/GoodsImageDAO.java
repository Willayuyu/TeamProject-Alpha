package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.DO.GoodsImageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface GoodsImageDAO {

    /**
     * 根据id获取二手物品图片
     * @param id 图片id
     * @return 查找所得的图片类
     */
    ImageBO getGoodsImage(Long id);

    /**
     * 插入新的二手物品图片
     * @param goodsImageDO 二手物品图片类
     */
    void insertGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 更新二手物品图片
     * @param goodsImageDO 二手物品图片类
     */
    void updateGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 删除二手物品图片
     * @param goodsImageDO 二手物品图片类
     */
    void deleteGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 根据二手物品id返回全部的二手物品图片
     * @param goodsImageDO 二手物品图片类
     * @return 图片列表
     */
    List<ImageBO> listGoodsImage(GoodsImageDO goodsImageDO);

}
