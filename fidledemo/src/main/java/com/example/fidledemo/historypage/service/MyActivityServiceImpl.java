package com.example.fidledemo.historypage.service;


import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.ActivityImageDO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.ActivityTagDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.VO.ActivityTagVO;
import com.example.fidledemo.VO.MyActivityVO;
import com.example.fidledemo.dao.ActivityImageDAO;
import com.example.fidledemo.dao.ActivityInfoDAO;
import com.example.fidledemo.dao.ActivityTagDAO;
import com.example.fidledemo.dao.TagOfActivityDAO;
import com.example.fidledemo.historypage.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@Service
public class MyActivityServiceImpl implements MyActivityService {
    @Autowired
    ActivityInfoDAO activityInfoDAO;
    @Autowired
    TagOfActivityDAO tagOfActivityDAO;
    @Autowired
    ActivityTagDAO activityTagDAO;
    @Autowired
    ActivityImageDAO activityImageDAO;
    @Override
    public List<MyActivityVO> listActivityPublished(Integer pageid, Long pubId) {

        //根据发布者id获取已发布活动信息
        ActivityInfoDO activityInfoDO = new ActivityInfoDO();
        activityInfoDO.setPubId(pubId);
        List<ActivityInfoBO> list = activityInfoDAO.listActivityInfoByDO(activityInfoDO,new TagOfActivityDO());

        //将ActivityInfoBO转化为MyActivityVO
        List<MyActivityVO> list1 = new ArrayList<>();
        for (int i = 0;i < list.size();i++){
            MyActivityVO item = new MyActivityVO();

            //转换图片
            List<ImageBO> imageBO = list.get(i).getImageList();
            String imageLink = imageBO.get(0).getImageLink();
            item.setImageLink(imageLink);

            //转换时间
            Date startTime = list.get(i).getStartTime();
            Date endTime = list.get(i).getEndTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            item.setStartTime(formatter.format(startTime));
            item.setEndTime(formatter.format(endTime));

            //转换标签
            List<TagBO> tagBO = list.get(i).getTagList();
            List<ActivityTagVO> tagVO = new ArrayList<>();
            for (int j = 0;j < tagBO.size();j++){
                ActivityTagVO activityTagVO = new ActivityTagVO();
                activityTagVO.setContent(tagBO.get(j).getContent());
                activityTagVO.setId(tagBO.get(j).getId());
                tagVO.add(activityTagVO);
            }

            //转换信息
            item.setTagList(tagVO);
            item.setTitle(list.get(i).getTitle());
            item.setCategory(list.get(i).getCategory().getCategoryDesignation());
            item.setId(list.get(i).getId());
            list1.add(item);
        }

        //分页
        PageHelper<MyActivityVO> pageHelper = new PageHelper<>(list1,5);
        List<MyActivityVO> activityVOS = pageHelper.getPageByNum(pageid);
        return activityVOS;
    }

    @Override
    public void deleteActivityById(Long id) {
        activityInfoDAO.deleteActivityInfoById(id);
    }

    @Override
    public void alterActivity(Long id, String title, String address, Date startTime, Date endTime, Long category, String description, String[] images, String[] tags) {
        //更新基本信息
        ActivityInfoDO activityInfoDO = new ActivityInfoDO();
        activityInfoDO.setCategory(category);
        activityInfoDO.setTitle(title);
        activityInfoDO.setAddress(address);
        activityInfoDO.setStartTime(startTime);
        activityInfoDO.setEndTime(endTime);
        activityInfoDO.setDescription(description);
        activityInfoDAO.updateActivityInfo(activityInfoDO);
        activityTagDAO.deleteActivityTagById(id);

        //更新标签
        for (int i = 0;i < tags.length;i++){
            TagOfActivityDO item = new TagOfActivityDO();
            item.setContent(tags[i]);
            //检查是否存在改标签，没有则增加
            if(tagOfActivityDAO.checkActivityTag(item.getContent()) == null){
                tagOfActivityDAO.insertTagOfActivity(item);
            }
            Long tagID =tagOfActivityDAO.checkActivityTag(item.getContent());

            //增加标签与任务委托的对应关系
            ActivityTagDO activityTagDO = new ActivityTagDO();
            activityTagDO.setActivityId(id);
            activityTagDO.setTagId(tagID);
            activityTagDAO.insertActivityTag(activityTagDO);
        }

        //更新图片
        for (int i = 0;i < images.length;i++){
            ActivityImageDO item = new ActivityImageDO();
            item.setImageLink(images[i]);
            item.setActivityId(id);
            if (activityImageDAO.getActivityImageByLink(item.getImageLink()) == null){
                activityImageDAO.insertActivityImage(item);
            }
        }
    }
}

