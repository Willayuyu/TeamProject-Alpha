package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统消息
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemMessageBO extends BaseMessage
{
  //状态

  /**
   * 未送出
   */
  public static final Integer UNSENT=-1;

  /**
   * 未读
   */
  public static final Integer UNREAD=0;

  /**
   * 已读
   */
  public static final Integer READ=1;



  /**
   * 接收者id
   */
  private Long accId;

  /**
   * 链接
   */
  private String link;

  /**
   * 消息状态
   */
  private Integer state;



}
