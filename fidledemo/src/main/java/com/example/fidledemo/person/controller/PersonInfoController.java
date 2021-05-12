package com.example.fidledemo.moudle10.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.moudle10.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zyf
 */
@RestController
@RequestMapping("/personalPage")
@PropertySource("classpath:application.yml")
public class PersonInfoController {
    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 根据用户id返回个人主页信息
     * @param id
     * @return
     */
    @GetMapping("/getHomePageById/{id}")
    @UserLoginToken
    public String getHomePageById(@PathVariable("id") Long id){
        PersonVO  personVO = userServiceImpl.getInfo(id);
        return JSON.toJSONString(Result.successResult(personVO));
    }

    /**
     * 修改个人信息
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/alterInformation")
    @UserLoginToken
    public String alterInformation(HttpServletRequest request, HttpSession session) {
        UserBO user= (UserBO) session.getAttribute("user");
        String username = request.getParameter("username");
        String qq = request.getParameter("qq");
        String tel = request.getParameter("tel");
        userServiceImpl.alterInfo(username,qq,tel,user.getId());
        return JSON.toJSONString(Result.successResult());
    }
}
