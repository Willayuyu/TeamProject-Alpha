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


  //评价状态

  /**
   * 未评价
   */
  public static final Integer UNEVALUATED=-1;

  /**
   * 已评价
   */
  public static final Integer EVALUATED=1;



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
  protected Integer pubEvaluated;

  /**
   * 乙方是否评价
   */
  protected Integer accEvaluated;

  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;


  /**
   * 构造方法
   * @param pubId
   * @param accId
   */
  public BaseOrder(Long pubId, Long accId)
  {
    this.pubId = pubId;
    this.accId = accId;
    this.pubEvaluated=UNEVALUATED;
    this.accEvaluated=UNEVALUATED;
  }
}
