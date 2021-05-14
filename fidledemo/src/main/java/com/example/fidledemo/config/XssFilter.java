package com.example.fidledemo.config;


import com.example.fidledemo.dao.UserDAO;
import com.example.fidledemo.homepage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 通用过滤器
 * @author 11313
 */
@WebFilter(urlPatterns = "/*", filterName = "XssFilter")
public class XssFilter implements Filter
{
  @Autowired
  private UserDAO userDAO;

  @Override
  public void init(FilterConfig arg0)
  {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException
  {
    HttpServletRequest request=(HttpServletRequest) servletRequest;
//    request.getSession().setAttribute("user",userDAO.getUserById(1L));

    //创建XSSHttpServletRequest实例，对表单输入的< > 进行转义
    XssHttpServletRequest req=new XssHttpServletRequest(request);
    filterChain.doFilter(req, servletResponse);
  }

  @Override
  public void destroy()
  {

  }

}

