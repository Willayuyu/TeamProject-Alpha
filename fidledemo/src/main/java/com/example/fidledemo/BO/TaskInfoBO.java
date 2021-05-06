package com.example.fidledemo.BO;

import com.example.fidledemo.DO.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 任务信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskInfoBO extends BaseInformation
{
  //任务状态

  /**
   * 已取消
   */
  public static final Integer CANCELED=-1;

  /**
   * 未接收
   */
  public static final Integer UNACCEPTED=0;

  /**
   * 进行中
   */
  public static final Integer PROCESSING=1;

  /**
   * 已完成
   */
  public static final Integer COMPLETED=2;



  /**
   * 酬劳
   */
  private BigDecimal reward;

  /**
   * 任务开始时间
   */
  private Date startTime;

  /**
   * 任务结束时间
   */
  private Date endTime;

  /**
   * 任务状态
   */
  private Integer state;

  /**
   * 构造方法
   * @param pubId
   * @param title
   * @param description
   * @param tagList
   * @param categoryId
   * @param categoryDesignation
   * @param reward
   * @param startTime
   * @param endTime
   */
  public TaskInfoBO(Long pubId, String title, String description, List<TagBO> tagList,
                    Integer categoryId, String categoryDesignation, BigDecimal reward, Date startTime, Date endTime) {
    super(pubId, title, description, tagList, categoryId, categoryDesignation, TagBO.TASK);
    this.reward = reward;
    this.startTime = startTime;
    this.endTime = endTime;
    this.state=UNACCEPTED;
  }

  /**
   * 获得TaskInformationDO
   * @return
   */
  public TaskInformationDO getTaskInformationDO()
  {
    TaskInformationDO infoDO=new TaskInformationDO();
    infoDO.setId(this.id);
    infoDO.setPubId(this.pubId);
    infoDO.setTitle(this.title);
    infoDO.setReward(this.reward);
    infoDO.setStartTime(this.startTime);
    infoDO.setEndTime(this.endTime);
    infoDO.setCategory(this.category.getCategoryId());
    infoDO.setDescription(this.description);
    infoDO.setTaskState(this.state);
    return infoDO;
  }

  /**
   * 获得TagOfTaskDO列表
   * @return
   */
  public List<TagOfTaskDO> getTagOfTaskDOList()
  {
    List<TagOfTaskDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
      TagOfTaskDO tagDO=new TagOfTaskDO();
      tagDO.setId(tagBO.getId());
      tagDO.setContent(tagBO.getContent());
      list.add(tagDO);
    }
    return list;
  }

  /**
   * 获得TaskTagDO列表
   * @return
   */
  public List<TaskTagDO> getTaskTagDOList()
  {
    List<TaskTagDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
      TaskTagDO tagDO=new TaskTagDO();
      tagDO.setId(tagBO.getId());
      tagDO.setTagId(tagBO.getId());
      tagDO.setTaskId(this.id);
      list.add(tagDO);
    }
    return list;
  }


  @Override
  public String toString() {
    return "TaskInfoBO{" +
        "reward=" + reward +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", state=" + state +
        ", id=" + id +
        ", pubId=" + pubId +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", tagList=" + tagList +
        ", category=" + category +
        ", gmtInfo=" + gmtInfo +
        '}';
  }
}
