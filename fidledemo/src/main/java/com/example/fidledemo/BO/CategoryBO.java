package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类别
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBO
{
  //分类

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;


  private Long id;

  /**
   * 类别编号
   */
  private Long categoryId;

  /**
   *  类别名称
   */
  private String categoryDesignation;

  /**
   * 类别分类
   */
  private Integer type;

  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;

  /**
   * 构造方法
   * @param categoryId
   * @param categoryDesignation
   * @param type
   */
  public CategoryBO(Long categoryId, String categoryDesignation, Integer type)
  {
    this.categoryId = categoryId;
    this.categoryDesignation = categoryDesignation;
    this.type = type;
  }

}
