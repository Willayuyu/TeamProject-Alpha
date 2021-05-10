package com.example.fidledemo.VO;

import com.example.fidledemo.BO.UserBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回信息VO
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO
{
  private PersonVO user;

  private String token;

}
