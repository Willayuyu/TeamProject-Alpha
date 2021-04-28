package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二手物品订单项
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsIndentBO extends BaseOrder
{
  /**
   * 二手物品信息
   */
  private GoodsInfoBO goodsInfo;

}
