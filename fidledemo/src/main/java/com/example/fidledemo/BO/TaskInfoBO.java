package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 任务信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskInfoBO extends BaseInformation
{
  /**
   * 酬劳
   */
  private Double reward;

  /**
   * 任务开始时间
   */
  private Date startTime;

  /**
   * 任务结束时间
   */
  private Date endTime;
}
