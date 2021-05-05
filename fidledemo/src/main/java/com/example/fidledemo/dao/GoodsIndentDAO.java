package com.example.fidledemo.dao;

import com.example.fidledemo.BO.GoodsIndentBO;
import com.example.fidledemo.DO.GoodsIndentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 二手订单DAO
 * @author 11313
 */
@Mapper
public interface GoodsIndentDAO
{
  /**
   * 插入
   * @param indentDO
   */
  void insertGoodsIndent(GoodsIndentDO indentDO);

  /**
   * 更新
   * @param indentDO
   */
  void updateGoodsIndent(GoodsIndentDO indentDO);

  /**
   * 根据id获得二手订单
   * @param id
   * @return
   */
  GoodsIndentBO getGoodsIndentById(Long id);

  /**
   * 根据DO获得二手订单列表
   * @param indentDO
   * @return
   */
  List<GoodsIndentBO> listGoodsIndentByDO(GoodsIndentDO indentDO);

  /**
   * 根据id删除二手订单
   * @param id
   */
  void deleteGoodsIndentById(Long id);






}