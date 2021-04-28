package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员BO
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminBO
{
  private Long id;

  //基本信息
  /**
   * 账号
   */
  private String account;

  /**
   * 密码
   */
  private String password;

  /**
   * 盐
   */
  private String salt;

  //其他信息
  /**
   * 二手举报信息列表
   */
  private MessageList<ReportMessage> goodsReportMessageList;

  /**
   * 任务举报信息列表
   */
  private MessageList<ReportMessage> taskReportMessageList;

  /**
   * 活动举报信息列表
   */
  private MessageList<ReportMessage> activityReportMessageList;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;
}

