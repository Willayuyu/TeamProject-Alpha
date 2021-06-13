package com.example.fidledemo.sort.service;

import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 11313
 */
public interface GoodsSortService
{
  /**
   * 搜索二手物品列表并根据新旧程度降序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsItemVO> listGoodsInfoBySearchOrderByConditionDesc(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

  /**
   * 搜索二手物品列表并根据新旧程度升序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsItemVO> listGoodsInfoBySearchOrderByConditionASC(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

  /**
   * 搜索二手物品列表并根据价格降序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsItemVO> listGoodsInfoBySearchOrderByPriceDesc(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

  /**
   * 搜索二手物品列表并根据价格升序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsItemVO> listGoodsInfoBySearchOrderByPriceASC(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);
}
