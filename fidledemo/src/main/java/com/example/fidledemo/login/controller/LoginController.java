package com.example.fidledemo.login.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.CreditVO;
import com.example.fidledemo.VO.LoginVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.login.service.LoginService;
import com.example.fidledemo.login.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.Period;

/**
 * 登录相关
 * @author 11313
 */
@RestController
@RequestMapping("/login")
public class LoginController
{
  @Autowired
  private LoginService loginService;

  @PostMapping("/loginRequest")
  public String loginRequest(@RequestParam("code") String code, HttpSession session)
  {

    System.out.println("code:"+code);

    UserBO userBO=loginService.loginRequest(code);

    System.out.println(userBO);

    session.setAttribute("user",userBO);

    String token=TokenUtil.getToken(userBO);
    session.setAttribute("token",token);

    PersonVO personVO=new PersonVO();
    personVO.setId(userBO.getId());
    personVO.setPortrait(userBO.getPortrait());
    personVO.setQq(userBO.getQq());
    personVO.setTel(userBO.getTelephone());
    personVO.setUsername(userBO.getWechatAccount());

    CreditVO creditVO=new CreditVO();
    if(userBO.getCredit()!=null)
    {
      creditVO.setCreditScore(userBO.getCredit().getCreditScore());
      creditVO.setLikeNum(userBO.getCredit().getLikeNum());
      creditVO.setDislikeNum(userBO.getCredit().getDislikeNum());
    }

    personVO.setCredit(creditVO);

    return JSON.toJSONString(Result.successResult(new LoginVO(personVO,token)));
  }

  @UserLoginToken
  @PostMapping("/userAuth")
  public String userAuth(@RequestParam("nickname") String wechatAccount,@RequestParam("avatar_url") String portrait,HttpSession session)
  {
    UserBO user= (UserBO) session.getAttribute("user");
    UserBO newUser=loginService.userAuth(user.getId(),wechatAccount,portrait);
    session.setAttribute("user",newUser);
    return JSON.toJSONString(Result.successResult(newUser));
  }

}
