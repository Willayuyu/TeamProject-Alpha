package com.example.fidledemo.BO;

import com.example.fidledemo.DO.ActivityImageDO;
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
   * 对应的信息id
   */
  private Long infoId;

  /**
   * 图片链接
   */
  private String imageLink;

  /**
   * 图片类别
   */
  private Integer type;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;

  /**
   * 构造方法
   * @param infoId
   * @param imageLink
   * @param type
   */
  public ImageBO(Long infoId, String imageLink, Integer type)
  {
    this.infoId = infoId;
    this.imageLink = imageLink;
    this.type = type;
  }
}
