package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 活动信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInfoBO extends BaseInformation
{
  /**
   * 活动地点
   */
  private String address;

  /**
   * 任务开始时间
   */
  private Date startTime;

  /**
   * 任务结束时间
   */
  private Date endTime;

}
