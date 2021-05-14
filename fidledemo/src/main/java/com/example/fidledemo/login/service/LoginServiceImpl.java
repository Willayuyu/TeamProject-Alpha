package com.example.fidledemo.login.service;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.dao.CreditDAO;
import com.example.fidledemo.dao.UserDAO;
import com.example.fidledemo.login.util.LoginResult;
import com.example.fidledemo.login.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录相关业务接口实现类
 * @author 11313
 */
@Service
public class LoginServiceImpl implements LoginService
{
  @Autowired
  private UserDAO userDAO;

  @Autowired
  private CreditDAO creditDAO;

  @Override
  public UserBO loginRequest(String code)
  {
    LoginResult result=null;
    String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    String url = String.format(urlFormat, LoginUtil.APP_ID, LoginUtil.SECRET, code);
    String json = LoginUtil.httpRequest(url,"GET",null);


    System.out.println("json:"+json);

    //将json字符串转化成对象
    result = JSON.parseObject(json, LoginResult.class);

    String openId=result.getOpenid();
    UserDO userDO=new UserDO();

    System.out.println(openId);

    userDO.setOpenId(openId);

    //判断该用户是否第一次登录
    if(userDAO.getUserByOpenId(openId)==null)
    {
      //若第一次登录则插入openId
      userDAO.insertUser(userDO);
    }
    //返回对应的user信息
    return userDAO.getUserByOpenId(openId);
  }

  @Override
  public UserBO userAuth(Long id, String wechatAccount, String portrait)
  {
    UserDO userDO=new UserDO();
    //插入用户授权后的信息
    UserBO user=userDAO.getUserById(id);

    if("".equals(user.getUsername())||user.getUsername()==null)
    {
      userDO.setUsername(wechatAccount);
    }
    userDO.setId(id);
    userDO.setWechatAccount(wechatAccount);
    userDO.setPortrait(portrait);

    userDAO.updateUser(userDO);

    //插入信誉信息
    if(user.getCredit()==null)
    {
      CreditBO creditBO=new CreditBO(id,500,0,0);
      creditDAO.insertCredit(creditBO.getCreditDO());
    }
    return userDAO.getUserById(id);
  }


}
