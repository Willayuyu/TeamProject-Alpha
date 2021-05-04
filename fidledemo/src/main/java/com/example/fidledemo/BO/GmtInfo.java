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
@NoArgsConstructor
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

}
