package com.example.fidledemo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.Result;
import com.example.fidledemo.BO.ResultCode;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.BO.UserLoginToken;
import com.example.fidledemo.DO.GoodsEnshrineDO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsCategoryVO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.VO.GoodsVO;
import com.example.fidledemo.dao.GoodsCategoryDAO;
import com.example.fidledemo.homepage.service.GoodsCategoryServiceImpl;
import com.example.fidledemo.homepage.service.GoodsEnshrineServiceImpl;
import com.example.fidledemo.homepage.service.GoodsInfoServiceImpl;
import com.example.fidledemo.homepage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 二手物品模块
 */
@RestController
public class GoodsController {

    @Autowired
    GoodsInfoServiceImpl goodsInfoService;

    @Autowired
    GoodsEnshrineServiceImpl goodsEnshrineService;

    @Autowired
    GoodsCategoryServiceImpl goodsCategoryService;

    @Autowired
    GoodsCategoryDAO goodsCategoryDAO;

    /**
     * 根据多选框筛选条件获得二手列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/goods/listGoods")
    public String getListGoods(HttpServletRequest request){
        try{
            GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
            TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            int condition=Integer.parseInt(request.getParameter("condition"));
            int pageid=Integer.parseInt(request.getParameter("pageid"));

            goodsInfoDO.setLimit(Boolean.TRUE);
            goodsInfoDO.setBegin((pageid-1)*10);
            goodsInfoDO.setSize(10);
            goodsInfoDO.setDistinct(Boolean.TRUE);
            goodsInfoDO.setCategory(categoryId);
            goodsInfoDO.setCondition(condition);
            /**
             * 1:在售
             */
            goodsInfoDO.setSold(1);
            goodsInfoDO.setCreateTimeEnd(new Date());
            goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));

            List<GoodsItemVO> goodsItemVOS = goodsInfoService.listGoodsInfoByDO(goodsInfoDO, tagOfGoodsDO);

            //判断是否被该用户收藏
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
            goodsEnshrineDO.setUserId(userId);
            for (GoodsItemVO goodsItemVO:goodsItemVOS) {
                goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
                if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
                    goodsItemVO.setCollectState(1);
                }else {
                    goodsItemVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(goodsItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据多选框筛选条件及关键词获得二手列表
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/goods/listGoodsByKeyword")
    public String getListGoodsByKeyword(HttpServletRequest request){

        try{
            GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
            TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();

            int days=Integer.parseInt(request.getParameter("days"));
            Long categoryId=Long.parseLong(request.getParameter("categoryId"));
            int condition=Integer.parseInt(request.getParameter("condition"));
            String keyWord=request.getParameter("keyWord");
            int pageid=Integer.parseInt(request.getParameter("pageid"));

            goodsInfoDO.setLimit(Boolean.TRUE);
            goodsInfoDO.setBegin((pageid-1)*10);
            goodsInfoDO.setSize(10);
            goodsInfoDO.setDistinct(Boolean.TRUE);
            goodsInfoDO.setTitle(keyWord);
            goodsInfoDO.setTitleLike(Boolean.TRUE);
            goodsInfoDO.setDescription(keyWord);
            goodsInfoDO.setDescriptionLike(Boolean.TRUE);
            goodsInfoDO.setCategory(categoryId);
            goodsInfoDO.setCondition(condition);
            goodsInfoDO.setSold(1);//1在售
            goodsInfoDO.setCreateTimeEnd(new Date());
            goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));

            tagOfGoodsDO.setContent(keyWord);
            tagOfGoodsDO.setContentLike(Boolean.TRUE);

            List<GoodsItemVO> goodsItemVOS = goodsInfoService.listGoodsInfoBySearch(goodsInfoDO, tagOfGoodsDO);
            //判断是否被该用户收藏
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
            goodsEnshrineDO.setUserId(userId);
            for (GoodsItemVO goodsItemVO:goodsItemVOS) {
                goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
                if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
                    goodsItemVO.setCollectState(1);
                }else {
                    goodsItemVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(goodsItemVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 获得二手类别
     * @return
     */
    @UserLoginToken
    @GetMapping("/goods/listGoodsCategory")
    public String getListGoodsCategory(){
        try{
            List<GoodsCategoryVO> categoryVOS = goodsCategoryService.listAllGoodsCategory();
            return JSON.toJSONString(Result.successResult(categoryVOS));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

    /**
     * 根据二手id和用户id 收藏二手物品
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/goods/collectGoods/{id}")
    public String collectGoods(@PathVariable("id") Long id,HttpServletRequest request){
        try{
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(3);
            GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
            goodsEnshrineDO.setUserId(userId);
            goodsEnshrineDO.setGoodsId(id);
            goodsEnshrineService.insertGoodsEnshrine(goodsEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }

    /**
     * 根据二手id和用户id 取消收藏二手物品
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/goods/cancelCollectGoods/{id}")
    public String cancelCollectGoods(@PathVariable("id") Long id,HttpServletRequest request){
        try{
            UserBO user = (UserBO) request.getSession().getAttribute("user");
            Long userId = user.getId();
            //userId= Long.valueOf(3);
            GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
            goodsEnshrineDO.setUserId(userId);
            goodsEnshrineDO.setGoodsId(id);
            goodsEnshrineService.deleteGoodsEnshrineByDO(goodsEnshrineDO);
            return JSON.toJSONString(Result.successResult());
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.SESSION_EXPIRED));
        }
    }

    /**
     * 根据ID返回二手物品详情
     * @param id
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping("/goods/getGoodsDetailById/{id}")
    public String getGoodsDetailById(@PathVariable("id") Long id,HttpServletRequest request){
        try {
            GoodsVO goodsVO = goodsInfoService.getGoodsInfoById(id);
            if (goodsVO!=null){
                UserBO user = (UserBO) request.getSession().getAttribute("user");
                Long userId = user.getId();
                //userId= Long.valueOf(2);
                GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
                goodsEnshrineDO.setUserId(userId);
                goodsEnshrineDO.setGoodsId(goodsVO.getId());
                if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
                    goodsVO.setCollectState(1);
                }else {
                    goodsVO.setCollectState(0);
                }
            }
            return JSON.toJSONString(Result.successResult(goodsVO));
        }catch (Exception e){
            return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
        }
    }

}
