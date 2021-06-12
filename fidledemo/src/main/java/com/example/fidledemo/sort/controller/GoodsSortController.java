package com.example.fidledemo.sort.controller;

import com.alibaba.fastjson.JSON;
import com.example.fidledemo.BO.*;
import com.example.fidledemo.DO.GoodsEnshrineDO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.homepage.service.GoodsEnshrineServiceImpl;
import com.example.fidledemo.homepage.service.GoodsInfoServiceImpl;
import com.example.fidledemo.homepage.utils.DateUtils;
import com.example.fidledemo.homepage.utils.PageHelper;
import com.example.fidledemo.sort.service.GoodsSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 二手排序接口
 * @author 11313
 */
@RestController
public class GoodsSortController
{
  @Value("${size}")
  private int size;

  @Autowired
  GoodsSortService goodsSortService;

  @Autowired
  GoodsEnshrineServiceImpl goodsEnshrineService;

  /**
   * 根据价格降序排序二手列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/goods/sortGoods/priceAsc")
  public String sortListGoodsPA(HttpServletRequest request){
    try{
      GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
      TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int condition=Integer.parseInt(request.getParameter("condition"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));

      goodsInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        goodsInfoDO.setCategory(categoryId);
      }

      if(condition!=0){
        goodsInfoDO.setCondition(condition);
      }
      goodsInfoDO.setSold(GoodsInfoBO.SELLING);
      if(days!=0){
        goodsInfoDO.setCreateTimeEnd(new Date());
        goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }
      List<GoodsItemVO> goodsItemVOS = goodsSortService.listGoodsInfoBySearchOrderByPriceASC(goodsInfoDO, tagOfGoodsDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
      goodsEnshrineDO.setUserId(userId);
      for (GoodsItemVO goodsItemVO:goodsItemVOS) {
        goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
        if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
          goodsItemVO.setCollectState(GoodsItemVO.COLLECT);
        }else {
          goodsItemVO.setCollectState(GoodsItemVO.DISCOLLECT);
        }
      }

      PageHelper<GoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
      List<GoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);


      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据价格降序排序二手列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/goods/sortGoods/priceDesc")
  public String sortListGoodsPD(HttpServletRequest request){
    try{
      GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
      TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int condition=Integer.parseInt(request.getParameter("condition"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));

      goodsInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        goodsInfoDO.setCategory(categoryId);
      }

      if(condition!=0){
        goodsInfoDO.setCondition(condition);
      }
      goodsInfoDO.setSold(GoodsInfoBO.SELLING);
      if(days!=0){
        goodsInfoDO.setCreateTimeEnd(new Date());
        goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }
      List<GoodsItemVO> goodsItemVOS = goodsSortService.listGoodsInfoBySearchOrderByPriceDesc(goodsInfoDO, tagOfGoodsDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
      goodsEnshrineDO.setUserId(userId);
      for (GoodsItemVO goodsItemVO:goodsItemVOS) {
        goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
        if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
          goodsItemVO.setCollectState(GoodsItemVO.COLLECT);
        }else {
          goodsItemVO.setCollectState(GoodsItemVO.DISCOLLECT);
        }
      }

      PageHelper<GoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
      List<GoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);


      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据价格新旧程度升序排序二手列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/goods/sortGoods/conditionAsc")
  public String sortListGoodsCA(HttpServletRequest request){
    try{
      GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
      TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int condition=Integer.parseInt(request.getParameter("condition"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));

      goodsInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        goodsInfoDO.setCategory(categoryId);
      }

      if(condition!=0){
        goodsInfoDO.setCondition(condition);
      }
      goodsInfoDO.setSold(GoodsInfoBO.SELLING);
      if(days!=0){
        goodsInfoDO.setCreateTimeEnd(new Date());
        goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }
      List<GoodsItemVO> goodsItemVOS = goodsSortService.listGoodsInfoBySearchOrderByConditionASC(goodsInfoDO, tagOfGoodsDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
      goodsEnshrineDO.setUserId(userId);
      for (GoodsItemVO goodsItemVO:goodsItemVOS) {
        goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
        if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
          goodsItemVO.setCollectState(GoodsItemVO.COLLECT);
        }else {
          goodsItemVO.setCollectState(GoodsItemVO.DISCOLLECT);
        }
      }

      PageHelper<GoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
      List<GoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);


      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }

  /**
   * 根据新旧程度降序排序二手列表
   * @param request
   * @return
   */
  @UserLoginToken
  @PostMapping("/goods/sortGoods/conditionDesc")
  public String sortListGoodsCD(HttpServletRequest request){
    try{
      GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
      TagOfGoodsDO tagOfGoodsDO = new TagOfGoodsDO();
      int days=Integer.parseInt(request.getParameter("days"));
      Long categoryId=Long.parseLong(request.getParameter("categoryId"));
      int condition=Integer.parseInt(request.getParameter("condition"));
      int pageid=Integer.parseInt(request.getParameter("pageid"));

      goodsInfoDO.setDistinct(Boolean.TRUE);

      if(categoryId!=0){
        goodsInfoDO.setCategory(categoryId);
      }

      if(condition!=0){
        goodsInfoDO.setCondition(condition);
      }
      goodsInfoDO.setSold(GoodsInfoBO.SELLING);
      if(days!=0){
        goodsInfoDO.setCreateTimeEnd(new Date());
        goodsInfoDO.setCreateTimeBegin(DateUtils.addAndSubtractDaysByCalendar(new Date(),-days));
      }
      List<GoodsItemVO> goodsItemVOS = goodsSortService.listGoodsInfoBySearchOrderByConditionDesc(goodsInfoDO, tagOfGoodsDO);

      //判断是否被该用户收藏
      UserBO user = (UserBO) request.getSession().getAttribute("user");
      Long userId = user.getId();
      GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
      goodsEnshrineDO.setUserId(userId);
      for (GoodsItemVO goodsItemVO:goodsItemVOS) {
        goodsEnshrineDO.setGoodsId(goodsItemVO.getId());
        if (goodsEnshrineService.getGoodsEnshrine(goodsEnshrineDO)!=null){
          goodsItemVO.setCollectState(GoodsItemVO.COLLECT);
        }else {
          goodsItemVO.setCollectState(GoodsItemVO.DISCOLLECT);
        }
      }

      PageHelper<GoodsItemVO> pageHelper = new PageHelper<>(goodsItemVOS,size);
      List<GoodsItemVO> itemVOList = pageHelper.getPageByNum(pageid);


      return JSON.toJSONString(Result.successResult(itemVOList));
    }catch (Exception e){
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.RESOURCE_EMPTY));
    }
  }


}
