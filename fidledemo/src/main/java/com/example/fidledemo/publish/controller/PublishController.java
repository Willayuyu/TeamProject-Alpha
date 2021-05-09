package com.example.fidledemo.publish.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.dao.TagOfActivityDAO;
import com.example.fidledemo.dao.TagOfGoodsDAO;
import com.example.fidledemo.dao.TagOfTaskDAO;
import com.example.fidledemo.publish.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WWJ
 */
@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    PublishService publishService;
    @Autowired
    TagOfTaskDAO tagOfTaskDAO;
    @Autowired
    TagOfActivityDAO tagOfActivityDAO;
    @Autowired
    TagOfGoodsDAO tagOfGoodsDAO;

    @PostMapping("/task")
    @UserLoginToken
    public String insertTask(HttpServletRequest request, HttpSession session) throws ParseException {
        TaskInfoBO taskInfoBO = new TaskInfoBO();

        //获得发布者id
        UserDO userDO = (UserDO) session.getAttribute("user");
        taskInfoBO.setPubId(userDO.getId());

        taskInfoBO.setTitle(request.getParameter("title"));
        taskInfoBO.setReward(new BigDecimal(request.getParameter("reward")));

        //String转Datetime
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        taskInfoBO.setStartTime(formatter.parse(request.getParameter("start_time")));
        taskInfoBO.setEndTime(formatter.parse(request.getParameter("end_time")));

        taskInfoBO.setDescription(request.getParameter("description"));

        //String转Long放入CategoryBO
        CategoryBO categoryBO = new CategoryBO();
        categoryBO.setCategoryId(Long.parseLong(request.getParameter("category")));
        taskInfoBO.setCategory(categoryBO);

        //将String[]转为List<TagBO>
        String[] tags = request.getParameterValues("tags");
        List<TagBO> tagBOS = new ArrayList<>();
        for (String tag : tags) {
            TagBO tagBO = new TagBO();
            //标签不存在
            if (tagOfTaskDAO.checkTaskTag(tag) == null) {
                TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
                tagOfTaskDO.setContent(tag);
                tagOfTaskDAO.insertTagOfTask(tagOfTaskDO);
                tagBO.setId(tagOfTaskDO.getId());
                tagBO.setContent(tag);
                tagBO.setType(2);
            } else {
                tagBO.setId(tagOfTaskDAO.checkTaskTag(tag));
                tagBO.setContent(tag);
                tagBO.setType(2);
            }
            tagBOS.add(tagBO);
        }
        taskInfoBO.setTagList(tagBOS);
        publishService.insertTask(taskInfoBO);
        return JSON.toJSONString(Result.successResult());
    }

    @PostMapping("/goods")
    @UserLoginToken
    public String insertGoods(HttpServletRequest request, HttpSession session) {
        GoodsInfoBO goodsInfoBO = new GoodsInfoBO();

        //获得发布者id
        UserDO userDO = (UserDO) session.getAttribute("user");
        goodsInfoBO.setPubId(userDO.getId());

        goodsInfoBO.setTitle(request.getParameter("title"));
        goodsInfoBO.setPrice(new BigDecimal(request.getParameter("price")));
        goodsInfoBO.setOriginalPrice(new BigDecimal(request.getParameter("original_price")));
        goodsInfoBO.setDescription(request.getParameter("description"));
        goodsInfoBO.setCondition(Integer.parseInt(request.getParameter("condition")));

        //String转Long放入CategoryBO
        CategoryBO categoryBO = new CategoryBO();
        categoryBO.setCategoryId(Long.parseLong(request.getParameter("category")));
        goodsInfoBO.setCategory(categoryBO);

        //将String[]转为List<TagBO>
        String[] tags = request.getParameterValues("tags");
        List<TagBO> tagBOS = new ArrayList<>();
        for (String tag : tags) {
            TagBO tagBO = new TagBO();
            //标签不存在
            if (tagOfGoodsDAO.checkGoodsTag(tag) == null) {
                TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
                tagOfGoodsDO.setContent(tag);
                tagOfGoodsDAO.insertTagOfGoods(tagOfGoodsDO);
                tagBO.setId(tagOfGoodsDO.getId());
                tagBO.setContent(tag);
                tagBO.setType(1);
            } else {
                tagBO.setId(tagOfGoodsDAO.checkGoodsTag(tag));
                tagBO.setContent(tag);
                tagBO.setType(1);
            }
            tagBOS.add(tagBO);
        }
        goodsInfoBO.setTagList(tagBOS);
        //image_link////////////////////////////

        publishService.insertGoods(goodsInfoBO);
        return JSON.toJSONString(Result.successResult());
    }

    @PostMapping("/activity")
    @UserLoginToken
    public String insertActivity(HttpServletRequest request,HttpSession session) throws ParseException {
        ActivityInfoBO activityInfoBO = new ActivityInfoBO();

        //获得发布者id
        UserDO userDO = (UserDO) session.getAttribute("user");
        activityInfoBO.setPubId(userDO.getId());

        activityInfoBO.setTitle(request.getParameter("title"));
        activityInfoBO.setAddress(request.getParameter("address"));

        //String转Datetime
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        activityInfoBO.setStartTime(formatter.parse(request.getParameter("start_time")));
        activityInfoBO.setEndTime(formatter.parse(request.getParameter("end_time")));

        activityInfoBO.setDescription(request.getParameter("description"));

        //image_link////////////////////////////

        //String转Long放入CategoryBO
        CategoryBO categoryBO = new CategoryBO();
        categoryBO.setCategoryId(Long.parseLong(request.getParameter("category")));
        activityInfoBO.setCategory(categoryBO);

        //将String[]转为List<TagBO>
        String[] tags = request.getParameterValues("tags");
        List<TagBO> tagBOS = new ArrayList<>();
        for (String tag : tags) {
            TagBO tagBO = new TagBO();
            //标签不存在
            if (tagOfActivityDAO.checkActivityTag(tag) == null) {
                TagOfActivityDO tagOfActivityDO = new TagOfActivityDO();
                tagOfActivityDO.setContent(tag);
                this.tagOfActivityDAO.insertTagOfActivity(tagOfActivityDO);
                tagBO.setId(tagOfActivityDO.getId());
                tagBO.setContent(tag);
                tagBO.setType(3);
            } else {
                tagBO.setId(tagOfActivityDAO.checkActivityTag(tag));
                tagBO.setContent(tag);
                tagBO.setType(3);
            }
            tagBOS.add(tagBO);
        }
        activityInfoBO.setTagList(tagBOS);

        publishService.insertActivity(activityInfoBO);
        return JSON.toJSONString(Result.successResult());
    }

}
