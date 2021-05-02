package com.example.fidledemo.BO;

import com.example.fidledemo.DO.CreditDO;
import com.example.fidledemo.DO.UserDO;
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
  private Integer openId;

  //基本信息
  /**
   * 用户名
   */
  private String username;

  /**
   * 手机号
   */
  private String telephone;

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

  /**
   * 构造方法
   * @param openId
   * @param username
   * @param qq
   * @param wechatAccount
   * @param portrait
   * @param credit
   */
  public UserBO(Integer openId, String username, String qq,
                String wechatAccount, String portrait, CreditBO credit)
  {
    this.openId = openId;
    this.username = username;
    this.qq = qq;
    this.wechatAccount = wechatAccount;
    this.portrait = portrait;
    this.credit = credit;
  }

  /**
   * 获得UserDO
   * @return
   */
  public UserDO getUserDO()
  {
    UserDO userDO=new UserDO();
    userDO.setUsername(this.username);
    userDO.setTel(this.telephone);
    userDO.setQq(this.qq);
    userDO.setOpenId(this.openId);
    userDO.setWechatAccount(this.wechatAccount);
    userDO.setPortrait(this.portrait);
    return userDO;
  }

  /**
   * 获得CreditDO
   * @return
   */
  public CreditDO getCreditDO()
  {
    CreditDO creditDO=new CreditDO();
    creditDO.setUserId(this.credit.getUserId());
    creditDO.setCreditScore(this.credit.getCreditScore());
    creditDO.setLikeNum(this.credit.getLikeNum());
    creditDO.setDislikeNum(this.credit.getDislikeNum());
    return creditDO;
  }
}
