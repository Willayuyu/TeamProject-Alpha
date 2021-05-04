package com.example.fidledemo.BO;

import com.example.fidledemo.DO.SystemMessageDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统消息
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemMessageBO extends BaseMessage
{
  //状态

  /**
   * 未送出
   */
  public static final Integer UNSENT=-1;

  /**
   * 未读
   */
  public static final Integer UNREAD=0;

  /**
   * 已读
   */
  public static final Integer READ=1;



  /**
   * 接收者id
   */
  private Long accId;

  /**
   * 链接
   */
  private String link;

  /**
   * 消息状态
   */
  private Integer state;

  /**
   * 构造方法
   * @param title
   * @param content
   * @param accId
   * @param link
   */
  public SystemMessageBO(String title, String content, Long accId, String link)
  {
    super(title, content);
    this.accId = accId;
    this.link = link;
    this.state = UNSENT;
  }

  /**
   * 获得SystemMessageDO
   * @return
   */
  public SystemMessageDO getSystemMessageDO()
  {
    SystemMessageDO messageDO=new SystemMessageDO();
    messageDO.setAccId(this.accId);
    messageDO.setTitle(this.title);
    messageDO.setContent(this.content);
    messageDO.setLink(this.link);
    messageDO.setState(this.state);
    return messageDO;
  }


  @Override
  public String toString() {
    return "SystemMessageBO{" +
        "accId=" + accId +
        ", link='" + link + '\'' +
        ", state=" + state +
        ", id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", gmtInfo=" + gmtInfo +
        '}';
  }
}
