package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签类BO
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagBO
{
  //类别

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;

  private Long id;

  /**
   * 对应的信息id
   */
  private Long infoId;

  /**
   * 标签内容
   */
  private String content;

  /**
   * 标签类别
   */
  private Integer type;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;
}
