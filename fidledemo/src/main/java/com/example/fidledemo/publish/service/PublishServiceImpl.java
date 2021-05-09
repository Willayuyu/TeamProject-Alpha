package com.example.fidledemo.publish.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WWJ
 */
@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    TaskInfoDAO taskInfoDAO;
    @Autowired
    TaskTagDAO taskTagDAO;
    @Autowired
    TagOfTaskDAO tagOfTaskDAO;

    @Autowired
    GoodsInfoDAO goodsInfoDAO;
    @Autowired
    GoodsTagDAO goodsTagDAO;
    @Autowired
    TagOfGoodsDAO tagOfGoodsDAO;
    @Autowired
    GoodsImageDAO goodsImageDAO;

    @Autowired
    ActivityInfoDAO activityInfoDAO;
    @Autowired
    ActivityTagDAO activityTagDAO;
    @Autowired
    TagOfActivityDAO tagOfActivityDAO;
    @Autowired
    ActivityImageDAO activityImageDAO;

    @Override
    public void insertTask(TaskInfoBO taskInfoBO) {
        //将task的详细信息插入task_information
        TaskInformationDO taskInformationDO = taskInfoBO.getTaskInformationDO();
        taskInfoDAO.insertTaskInfo(taskInformationDO);

        //将task与tag的对应关系数组数组插入task_tag
        List<TaskTagDO> taskTagDOList = taskInfoBO.getTaskTagDOList();
        for (TaskTagDO taskTagDO : taskTagDOList) {
            taskTagDAO.insertTaskTag(taskTagDO);
        }
    }

    @Override
    public void insertGoods(GoodsInfoBO goodsInfoBO) {
        //将goods的详细信息插入goods_information
        GoodsInfoDO goodsInfoDO = goodsInfoBO.getGoodsInfoDO();
        goodsInfoDAO.insertGoodsInfo(goodsInfoDO);

        //将goods与tag的对应关系数组数组插入goods_tag
        List<GoodsTagDO> goodsTagDOList = goodsInfoBO.getGoodsTagDOList();
        for (GoodsTagDO goodsTagDO : goodsTagDOList) {
            goodsTagDAO.insertGoodsTag(goodsTagDO);
        }

        //将List<GoodsImageDO>插入goods_image
        List<GoodsImageDO> goodsImageDOList = goodsInfoBO.getGoodsImageDOList();
        for (GoodsImageDO goodsImageDO : goodsImageDOList) {
            goodsImageDAO.insertGoodsImage(goodsImageDO);
        }
    }

    @Override
    public void insertActivity(ActivityInfoBO activityInfoBO) {
        //将activity的详细信息插入activity_information
        ActivityInfoDO activityInfoDO = activityInfoBO.getActivityInfoDO();
        activityInfoDAO.insertActivityInfo(activityInfoDO);

        //将activity与tag的对应关系数组数组插入activity_tag
        List<ActivityTagDO> activityTagDOList = activityInfoBO.getActivityTagDOList();
        for (ActivityTagDO activityTagDO : activityTagDOList) {
            activityTagDAO.insertActivityTag(activityTagDO);
        }

        //将List<ActivityImageDO>插入activity_image
        List<ActivityImageDO> activityImageDOList = activityInfoBO.getActivityImageDOList();
        for (ActivityImageDO activityImageDO : activityImageDOList) {
            activityImageDAO.insertActivityImage(activityImageDO);
        }
    }

    @Override
    public Long checkTaskTag(String content) {
        return tagOfTaskDAO.checkTaskTag(content);
    }

    @Override
    public Long checkGoodsTag(String content) {
        return tagOfGoodsDAO.checkGoodsTag(content);
    }

    @Override
    public Long checkActivityTag(String content) {
        return tagOfActivityDAO.checkActivityTag(content);
    }
}
