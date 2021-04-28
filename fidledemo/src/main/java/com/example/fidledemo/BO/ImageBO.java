package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片BO类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageBO
{
  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;

  private Long id;

  /**
   * 图片链接
   */
  private String imageLink;

  /**
   * 图片类别
   */
  private Integer category;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;

}
