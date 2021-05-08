package com.example.fidledemo.publish.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskTagDO;
import com.example.fidledemo.DO.UserDO;
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
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/task")
    public String insertTask(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {
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

        String[] tags = request.getParameterValues("tags");
        List<TagBO> tagBOS = new ArrayList<>();
        for (String tag : tags) {
            TagBO tagBO = new TagBO();
            //标签不存在
            if(tagOfTaskDAO.checkTaskTag(tag)==null){
                TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
                tagOfTaskDO.setContent(tag);
                tagOfTaskDAO.insertTagOfTask(tagOfTaskDO);
                tagBO.setId(tagOfTaskDO.getId());
                tagBO.setContent(tag);
                tagBO.setType(2);
            }else{
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
}
