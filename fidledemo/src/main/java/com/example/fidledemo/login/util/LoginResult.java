package com.example.fidledemo.login.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小程序登录结果类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult
{


  /**
   * 用户唯一标识
   */
  private String openid;

  /**
   * 会话密钥
   */
  private String session_key;

  /**
   * 用户在开放平台的唯一标识符
   */
  private String unionid;

  /**
   * 错误码
   */
  private Integer errcode;

  /**
   * 错误信息
   */
  private String errmsg;

}
