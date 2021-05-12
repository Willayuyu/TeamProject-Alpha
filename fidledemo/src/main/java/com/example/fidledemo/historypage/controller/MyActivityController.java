package com.example.fidledemo.moudle10.controller;


import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.MyActivityVO;
import com.example.fidledemo.moudle10.service.MyActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@RestController
@RequestMapping("/myActivity")
public class MyActivityController {

    @Autowired
    MyActivityServiceImpl myActivityService;

    /**
     * 根据页码返回该页的已发布的活动
     * @param pageid
     * @param session
     * @return
     */
    @GetMapping("/listActivityPublishedByPageid/{Pageid}")
    @UserLoginToken
    public String listActivityPublished(@PathVariable("Pageid") Integer pageid, HttpSession session){
        UserBO user= (UserBO) session.getAttribute("user");
        List<MyActivityVO> list = myActivityService.listActivityPublished(pageid,user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据活动id删除活动
     * @param id
     * @return
     */
    @GetMapping("/deleteActivityById/{Id}")
    @UserLoginToken
    public String deleteActivity(@PathVariable("Id") Long id){
        myActivityService.deleteActivityById(id);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 修改活动信息
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/alterActivity")
    @UserLoginToken
    public String alterActivity(HttpSession session, HttpServletRequest request){
        UserBO userBO = (UserBO) session.getAttribute("user");
        UserBO user= (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String address = request.getParameter("address");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null,endTime = null;
        try {
            startTime = format.parse(request.getParameter("start_time"));
            endTime = format.parse(request.getParameter("end_time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long category = Long.valueOf(request.getParameter("category"));
        String description = request.getParameter("description");
        String[] images = request.getParameterValues("images");
        String[] tags = request.getParameterValues("tags");
        myActivityService.alterActivity(id,title,address,startTime,endTime,category,description,images,tags);
        return JSON.toJSONString(Result.successResult());
    }

}
