package com.example.fidledemo.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.PassToken;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.dao.AdminDAO;
import com.example.fidledemo.dao.UserDAO;
import com.example.fidledemo.homepage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *  权限验证拦截器
 * @author 11313
 */
public class AuthenticationInterceptor implements HandlerInterceptor
{
  @Autowired
  UserDAO userDAO;

  @Autowired
  AdminDAO adminDAO;

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception
  {
    // 从 http 请求头中取出 token
    String token = httpServletRequest.getHeader("token");


    System.out.println("token:"+token);



    // 如果不是映射到方法直接通过
    if (!(object instanceof HandlerMethod))
    {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) object;
    Method method = handlerMethod.getMethod();
    //检查是否有passtoken注释，有则跳过认证
    if (method.isAnnotationPresent(PassToken.class))
    {
      PassToken passToken = method.getAnnotation(PassToken.class);
      if (passToken.required())
      {
        return true;
      }
    }

    //检查有没有需要用户权限的注解
    if (method.isAnnotationPresent(UserLoginToken.class))
    {
      UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
      if (userLoginToken.required())
      {
        // 执行认证
        if (token == null)
        {
          throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        long id;
        UserBO user=null;
        AdminBO admin=null;
        try
        {
          id = Long.parseLong(JWT.decode(token).getAudience().get(0));


          System.out.println("id:"+id);

          if(id>=10000)
          {
            httpServletRequest.getSession().setAttribute("user",userDAO.getUserById(1L));
            long adminId=id-10000;
            AdminDO adminDO=new AdminDO();
            adminDO.setId(adminId);
            admin=adminDAO.getAdminBoByDO(adminDO);
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getAccount())).build();
            try
            {
              jwtVerifier.verify(token);
            }
            catch (JWTVerificationException e)
            {
              throw new RuntimeException("401");
            }
            if (admin == null)
            {
              throw new RuntimeException("用户不存在，请重新登录");
            }
          }
          else
          {
            user = userDAO.getUserById(id);
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getOpenId())).build();
            try
            {
              jwtVerifier.verify(token);
            }
            catch (JWTVerificationException e)
            {
              throw new RuntimeException("401");
            }
            if (user == null)
            {
              throw new RuntimeException("用户不存在，请重新登录");
            }
          }
        }
        catch (JWTDecodeException j)
        {
          throw new RuntimeException("401");
        }


        return true;
      }
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         Object o, ModelAndView modelAndView) throws Exception
  {

  }
  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Object o, Exception e) throws Exception
  {
  }

}