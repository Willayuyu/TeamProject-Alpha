package com.example.fidledemo.BO;

import java.io.Serializable;

/**
 * 返回结果
 * @author 11313
 */
public class Result implements Serializable
{
  /**
   * 状态码
   */
  private int code;

  /**
   * 状态描述
   */
  private String message;

  /**
   * 返回数据
   */
  private Object data;


  /**
   * 默认构造
   */
  public Result()
  {
  }


  /**
   * 构造方法
   * @param resultCode
   * @param data
   */
  public Result(ResultCode resultCode, Object data)
  {
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.data = data;
  }

  /**
   * 请求成功
   * @return
   */
  public static Result successResult()
  {
    Result result=new Result();
    result.setResultCode(ResultCode.SUCCESS);
    return result;
  }

  /**
   * 请求成功
   * @param data
   * @return
   */
  public static Result successResult(Object data)
  {
    Result result=new Result();
    result.setResultCode(ResultCode.SUCCESS);
    result.setData(data);
    return result;
  }

  /**
   * 请求失败
   * @param resultCode
   * @return
   */
  public static Result failureResult(ResultCode resultCode)
  {
    Result result=new Result();
    result.setResultCode(resultCode);
    return result;
  }

  /**
   * 请求失败
   * @param resultCode
   * @param data
   * @return
   */
  public static Result successResult(ResultCode resultCode,Object data)
  {
    Result result=new Result();
    result.setResultCode(resultCode);
    result.setData(data);
    result.setResultCode(resultCode);
    return result;
  }

  public int getCode()
  {
    return code;
  }

  public void setCode(int code)
  {
    this.code = code;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public Object getData()
  {
    return data;
  }

  public void setData(Object data)
  {
    this.data = data;
  }

  public void setResultCode(ResultCode resultCode)
  {
    this.code=resultCode.getCode();
    this.message=resultCode.getMessage();
  }
}
