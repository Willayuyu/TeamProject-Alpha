package com.example.fidledemo.backLogin.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.backHomepage.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WWJ
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (IncorrectCredentialsException ice) {
            return JSON.toJSONString(Result.failureResult(ResultCode.PASSWORD_ERROR));
        } catch (UnknownAccountException uae) {
            return JSON.toJSONString(Result.failureResult(ResultCode.ACCOUNT_ERROR));
        }
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount(account);
        AdminBO adminBo = adminService.getAdminBoByDO(adminDO);
        subject.getSession().setAttribute("admin", adminBo);
        adminDO.setId(adminBo.getId());
        return JSON.toJSONString(Result.successResult(adminDO));
    }

}
