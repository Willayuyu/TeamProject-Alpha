package com.example.fidledemo.publish.service;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author WWJ
 */
@Service
@PropertySource("classpath:application.yml")
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

    @Value("${imageHost.path}")
    String path;

    @Override
    public void insertTask(TaskInfoBO taskInfoBO) {
        //将task的详细信息插入task_information
        TaskInformationDO taskInformationDO = taskInfoBO.getTaskInformationDO();
        taskInfoDAO.insertTaskInfo(taskInformationDO);

        //将task与tag的对应关系数组数组插入task_tag
        List<TaskTagDO> taskTagDOList = taskInfoBO.getTaskTagDOList();
        for (TaskTagDO taskTagDO : taskTagDOList) {
            taskTagDO.setTaskId(taskInformationDO.getId());
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
            goodsTagDO.setGoodsId(goodsInfoDO.getId());
            goodsTagDAO.insertGoodsTag(goodsTagDO);
        }

        //用List<GoodsImageDO>更新goods_image
        List<GoodsImageDO> goodsImageDOList = goodsInfoBO.getGoodsImageDOList();
        for (GoodsImageDO goodsImageDO : goodsImageDOList) {
            //根据link查出对应的id
            goodsImageDO.setId(goodsImageDAO.getGoodsImageByLink(goodsImageDO.getImageLink()));
            goodsImageDO.setGoodsId(goodsInfoDO.getId());
            goodsImageDAO.updateGoodsImage(goodsImageDO);
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
            activityTagDO.setActivityId(activityInfoDO.getId());
            activityTagDAO.insertActivityTag(activityTagDO);
        }

        //用List<ActivityImageDO>更新activity_image
        List<ActivityImageDO> activityImageDOList = activityInfoBO.getActivityImageDOList();
        for (ActivityImageDO activityImageDO : activityImageDOList) {
            //根据link查出对应的id
            activityImageDO.setId(activityImageDAO.getActivityImageByLink(activityImageDO.getImageLink()));
            activityImageDO.setActivityId(activityInfoDO.getId());
            activityImageDAO.updateActivityImage(activityImageDO);
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

    @Override
    public Long insertImage(ImageBO imageBO) {
        if (imageBO.getType() == 3) {
            ActivityImageDO activityImageDO = new ActivityImageDO();
            activityImageDO.setImageLink(imageBO.getImageLink());
            activityImageDAO.insertActivityImage(activityImageDO);
            return activityImageDO.getId();
        } else {
            GoodsImageDO goodsImageDO = new GoodsImageDO();
            goodsImageDO.setImageLink(imageBO.getImageLink());
            goodsImageDAO.insertGoodsImage(goodsImageDO);
            return goodsImageDO.getId();
        }
    }

    @Override
    public void deleteImage(ImageBO imageBO) {
        if (imageBO.getType() == 3) {
            deleteFile(activityImageDAO.getActivityImageById(imageBO.getId()));
            activityImageDAO.deleteActivityImage(imageBO.getId());
        } else {
            deleteFile(goodsImageDAO.getGoodsImageById(imageBO.getId()));
            goodsImageDAO.deleteGoodsImage(imageBO.getId());
        }
    }

    @Override
    public Long getImageIdByLink(ImageBO imageBO) {
        if (imageBO.getType().equals(ImageBO.GOODS)){
            return goodsImageDAO.getGoodsImageByLink(imageBO.getImageLink());
        }else{
            return activityImageDAO.getActivityImageByLink(imageBO.getImageLink());
        }
    }

    public void deleteFile(String url){
        String[] split = url.split("/");
        String fileName=split[4];
        System.out.println(path+fileName);
        File file=new File(path+fileName);
        if(file.exists()){
            file.delete();
            System.out.println("文件删除成功");
        }else{
            System.out.println("文件为空");
        }
    }
}
