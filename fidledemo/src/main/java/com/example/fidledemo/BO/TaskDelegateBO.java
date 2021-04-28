package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 任务委托项
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDelegateBO extends BaseOrder
{

  /**
   * 任务委托信息
   */
  private TaskInfoBO taskInfo;
}
