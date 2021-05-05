package com.example.fidledemo.dao;

import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 二手物品DAO
 * @author 11313
 */
@Mapper
public interface GoodsInfoDAO
{
  /**
   * 插入
   * @param infoDO
   */
  void insertGoodsInfo(GoodsInfoDO infoDO);

  /**
   * 更新
   * @param infoDO
   */
  void updateGoodsInfo(GoodsInfoDO infoDO);

  /**
   * 根据id获得二手物品信息
   * @param id
   * @return
   */
  GoodsInfoBO getGoodsInfoById(Long id);

  /**
   * 根据DO查询二手物品列表
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsInfoBO> listGoodsInfoByDO(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

  /**
   * 根据DO搜索二手物品列表
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<GoodsInfoBO> listGoodsInfoBySearch(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);


  /**
   * 根据id删除二手物品
   * @param id
   */
  void deleteGoodsInfoById(Long id);



}