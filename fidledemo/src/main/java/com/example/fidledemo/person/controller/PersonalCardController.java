package com.example.fidledemo.person.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.GoodsEvaluationVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.VO.TaskEvaluationVO;
import com.example.fidledemo.person.service.PersonalCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zyf
 */
@RestController
@RequestMapping("/personalCard")
public class PersonalCardController {
    @Autowired
    PersonalCardServiceImpl personalCarService;

    /**
     * 返回当前用户的个人名片
     * @param session
     * @return
     */
    @GetMapping("/getCard")
    @UserLoginToken
    public String getCard(HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        PersonVO personVO = personalCarService.getCard(user.getId());
        return JSON.toJSONString(Result.successResult(personVO));
    }

    /**
     * 根据用户id返回相关的二手物品评价
     * @param request
     * @return
     */
    @PostMapping("/getGoodsEvaluationByLike")
    @UserLoginToken
    public String getGoodsEvaluation(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        Integer isLike;
        if (request.getParameter("isLike") == null){
            isLike = 0;
        }else {
            isLike = Integer.valueOf(request.getParameter("isLike"));
        }
        List<GoodsEvaluationVO> list = personalCarService.getGoodsEvaluationByLike(id,isLike);
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据用户id返回相关的任务委托评价
     * @param request
     * @return
     */
    @PostMapping("/getTaskEvaluationByLike")
    @UserLoginToken
    public String getTaskEvaluation(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        Integer isLike;
        if (request.getParameter("isLike") == null){
            isLike = 0;
        }else {
            isLike = Integer.valueOf(request.getParameter("isLike"));
        }
        List<TaskEvaluationVO> list = personalCarService.getTaskEvaluationByLike(id,isLike);
        return JSON.toJSONString(Result.successResult(list));
    }
}