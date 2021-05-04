package com.example.fidledemo.BO;

import com.example.fidledemo.DO.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 举报信息
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportMessageBO extends BaseMessage
{
  //类别

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;

  //状态
  /**
   * 未送出
   */
  public static final Integer UNSENT=-1;

  /**
   * 暂未处理
   */
  public static final Integer UNTREATED=0;

  /**
   * 被忽略
   */
  public static final Integer IGNORE=1;

  /**
   * 已封禁
   */
  public static final Integer BANNED=2;


  /**
   * 举报者id
   */
  private Long whistleblowerId;

  /**
   * 被举报信息id
   */
  private Long reportedInfoId;

  /**
   * 状态
   */
  private Integer state;

  /**
   * 类型
   */
  private Integer type;

  /**
   * 构造方法
   * @param title
   * @param content
   * @param whistleblowerId
   * @param reportedInfoId
   * @param type
   */
  public ReportMessageBO(String title, String content, Long whistleblowerId,
                         Long reportedInfoId, Integer type)
  {
    super(title, content);
    this.whistleblowerId = whistleblowerId;
    this.reportedInfoId = reportedInfoId;
    this.state = UNSENT;
    this.type = type;
  }

  /**
   * 获得GoodsReportMessageDO
   * @return
   */
  public GoodsReportMessageDO getGoodsReportMessageDO()
  {
    if (type.equals(GOODS))
    {
      GoodsReportMessageDO messageDO=new GoodsReportMessageDO();
      messageDO.setWhistleblowerId(this.whistleblowerId);
      messageDO.setReportedGoodsId(this.reportedInfoId);
      messageDO.setTitle(this.title);
      messageDO.setReason(this.content);
      messageDO.setState(this.state);
      return messageDO;
    }
    else
    {
      return null;
    }
  }

  /**
   * 获得TaskReportMessageDO
   * @return
   */
  public TaskReportMessageDO getTaskReportMessageDO()
  {
    if (type.equals(TASK))
    {
      TaskReportMessageDO messageDO=new TaskReportMessageDO();
      messageDO.setWhistleblowerId(this.whistleblowerId);
      messageDO.setReportedTaskId(this.reportedInfoId);
      messageDO.setTitle(this.title);
      messageDO.setReason(this.content);
      messageDO.setState(this.state);
      return messageDO;
    }
    else
    {
      return null;
    }
  }

  /**
   * 获得ActivityReportMessageDO
   * @return
   */
  public ActivityReportMessageDO getActivityReportMessageDO()
  {
    if (type.equals(TASK))
    {
      ActivityReportMessageDO messageDO=new ActivityReportMessageDO();
      messageDO.setWhistleblowerId(this.whistleblowerId);
      messageDO.setReportedActivityId(this.reportedInfoId);
      messageDO.setTitle(this.title);
      messageDO.setReason(this.content);
      messageDO.setState(this.state);
      return messageDO;
    }
    else
    {
      return null;
    }
  }


  @Override
  public String toString() {
    return "ReportMessageBO{" +
        "whistleblowerId=" + whistleblowerId +
        ", reportedInfoId=" + reportedInfoId +
        ", state=" + state +
        ", type=" + type +
        ", id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", gmtInfo=" + gmtInfo +
        '}';
  }
}
