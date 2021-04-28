package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 二手物品信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfoBO extends BaseInformation
{
  /**
   * 售价
   */
  private Double price;

  /**
   * 原价
   */
  private Double originalPrice;

  /**
   * 图片列表
   */
  private List<ImageBO> imageBOList;

  /**
   * 新旧程度
   */
  private Integer condition;



}
