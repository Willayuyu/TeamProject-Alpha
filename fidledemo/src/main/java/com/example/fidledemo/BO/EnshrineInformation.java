package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收藏信息
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnshrineInformation
{
  private Long userId;

  /**
   * 二手物品收藏夹
   */
  private InformationList<GoodsInfoBO> goodsEnshrine;

  /**
   * 活动信息收藏夹
   */
  private InformationList<ActivityInfoBO> activityEnshrine;

  /**
   * 任务信息收藏夹
   */
  private InformationList<TaskInfoBO> taskEnshrine;



}
