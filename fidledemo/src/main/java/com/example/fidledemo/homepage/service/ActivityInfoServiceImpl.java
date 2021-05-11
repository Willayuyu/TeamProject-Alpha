package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.ActivityTagVO;
import com.example.fidledemo.VO.ActivityVO;
import com.example.fidledemo.dao.ActivityInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class ActivityInfoServiceImpl implements ActivityInfoService{

    @Autowired
    ActivityInfoDAO activityInfoDAO;

    @Override
    public void insertActivityInfo(ActivityInfoDO infoDO) {

    }

    @Override
    public void updateActivityInfo(ActivityInfoDO infoDO) {

    }

    @Override
    public ActivityVO getActivityInfoById(long id) {
        ActivityInfoBO activityInfoBO = activityInfoDAO.getActivityInfoById(id);
        ActivityVO activityVO = new ActivityVO();

        if (activityInfoBO!=null){
            activityVO.setId(activityInfoBO.getId());
            activityVO.setPubId(activityInfoBO.getPubId());
            activityVO.setTitle(activityInfoBO.getTitle());
            activityVO.setDescription(activityInfoBO.getDescription());
            activityVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

            List<TagBO> tagList = activityInfoBO.getTagList();
            List<ActivityTagVO> activityTagVOS=new ArrayList<>();
            for (TagBO tagBO:tagList) {
                ActivityTagVO activityTagVO = new ActivityTagVO();
                activityTagVO.setId(tagBO.getId());
                activityTagVO.setContent(tagBO.getContent());
                activityTagVOS.add(activityTagVO);
            }

            activityVO.setTagList(activityTagVOS);
            activityVO.setStartTime(activityInfoBO.getStartTime());
            activityVO.setEndTime(activityInfoBO.getEndTime());
            activityVO.setAddress(activityInfoBO.getAddress());

            List<ImageBO> imageList = activityInfoBO.getImageList();
            List<String> picturesLink=new ArrayList<>();
            for (ImageBO imageBO:imageList) {
                String link=imageBO.getImageLink();
                picturesLink.add(link);
            }
            activityVO.setPicturesLink(picturesLink);
        }
        
        return activityVO;
    }

    @Override
    public List<ActivityItemVO> listActivityInfoByDO(ActivityInfoDO infoDO, TagOfActivityDO tag) {
        List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoByDO(infoDO, tag);
        List<ActivityItemVO> activityItemVOS=new ArrayList<>();
        for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
            ActivityItemVO activityItemVO = new ActivityItemVO();
            activityItemVO.setId(activityInfoBO.getId());
            activityItemVO.setTitle(activityInfoBO.getTitle());
            activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());
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
    public List<ActivityItemVO> listActivityInfoBySearch(ActivityInfoDO infoDO, TagOfActivityDO tag) {
        List<ActivityInfoBO> activityInfoBOS = activityInfoDAO.listActivityInfoBySearch(infoDO, tag);
        List<ActivityItemVO> activityItemVOS=new ArrayList<>();
        for (ActivityInfoBO activityInfoBO:activityInfoBOS) {
            ActivityItemVO activityItemVO = new ActivityItemVO();
            activityItemVO.setId(activityInfoBO.getId());
            activityItemVO.setTitle(activityInfoBO.getTitle());
            activityItemVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());
            List<TagBO> tagList = activityInfoBO.getTagList();
            List<ActivityTagVO> activityTagVOS=new ArrayList<>();

            for (TagBO tagBO:tagList) {
                ActivityTagVO activityTagVO = new ActivityTagVO();
                activityTagVO.setId(tagBO.getId());
                activityTagVO.setContent(tagBO.getContent());
                activityTagVOS.add(activityTagVO);
            }
            activityItemVO.setTagList(activityTagVOS);
            activityItemVOS.add(activityItemVO);
        }
        return activityItemVOS;
    }

    @Override
    public void deleteActivityInfoById(Long id) {
    }
}
