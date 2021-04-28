package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 时间信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
public class GmtInfo
{
  /**
   * 创建时间
   */
  private Date gmtCreate;

  /**
   * 修改时间
   */
  private Date gmtModified;

  /**
   * 无参构造方法
   */
  public GmtInfo()
  {
    gmtCreate=new Date();
    gmtModified=new Date();
  }

  /**
   * 更新修改时间
   */
  public void refreshGmtModified()
  {
    this.gmtModified=new Date();
  }

}
