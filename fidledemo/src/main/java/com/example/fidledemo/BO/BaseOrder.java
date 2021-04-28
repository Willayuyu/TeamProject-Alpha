package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单项抽象类
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseOrder
{
  /**
   * 订单项id
   */
  protected Long id;

  /**
   * 甲方id
   */
  protected Long pubId;

  /**
   * 乙方id
   */
  protected Long accId;

  /**
   * 甲方评价
   */
  protected EvaluationBO pubEvaluationBO;

  /**
   * 乙方评价
   */
  protected EvaluationBO accEvaluationBO;

  /**
   * 甲方是否评价
   */
  protected Boolean pubEvaluated;

  /**
   * 乙方是否评价
   */
  protected Boolean accEvaluated;

  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;

}
