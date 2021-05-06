package com.example.fidledemo.BO;

import com.example.fidledemo.DO.ActivityImageDO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.ActivityTagDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 活动信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInfoBO extends BaseInformation
{
  /**
   * 活动地点
   */
  private String address;

  /**
   * 图片列表
   */
  private List<ImageBO> imageList;


  /**
   * 任务开始时间
   */
  private Date startTime;

  /**
   * 任务结束时间
   */
  private Date endTime;

  /**
   * 生成新的ActivityInfoBO
   * @param pubId
   * @param title
   * @param description
   * @param tagList
   * @param categoryId
   * @param categoryDesignation
   * @param address
   * @param startTime
   * @param endTime
   */
  public ActivityInfoBO(Long pubId, String title, String description, List<TagBO> tagList,
                        Integer categoryId, String categoryDesignation,List<ImageBO> imageList,
                        String address, Date startTime, Date endTime) {
    super(pubId, title, description, tagList, categoryId, categoryDesignation, TagBO.ACTIVITY);
    this.address = address;
    this.startTime = startTime;
    this.endTime = endTime;
    this.imageList=imageList;
  }


  /**
   * 获得ActivityInfoDO
   * @return
   */
  public ActivityInfoDO getActivityInfoDO()
  {
    ActivityInfoDO activityInfoDO=new ActivityInfoDO();
    activityInfoDO.setId(this.id);
    activityInfoDO.setPubId(this.pubId);
    activityInfoDO.setTitle(this.title);
    activityInfoDO.setAddress(this.address);
    activityInfoDO.setStartTime(this.startTime);
    activityInfoDO.setEndTime(this.endTime);
    activityInfoDO.setCategory(this.category.getCategoryId());
    activityInfoDO.setDescription(this.description);
    return activityInfoDO;
  }

  /**
   * 获得TagOfActivityDO列表
   * @return
   */
  public List<TagOfActivityDO> getTagOfActivityDOList()
  {
    List<TagOfActivityDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
        TagOfActivityDO tagDO=new TagOfActivityDO();
        tagDO.setId(tagBO.getId());
        tagDO.setContent(tagBO.getContent());
        list.add(tagDO);
    }
    return list;
  }

  /**
   * 获得ActivityTagDO列表
   * @return
   */
  public List<ActivityTagDO> getActivityTagDOList()
  {
    List<ActivityTagDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
      ActivityTagDO tagDO=new ActivityTagDO();
      tagDO.setTagId(tagBO.getId());
      tagDO.setActivityId(this.id);
      list.add(tagDO);
    }
    return list;
  }

  /**
   * 获得ActivityImageDO列表
   * @return
   */
  public List<ActivityImageDO> getActivityImageDOList()
  {
    List<ActivityImageDO> list=new ArrayList<>();
    for (ImageBO imageBO:imageList)
    {
      ActivityImageDO imageDO=new ActivityImageDO();
      imageDO.setId(imageBO.getId());
      imageDO.setActivityId(this.id);
      imageDO.setImageLink(imageBO.getImageLink());
      list.add(imageDO);
    }
    return list;
  }

  @Override
  public String toString() {
    return "ActivityInfoBO{" +
        "address='" + address + '\'' +
        ", imageList=" + imageList +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
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
