package com.example.fidledemo.sort.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.ActivityTagVO;
import com.example.fidledemo.dao.ActivityInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11313
 */
@Service
public class ActivitySortServiceImpl implements ActivitySortService
{
  @Autowired
  ActivityInfoDAO activityInfoDAO;

  @Override
  public List<ActivityItemVO> listActivityInfoBySearchOrderByDateDesc(ActivityInfoDO infoDO, TagOfActivityDO tagDO)
  {
    List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoBySearchOrderByDateDESC(infoDO, tagDO);
    List<ActivityItemVO> activityItemVOS=new ArrayList<>();
    for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
      ActivityItemVO activityItemVO = new ActivityItemVO();
      activityItemVO.setId(activityInfoBO.getId());
      activityItemVO.setTitle(activityInfoBO.getTitle());
      activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

      activityItemVO.setGmt_create(activityInfoBO.getGmtInfo().getGmtCreate());
      activityItemVO.setAnnouncer(activityInfoBO.getPubName());
      activityItemVO.setPublisherId(activityInfoBO.getPubId());

      List<TagBO> tagList = activityInfoBO.getTagList();
      List<ActivityTagVO> activityTagVOS=new ArrayList<>();

      for (TagBO tagBO:tagList) {
        ActivityTagVO activityTagVO = new ActivityTagVO();
        activityTagVO.setId(tagBO.getId());
        activityTagVO.setContent(tagBO.getContent());
        activityTagVOS.add(activityTagVO);
      }
      activityItemVO.setImageLink(activityInfoBO.getImageList().get(0).getImageLink());
      activityItemVO.setTagList(activityTagVOS);
      activityItemVOS.add(activityItemVO);
    }
    return activityItemVOS;
  }

  @Override
  public List<ActivityItemVO> listActivityBySearchOrderByDateASC(ActivityInfoDO infoDO, TagOfActivityDO tagDO)
  {
    List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoBySearchOrderByDateASC(infoDO, tagDO);
    List<ActivityItemVO> activityItemVOS=new ArrayList<>();
    for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
      ActivityItemVO activityItemVO = new ActivityItemVO();
      activityItemVO.setId(activityInfoBO.getId());
      activityItemVO.setTitle(activityInfoBO.getTitle());
      activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

      activityItemVO.setGmt_create(activityInfoBO.getGmtInfo().getGmtCreate());
      activityItemVO.setAnnouncer(activityInfoBO.getPubName());
      activityItemVO.setPublisherId(activityInfoBO.getPubId());

      List<TagBO> tagList = activityInfoBO.getTagList();
      List<ActivityTagVO> activityTagVOS=new ArrayList<>();

      for (TagBO tagBO:tagList) {
        ActivityTagVO activityTagVO = new ActivityTagVO();
        activityTagVO.setId(tagBO.getId());
        activityTagVO.setContent(tagBO.getContent());
        activityTagVOS.add(activityTagVO);
      }
      activityItemVO.setImageLink(activityInfoBO.getImageList().get(0).getImageLink());
      activityItemVO.setTagList(activityTagVOS);
      activityItemVOS.add(activityItemVO);
    }
    return activityItemVOS;
  }
}
