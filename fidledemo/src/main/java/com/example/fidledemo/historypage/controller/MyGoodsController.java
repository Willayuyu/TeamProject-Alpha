package com.example.fidledemo.moudle10.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.VO.MyGoodsVO;
import com.example.fidledemo.moudle10.service.MyGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zyf
 */
@RestController
@RequestMapping("/myGoods")
public class MyGoodsController {
    @Autowired
    MyGoodsServiceImpl myGoodsService;

    /**
     * 根据页码返回该页的在售二手物品列表
     * @param pageId
     * @param session
     * @return
     */
    @GetMapping("/listGoodsOnSaleByPageid/{Pageid}")
    @UserLoginToken
    public String listGoodsOnSale(@PathVariable("Pageid") Integer pageId , HttpSession session){
        UserBO user= (UserBO) session.getAttribute("user");
        List<MyGoodsVO> list = myGoodsService.listGoodsOnSale(pageId, user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据页码返回该页的已售二手物品列表
     * @param pageid
     * @param session
     * @return
     */
    @GetMapping("/listGoodsSoldByPageid/{Pageid}")
    @UserLoginToken
    public String listGoodsSold(@PathVariable("Pageid") Integer pageid,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        List<MyGoodsVO> list = myGoodsService.listGoodsSold(pageid,user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据页码返回该页的已购二手物品列表
     * @param pageid
     * @param session
     * @return
     */
    @GetMapping("/listGoodsBuyingByPageid/{Pageid}")
    @UserLoginToken
    public String listGoodsBuying(@PathVariable("Pageid") Integer pageid,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        List<MyGoodsVO> list = myGoodsService.listGoodsBuying(pageid,user.getId());
        return JSON.toJSONString(Result.successResult(list));
    }

    /**
     * 根据卖家id生成二手物品订单
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/generateOrder")
    @UserLoginToken
    public String gennerateOrder(HttpServletRequest request,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Long buyerId = Long.valueOf(request.getParameter("buyerId"));
        myGoodsService.generateOrder(id,buyerId,user.getId());
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 根据二手物品id下架二手物品
     * @param id
     * @return
     */
    @GetMapping("/withdrawGoodsById/{Id}")
    @UserLoginToken
    public String withdrawGoods(@PathVariable("Id") Long id){
        myGoodsService.withdrawGoods(id);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 修改二手物品信息
     * @param request
     * @return
     */
    @PostMapping("/alterGoods")
    @UserLoginToken
    public String alterGoods(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        BigDecimal originPrice = new BigDecimal(request.getParameter("origin_price"));
        String description = request.getParameter("description");
        Long category = Long.valueOf(request.getParameter("category"));
        Integer condition = Integer.valueOf(request.getParameter("condition"));
        String[] images = request.getParameterValues("images_link");
        String[] tags = request.getParameterValues("tags");
        myGoodsService.alertGoods(id,title,price,originPrice,description,category,condition,images,tags);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 评价二手物品买家
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/evaluateBuyer")
    @UserLoginToken
    public String evaluateBuyer(HttpServletRequest request,HttpSession session){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Integer evaluation = Integer.valueOf(request.getParameter("evaluation"));
        String reason = request.getParameter("reason");
        myGoodsService.evaluateBuyer(id,user.getId(),evaluation,reason);
        return JSON.toJSONString(Result.successResult());
    }

    /**
     * 评价二手物品卖家
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/evaluateSeller")
    @UserLoginToken
    public String evaluateSeller(HttpSession session,HttpServletRequest request){
        UserBO user = (UserBO) session.getAttribute("user");
        Long id = Long.valueOf(request.getParameter("id"));
        Integer evaluation = Integer.valueOf(request.getParameter("evaluation"));
        String reason = request.getParameter("reason");
        myGoodsService.evaluateSeller(id,user.getId(),evaluation,reason);
        return JSON.toJSONString(Result.successResult());
    }


}
