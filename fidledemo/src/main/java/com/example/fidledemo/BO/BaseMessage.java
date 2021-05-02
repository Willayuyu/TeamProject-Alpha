package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息抽象类
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseMessage
{
  protected Long id;

  /**
   * 标题
   */
  protected String title;

  /**
   * 内容
   */
  protected String content;


  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;

  /**
   * 构造方法
   * @param title
   * @param content
   */
  public BaseMessage(String title, String content)
  {
    this.title = title;
    this.content = content;
  }
}
