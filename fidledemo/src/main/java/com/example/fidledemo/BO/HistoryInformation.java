package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的历史信息
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryInformation
{
  /**
   * 用户id
   */
  private Long userId;

  /**
   * 在售二手物品列表
   */
  private InformationList<GoodsInfoBO> sellingGoodsList;

  /**
   * 未被接受的任务委托列表
   */
  private InformationList<TaskInfoBO> notReceivedTaskList;

  /**
   * 已发布的活动信息列表
   */
  private InformationList<ActivityInfoBO> publishedActivityList;

  /**
   * 已售出的二手物品订单列表
   */
  private OrderList<GoodsIndentBO> soldGoodsIndentList;

  /**
   * 已买入的二手物品订单列表
   */
  private OrderList<GoodsIndentBO> boughtGoodsIndentList;

  /**
   * 已接受的任务委托项列表
   */
  private OrderList<TaskDelegateBO> receivedTaskDelegateList;

}
