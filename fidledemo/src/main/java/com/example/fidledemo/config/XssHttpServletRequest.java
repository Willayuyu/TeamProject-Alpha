package com.example.fidledemo.config;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 对表单参数进行转义的HttpServletRequest
 * @author 11313
 */
public class XssHttpServletRequest extends HttpServletRequestWrapper
{
  private HttpServletRequest request;

  /**
   * 构造方法
   * @param request
   */
  public XssHttpServletRequest(HttpServletRequest request)
  {
    super(request);
    this.request=request;
  }

  /**
   * 重写getParameter
   * @param name
   * @return
   */
  @Override
  public String getParameter(String name)
  {
    String value=request.getParameter(name);
    //从表单获取参数,进行转义
    if(!StringUtils.isEmpty(value))
    {
      value= StringEscapeUtils.escapeHtml4(value);
    }
    return value;
  }
}
