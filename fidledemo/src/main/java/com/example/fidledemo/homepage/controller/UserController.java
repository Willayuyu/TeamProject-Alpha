package com.example.fidledemo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.homepage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ZSP
 */
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 根据用户Id获得用户联系名片
     * @param id
     * @return
     */
    @UserLoginToken
    @GetMapping("/homePage/getPublisherBusinessCard/{id}")
    public String getPublisherBusinessCard(@PathVariable("id") Long id){

        try{
            PersonVO personVO = userService.getUserById(id);

            return JSON.toJSONString(Result.successResult(personVO));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }
}
