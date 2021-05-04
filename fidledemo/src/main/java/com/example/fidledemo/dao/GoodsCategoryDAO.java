package com.example.fidledemo.dao;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.DO.GoodsCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface GoodsCategoryDAO {

    /**
     * 通过类别id获取类别
     * @param id 类别id
     * @return 查找返回的类别
     */
    CategoryBO getGoodsCategory(Long id);

    /**
     * 插入新的二手物品类别
     * @param goodsCategoryDO 要插入的二手物品类别
     */
    void insertGoodsCategory(GoodsCategoryDO goodsCategoryDO);

    /**
     * 更新已存在的二手物品类别
     * @param goodsCategoryDO 更新的二手物品类别
     */
    void updateGoodsCategory(GoodsCategoryDO goodsCategoryDO);

    /**
     * 删除已有的二手物品类别
     * @param goodsCategoryDO 要删除的二手物品类别
     */
    void deleteGoodsCategory(GoodsCategoryDO goodsCategoryDO);

    /**
     * 返回所有已有的二手物品类别
     */
    List<CategoryBO> listAllGoodsCategory();
}
