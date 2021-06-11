package com.example.fidledemo.historypage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.MyActivityVO;
import com.example.fidledemo.historypage.service.MyActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
        String imageString = request.getParameter("images");
        String tagsString = request.getParameter("tags");
        String[] images =imageString.split(",");
        String[] tags = tagsString.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        if (images != null) {
            for (int i = 0; i < images.length; i++) {

                arrayList.add(images[i]);
            }
            Collections.reverse(arrayList);
            for (int i = 0; i < images.length; i++) {
                images[i] = arrayList.get(i);
                System.out.println(images[i]);
            }
            System.out.println();
        }
        System.out.print("tags:");
        arrayList.clear();
        if (tags != null) {
            for (int i = 0; i < tags.length; i++) {
                arrayList.add(tags[i]);
            }
            Collections.reverse(arrayList);
            for (int i = 0; i < tags.length; i++) {
                tags[i] = arrayList.get(i);
                System.out.println(tags[i]);
            }
        }
        myActivityService.alterActivity(id,title,address,startTime,endTime,category,description,images,tags);
        return JSON.toJSONString(Result.successResult());
    }

}

