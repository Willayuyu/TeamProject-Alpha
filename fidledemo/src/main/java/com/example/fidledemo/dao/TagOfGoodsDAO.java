package com.example.fidledemo.dao;

import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface TagOfGoodsDAO {

    /**
     * 插入二手物品标签
     *
     * @param tagOfGoodsDO
     */
    void insertTagOfGoods(TagOfGoodsDO tagOfGoodsDO);

    /**
     * 根据id查找单个二手物品标签
     *
     * @param id 需要查询的标签的id
     * @return TagBO 返回查询到的标签
     */
    TagBO getTagOfGoods(Long id);

    /**
     * 更新二手物品标签
     *
     * @param tagOfGoodsDO 需要更新的标签
     */
    void updateTagOfGoods(TagOfGoodsDO tagOfGoodsDO);

    /**
     * 删除二手物品标签
     *
     * @param id
     */
    void deleteTagOfGoods(Long id);


    /**
     * 根据二手物品id查找该物品id的所有标签列表
     *
     * @param id 查询的二手物品信息的id
     * @return 返回该物品的所有标签
     */
    List<TagBO> listTagOfGoods(Long id);

    /**
     * 检查goodsTag是否重复
     *
     * @param content
     * @return
     */
    Long checkGoodsTag(String content);
}
