package com.example.fidledemo.collection.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.VO.*;
import com.example.fidledemo.collection.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WWJ
 */
@RestController
@RequestMapping("/collection")
@PropertySource("classpath:application.yml")
public class CollectionController {

    @Value("${size}")
    private int size;

    @Autowired
    CollectionService collectionService;

    /**
     * 根据用户id查出他的活动信息收藏页
     *
     * @return
     */
    @GetMapping("/listCollectibleActivityByPageid/{Pageid}")
    @UserLoginToken
    public String listCollectibleActivityByPageid(@PathVariable("Pageid") int pageId, HttpSession session) {
        //获得Session中的用户信息
        UserBO userBO = (UserBO) session.getAttribute("user");
        UserDO userDO = new UserDO();
        userDO.setId(userBO.getId());

        //设置分页信息
        userDO.setLimit(Boolean.TRUE);
        userDO.setBegin((pageId - 1) * size);
        userDO.setSize(size);

        List<ActivityInfoBO> activityInfoBOS = collectionService.listActivityEnshrineByUserDO(userDO);
        List<ActivityVO> activityVOS = new ArrayList<>();
        for (ActivityInfoBO activityInfoBO : activityInfoBOS) {
            ActivityVO activityVO = new ActivityVO();
            activityVO.setId(activityInfoBO.getId());
            activityVO.setPubId(activityInfoBO.getPubId());
            activityVO.setTitle(activityInfoBO.getTitle());
            activityVO.setDescription(activityInfoBO.getDescription());
            activityVO.setCategory(activityInfoBO.getCategory().getCategoryDesignation());

            //将List<TagBo>转化成List<ActivityTagVO>
            List<TagBO> tagList = activityInfoBO.getTagList();
            List<ActivityTagVO> activityTagVOS = new ArrayList<>();
            for (TagBO tagBO : tagList) {
                ActivityTagVO activityTagVO = new ActivityTagVO();
                activityTagVO.setId(tagBO.getId());
                activityTagVO.setContent(tagBO.getContent());
                activityTagVOS.add(activityTagVO);
            }
            activityVO.setTagList(activityTagVOS);

            activityVO.setStartTime(activityInfoBO.getStartTime());
            activityVO.setEndTime(activityInfoBO.getEndTime());
            activityVO.setCollectState(ActivityVO.COLLECT);

            //将List<ImageBO>转化成List<String>
            List<ImageBO> imageList = activityInfoBO.getImageList();
            List<String> picturesLink = new ArrayList<>();
            for (ImageBO imageBO : imageList) {
                String pictureLink = imageBO.getImageLink();
                picturesLink.add(pictureLink);
            }
            activityVO.setPicturesLink(picturesLink);
            activityVOS.add(activityVO);
        }
        return JSON.toJSONString(Result.successResult(activityVOS));
    }

    /**
     * 根据用户id查出他的任务委托收藏页
     *
     * @param pageId
     * @param session
     * @return
     */
    @GetMapping("/listCollectibleTaskByPageid/{Pageid}")
    @UserLoginToken
    public String listCollectibleTaskByPageid(@PathVariable("Pageid") int pageId, HttpSession session) {
        //获得Session中的用户信息
        UserBO userBO = (UserBO) session.getAttribute("user");
        UserDO userDO = new UserDO();
        userDO.setId(userBO.getId());

        //设置分页信息
        userDO.setLimit(Boolean.TRUE);
        userDO.setBegin((pageId - 1) * size);
        userDO.setSize(size);

        List<TaskInfoBO> taskInfoBOS = collectionService.listTaskEnshrineByUserDO(userDO);
        List<TaskVO> taskVOS = new ArrayList<>();
        for (TaskInfoBO taskInfoBO : taskInfoBOS) {
            TaskVO taskVO = new TaskVO();
            taskVO.setId(taskInfoBO.getId());
            taskVO.setPubId(taskInfoBO.getPubId());
            taskVO.setReward(taskInfoBO.getReward());
            taskVO.setTitle(taskInfoBO.getTitle());
            taskVO.setDescription(taskInfoBO.getDescription());
            taskVO.setCategory(taskInfoBO.getCategory().getCategoryDesignation());

            //将List<TagBo>转化成List<TaskTagVO>
            List<TagBO> tagList = taskInfoBO.getTagList();
            List<TaskTagVO> taskTagVOS = new ArrayList<>();
            for (TagBO tagBO : tagList) {
                TaskTagVO taskTagVO = new TaskTagVO();
                taskTagVO.setId(tagBO.getId());
                taskTagVO.setContent(tagBO.getContent());
                taskTagVOS.add(taskTagVO);
            }
            taskVO.setTagList(taskTagVOS);

            taskVO.setCollectState(TaskVO.COLLECT);
            taskVO.setStartTime(taskInfoBO.getStartTime());
            taskVO.setEndTime(taskInfoBO.getEndTime());
            taskVOS.add(taskVO);
        }
        return JSON.toJSONString(Result.successResult(taskVOS));
    }

    /**
     * 根据用户id查出他的二手物品收藏页
     *
     * @param pageId
     * @param session
     * @return
     */
    @GetMapping("/listCollectibleGoodsByPageid/{Pageid}")
    @UserLoginToken
    public String listCollectibleGoodsByPageid(@PathVariable("Pageid") int pageId, HttpSession session) {
        //获得Session中的用户信息
        UserBO userBO = (UserBO) session.getAttribute("user");
        UserDO userDO = new UserDO();
        userDO.setId(userBO.getId());

        //设置分页信息
        userDO.setLimit(Boolean.TRUE);
        userDO.setBegin((pageId - 1) * size);
        userDO.setSize(size);

        List<GoodsInfoBO> goodsInfoBOS = collectionService.listGoodsEnshrineByUserDO(userDO);
        List<GoodsVO> goodsVOS = new ArrayList<>();
        for (GoodsInfoBO goodsInfoBO : goodsInfoBOS) {
            GoodsVO goodsVO = new GoodsVO();
            goodsVO.setId(goodsInfoBO.getId());
            goodsVO.setPubId(goodsInfoBO.getPubId());
            goodsVO.setTitle(goodsInfoBO.getTitle());
            goodsVO.setPrice(goodsInfoBO.getPrice());
            goodsVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
            goodsVO.setDescription(goodsInfoBO.getDescription());
            goodsVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());
            goodsVO.setCondition(goodsInfoBO.getCondition());

            //将List<TagBo>转化成List<GoodsTagVO>
            List<TagBO> tagList = goodsInfoBO.getTagList();
            List<GoodsTagVO> goodsTagVOS = new ArrayList<>();
            for (TagBO tagBO : tagList) {
                GoodsTagVO goodsTagVO = new GoodsTagVO();
                goodsTagVO.setId(tagBO.getId());
                goodsTagVO.setContent(tagBO.getContent());
                goodsTagVOS.add(goodsTagVO);
            }
            goodsVO.setTagList(goodsTagVOS);

            //将List<ImageBO>转化成List<String>
            List<ImageBO> imageList = goodsInfoBO.getImageList();
            List<String> picturesLink = new ArrayList<>();
            for (ImageBO imageBO : imageList) {
                String pictureLink = imageBO.getImageLink();
                picturesLink.add(pictureLink);
            }
            goodsVO.setPicturesLink(picturesLink);
            goodsVO.setCollectState(GoodsVO.COLLECT);
            goodsVOS.add(goodsVO);
        }
        return JSON.toJSONString(Result.successResult(goodsVOS));
    }
}
