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
     *
     * @param id 图片id
     * @return 查找所得的图片类
     */
    ImageBO getGoodsImage(Long id);

    /**
     * 插入新的二手物品图片
     *
     * @param goodsImageDO 二手物品图片类
     */
    void insertGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 更新二手物品图片
     *
     * @param goodsImageDO 二手物品图片类
     */
    void updateGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 删除二手物品图片
     *
     * @param id
     */
    void deleteGoodsImage(Long id);

    /**
     * 根据二手物品id返回全部的二手物品图片
     *
     * @param goodsImageDO 二手物品图片类
     * @return 图片列表
     */
    List<ImageBO> listGoodsImage(GoodsImageDO goodsImageDO);

    /**
     * 根据链接查询对应的id
     *
     * @param image_link
     * @return
     */
    Long getGoodsImageByLink(String image_link);

    /**
     * 根据id返回对应链接
     *
     * @param id
     * @return
     */
    String getGoodsImageById(Long id);

    /**
     * 删除二手物品相关的所有图片
     * @param id
     */
    void deleteGoodsImageById(Long id);
}
