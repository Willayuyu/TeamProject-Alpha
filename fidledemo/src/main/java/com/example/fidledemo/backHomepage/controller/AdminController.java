package com.example.fidledemo.backHomepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.backHomepage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description:
 * @Author: ZSP
 */
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin/login")
    public String login(HttpServletRequest request){
        try {
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            AdminDO adminDo=new AdminDO();
            adminDo.setAccount(account);
            adminDo.setPassword(password);
            AdminBO adminBO = adminService.getAdminBoByDO(adminDo);
            HashMap<String,Object> map=new HashMap<>();
            if (adminBO!=null){
                map.put("id",adminBO.getId());
                map.put("account",adminBO.getAccount());
                return JSON.toJSONString(Result.successResult(map));
            }else {
                return JSON.toJSONString(Result.failureResult(ResultCode.LOGIN_EXCEPTION));

            }
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(Result.failureResult(ResultCode.LOGIN_EXCEPTION));
        }
    }

}
