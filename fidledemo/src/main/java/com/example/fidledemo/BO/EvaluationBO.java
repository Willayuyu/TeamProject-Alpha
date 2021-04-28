package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评价
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationBO
{
  //评价类别

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;



  //评价

  /**
   * 差评
   */
  public static final Integer BAD=-1;

  /**
   * 好评
   */
  public static final Integer GOOD=1;

  private Long id;

  /**
   * 对应的信息id
   */
  private Long infoId;

  /**
   * 评价者id
   */
  private Integer evaluatorId;

  /**
   * 评价理由
   */
  private String reason;

  /**
   * 评价
   */
  private Integer evaluation;

  /**
   * 评价类别
   */
  private Integer type;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;

}
