package com.example.fidledemo.BO;

/**
 * 返回状态枚举类
 * @author 11313
 */
public enum ResultCode
{
  /**
   * 状态码枚举
   */
  SUCCESS(200,"请求成功"),
  UN_AUTHORIZED(1001,"无访问权限"),
  SESSION_EXPIRED(1002,"会话过期"),
  LOGIN_EXCEPTION(1003,"登录状态异常"),
  RESOURCE_EMPTY(1004,"访问资源为空"),
  PARAM_ERROR(1005,"请求参数异常"),
  FILE_EMPTY(1006,"文件为空"),
  FILE_EXISTED(1007,"文件已存在"),
  UPLOAD_FAILURE(1008,"图片上传失败"),
  FORMAT_ERROR(1009,"图片格式错误"),
  IMAGE_SIZE_ERROR(1010,"图片过大"),
  SERVER_ERROR(1050,"服务端错误");


  /**
   * 状态码
   */
  private Integer code;

  /**
   * 状态描述
   */
  private String message;

  /**
   * 构造方法
   * @param code
   * @param message
   */
  ResultCode(Integer code, String message)
  {
    this.code = code;
    this.message = message;
  }

  public Integer getCode()
  {
    return code;
  }

  public void setCode(Integer code)
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
}
