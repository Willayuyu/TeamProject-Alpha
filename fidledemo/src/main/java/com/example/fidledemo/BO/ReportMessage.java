package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 举报信息
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportMessage extends BaseMessage
{
  //类别

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;

  //状态
  /**
   * 未送出
   */
  public static final Integer UNSENT=-1;

  /**
   * 暂未处理
   */
  public static final Integer UNTREATED=0;

  /**
   * 被忽略
   */
  public static final Integer IGNORE=1;

  /**
   * 已封禁
   */
  public static final Integer BANNED=2;


  /**
   * 举报者id
   */
  private Integer whistleblowerId;

  /**
   * 被举报信息id
   */
  private Integer reportedInfoId;

  /**
   * 状态
   */
  private Integer state;

  /**
   * 类型
   */
  private Integer type;
}
