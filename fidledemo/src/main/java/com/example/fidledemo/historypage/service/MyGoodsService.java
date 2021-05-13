package com.example.fidledemo.historypage.service;

import com.example.fidledemo.VO.MyGoodsVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zyf
 */
public interface MyGoodsService {

    /**
     * 查找在售二手物品列表
     * @param pageid
     * @param sellerId
     * @return
     */
    List<MyGoodsVO> listGoodsOnSale(Integer pageid, Long sellerId);

    /**
     * 查找已售二手物品列表
     * @param pageid
     * @param sellerId
     * @return
     */
    List<MyGoodsVO> listGoodsSold(Integer pageid,Long sellerId);

    /**
     * 查找已买二手物品列表
     * @param pageid
     * @param id
     * @return
     */
    List<MyGoodsVO> listGoodsBuying(Integer pageid,Long id);

    /**
     * 根据购买者id生成二手物品订单
     * @param id
     * @param buyerId
     * @param sellerId
     */
    void generateOrder(Long id,Long buyerId,Long sellerId);

    /**
     * 根据二手物品id下架商品
     * @param id
     */
    void withdrawGoods(Long id);

    /**
     * 修改二手物品信息
     * @param id
     * @param title
     * @param price
     * @param originPrice
     * @param description
     * @param category
     * @param condition
     * @param imagesLink
     * @param tags
     */
    void alertGoods(Long id, String title, BigDecimal price, BigDecimal originPrice, String description, Long category, Integer condition, String[] imagesLink, String[] tags);

    /**
     * 评价买家
     * @param id
     * @param valuatorId
     * @param evaluation
     * @param reason
     */
    void evaluateBuyer(Long id,Long valuatorId,Integer evaluation,String reason);

    /**
     * 评价卖家
     * @param id
     * @param valuatorId
     * @param evaluation
     * @param reason
     */
    void evaluateSeller(Long id,Long valuatorId,Integer evaluation,String reason);
}
