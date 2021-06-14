package com.example.fidledemo.historypage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.MyTaskVO;
import com.example.fidledemo.historypage.service.MyTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Dell
 */
@RestController
@RequestMapping("/myTask")
public class MyTaskController {
    @Autowired
    MyTaskServiceImpl myTaskService;

    /**
     * 根据页码查询已发布的任务委托列表
     * @param pageid
     * @param session
     * @return
     */
    @GetMapping("/listTaskPublishedByPageid/{Pageid}")
    @UserLoginToken
    public String listTaskPublished(@PathVariable("Pageid") Integer pageid, HttpSession session){
        UserBO user= (UserBO) session.getAttribute("user");
        List<MyTaskVO> list = myTaskService.listTaskPublished(pageid,user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据页码查询已接受的任务委托列表
     * @param pageid
     * @param session
     * @return
     */
    @GetMapping("/listTaskAcceptedByPageid/{Pageid}")
    @UserLoginToken
    public String listTaskAccepted(@PathVariable("Pageid") Integer pageid,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        List<MyTaskVO> list = myTaskService.listTaskAccepted(pageid,user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 进行任务
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/conductTask")
    @UserLoginToken
    public String conductTask(HttpServletRequest request,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Long accId = Long.valueOf(request.getParameter("acc_id"));
        myTaskService.conductTask(id,accId,user.getId());
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 更具任务委托id删除任务委托
     * @param id
     * @return
     */
    @GetMapping("/deleteTaskById/{Id}")
    @UserLoginToken
    public String deleteTask(@PathVariable("Id") Long id){
        myTaskService.deleteTaskById(id);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 根据任务委托id完成任务
     * @param id
     * @return
     */
    @GetMapping("/finishTaskById/{Id}")
    @UserLoginToken
    public String finishTask(@PathVariable("Id") Long id,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        myTaskService.finishTaskById(id,user.getId());
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 根据任务委托取消任务
     * @param id
     * @return
     */
    @GetMapping("cancelTaskById/{Id}")
    @UserLoginToken
    public String cancelTask(@PathVariable("Id") Long id){
        myTaskService.cancelTaskById(id);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 修改任务委托信息
     * @param request
     * @return
     */
    @PostMapping("/alterTask")
    @UserLoginToken
    public String alterTask(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        BigDecimal reward = new BigDecimal(request.getParameter("reward"));
        String description = request.getParameter("description");
        Long category = Long.valueOf(request.getParameter("category"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null,endTime = null;
        try {
            startTime = format.parse(request.getParameter("start_time"));
            endTime = format.parse(request.getParameter("end_time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String tagsString = request.getParameter("tags");
        String[] tags = tagsString.split(",");

        ArrayList<String> arrayList = new ArrayList<>();
        if (tags != null) {
            for (int i = 0; i < tags.length; i++) {
                arrayList.add(tags[i]);
            }
            Collections.reverse(arrayList);
            for (int i = 0; i < tags.length; i++) {
                tags[i] = arrayList.get(i);
                System.out.println(tags[i]);
            }
            System.out.println();
        }
        myTaskService.alterTask(id,title,reward,description,category,startTime,endTime,tags);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 评价任务委托发布方
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/evaluatePublisher")
    @UserLoginToken
    public String evaluatePublisher(HttpServletRequest request,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Integer evaluation = Integer.valueOf(request.getParameter("evaluation"));
        String reason = request.getParameter("reason");
        myTaskService.evaluatePublisher(id,user.getId(),evaluation,reason);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 评价任务委托接收方
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/evaluateAccepter")
    @UserLoginToken
    public String evaluateAccepter(HttpSession session,HttpServletRequest request){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Integer evaluation = Integer.valueOf(request.getParameter("evaluation"));
        String reason = request.getParameter("reason");
        myTaskService.evaluateAccepter(id,user.getId(),evaluation,reason);
        return JSON.toJSONString(Result.successResult());
    }

}
