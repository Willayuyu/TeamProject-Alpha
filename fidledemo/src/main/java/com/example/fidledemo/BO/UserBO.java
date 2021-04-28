package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户BO类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO
{

  private Long id;

  /**
   * 用户唯一标识id
   */
  private Long openId;

  //基本信息
  /**
   * 用户名
   */
  private String username;

  /**
   * QQ
   */
  private String qq;

  /**
   * 微信号
   */
  private String wechatAccount;

  /**
   * 头像链接
   */
  private String portrait;


  //其他信息
  /**
   * 用户历史信息
   */
  private HistoryInformation history;

  /**
   * 用户收藏信息
   */
  private EnshrineInformation enshrine;

  /**
   * 用户信誉信息
   */
  private CreditBO credit;

  /**
   * 系统消息列表
   */
  private MessageList<SystemMessageBO> systemMessageList;


  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;




}
