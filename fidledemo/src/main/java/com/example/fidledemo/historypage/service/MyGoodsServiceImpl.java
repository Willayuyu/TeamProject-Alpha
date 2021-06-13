package com.example.fidledemo.historypage.service;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.BO.GoodsIndentBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.GoodsCategoryVO;
import com.example.fidledemo.VO.GoodsTagVO;
import com.example.fidledemo.VO.MyGoodsVO;
import com.example.fidledemo.dao.*;
import com.example.fidledemo.historypage.utils.PageHelper;
import com.example.fidledemo.historypage.utils.SortVOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zyf
 */
@Service
public class MyGoodsServiceImpl implements MyGoodsService{

    @Autowired
    GoodsInfoDAO goodsInfoDAO;

    @Autowired
    GoodsIndentDAO goodsIndentDAO;

    @Autowired
    GoodsEvaluationDAO goodsEvaluationDAO;

    @Autowired
    TagOfGoodsDAO tagOfGoodsDAO;

    @Autowired
    GoodsTagDAO goodsTagDAO;

    @Autowired
    GoodsImageDAO goodsImageDAO;


    @Override
    public List<MyGoodsVO> listGoodsOnSale(Integer pageid,Long sellerId) {
        SortVOList sort = new SortVOList();
        //根据二手物品状态和发布者id筛选二手物品信息
        GoodsInfoDO goodsInfoDO= new GoodsInfoDO();
        goodsInfoDO.setSold(1);
        goodsInfoDO.setSellerId(sellerId);
        List<GoodsInfoBO> list = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());
        //分页

        //将GoodsInfoBO转换为MyGoodsVO
        List <MyGoodsVO> list1 = new ArrayList<>();
        for (int i =0 ;i<list.size();i++) {
            GoodsInfoBO item = list.get(i);
            //获取第一张图片
            String imageLink = item.getImageList().get(0).getImageLink();

            //转换类别
            GoodsCategoryVO categoryVO = new GoodsCategoryVO();
            categoryVO.setCategoryId(item.getCategory().getCategoryId());
            categoryVO.setCategoryDesignation(item.getCategory().getCategoryDesignation());


            //转换标签
            List<GoodsTagVO> list2 = new ArrayList<>();
            for (int j = 0;j <item.getTagList().size();j++){
                GoodsTagVO item2 = new GoodsTagVO();
                item2.setId(item.getTagList().get(j).getId());
                item2.setContent(item.getTagList().get(j).getContent());
                list2.add(item2);
            }

            //构建MyGoodsVO对象
            MyGoodsVO myGoodsVO = new MyGoodsVO(item.getId(),item.getPubId(),null,
                    item.getTitle(),item.getPrice(),item.getOriginalPrice(),imageLink,
                    item.getCondition(),categoryVO.getCategoryDesignation(),list2,0);
            myGoodsVO.setIsEvaluated(-1);
            list1.add(myGoodsVO);
        }
        //按评价和id排序
        Collections.sort(list1,sort);

        //分页
        PageHelper<MyGoodsVO> pageHelper = new PageHelper<>(list1,5);
        List<MyGoodsVO> myGoodsVOS = pageHelper.getPageByNum(pageid);
        return myGoodsVOS;
    }

    @Override
    public List<MyGoodsVO> listGoodsSold(Integer pageid,Long sellerId) {
        SortVOList sort = new SortVOList();

        //根据sellerid和已卖出状态对二手物品信息筛选
        GoodsInfoDO goodsInfoDO= new GoodsInfoDO();
        goodsInfoDO.setSold(2);
        goodsInfoDO.setSellerId(sellerId);
        List<GoodsInfoBO> list = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());

        //将GoodsInfoBO转换为MyGoodsVO
        List <MyGoodsVO> list1 = new ArrayList<>();
        for (int i =0 ;i<list.size();i++) {
            GoodsInfoBO item = list.get(i);

            //获取第一张图片
            String imageLink = item.getImageList().get(0).getImageLink();

            //转换类别
            GoodsCategoryVO categoryVO = new GoodsCategoryVO();
            categoryVO.setCategoryId(item.getCategory().getCategoryId());
            categoryVO.setCategoryDesignation(item.getCategory().getCategoryDesignation());

            //转换标签
            List<GoodsTagVO> list2 = new ArrayList<>();
            for (int j = 0;j <item.getTagList().size();j++){
                GoodsTagVO item2 = new GoodsTagVO();
                item2.setId(item.getTagList().get(j).getId());
                item2.setContent(item.getTagList().get(j).getContent());
                list2.add(item2);
            }

            //查找是否评价
            GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
            goodsIndentDO.setGoodsId(item.getId());
            List<GoodsIndentBO> indentBOList = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
            Integer isEvaluated = -1;
            if (indentBOList != null){
                isEvaluated = indentBOList.get(0).getPubEvaluated();
            }

            //构建MyGoodsVO
            MyGoodsVO myGoodsVO = new MyGoodsVO(item.getId(),item.getPubId(),null,
                    item.getTitle(),item.getPrice(),item.getOriginalPrice(),imageLink,
                    item.getCondition(),categoryVO.getCategoryDesignation(),list2,isEvaluated);
            myGoodsVO.setIsEvaluated(isEvaluated);
            list1.add(myGoodsVO);
        }
        //按评价和id排序
        Collections.sort(list1,sort);

        //分页
        PageHelper<MyGoodsVO> pageHelper = new PageHelper<>(list1,5);
        List<MyGoodsVO> myGoodsVOS = pageHelper.getPageByNum(pageid);
        return myGoodsVOS;
    }

    @Override
    public List<MyGoodsVO> listGoodsBuying(Integer pageid,Long id) {
        SortVOList sort = new SortVOList();

        //根据买家id筛选二手物品订单表
        GoodsIndentDO indentDO = new GoodsIndentDO();
        indentDO.setBuyerId(id);
        List<GoodsIndentBO> list = goodsIndentDAO.listGoodsIndentByDO(indentDO);
        System.out.println(list.size());
        //根据二手订单表中的二手物品信息id获取二手物品信息，并转换为MyGoodsVO
        List<MyGoodsVO> list1 = new ArrayList<>();
        for (int i = 0;i <list.size();i++){
            MyGoodsVO item = new MyGoodsVO();

            //获取关键id
            Long infoId = list.get(i).getInfoId();//二手物品id
            Long buyerId = list.get(i).getAccId();//买家id
            Long sellerId = list.get(i).getPubId();//卖家id

            //通过信息id获取二手物品信息，如果获取不到则不添加到列表中
            GoodsInfoBO goodsInfoBO1 = goodsInfoDAO.getGoodsInfoById(infoId);
            if (goodsInfoBO1 != null){

                //通过获取到的信息再通过listmapper查找获得图片，类别
                GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
                goodsInfoDO.setTitle(goodsInfoBO1.getTitle());
                goodsInfoDO.setSellerId(goodsInfoBO1.getPubId());
                goodsInfoDO.setDescription(goodsInfoBO1.getDescription());
                goodsInfoDO.setCondition(goodsInfoBO1.getCondition());
                goodsInfoDO.setCategory(goodsInfoBO1.getCategory().getCategoryId());
                List<GoodsInfoBO> goodsInfoBOList = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());

                //将GoodsInfoBO转化为MyGoodsVO
                GoodsInfoBO goodsInfoBO = goodsInfoBOList.get(0);

                //获取第一张图片
                String imageLink = goodsInfoBO.getImageList().get(0).getImageLink();

                //转化类别
                GoodsCategoryVO categoryVO = new GoodsCategoryVO();
                categoryVO.setCategoryId(goodsInfoBO.getCategory().getCategoryId());
                categoryVO.setCategoryDesignation(goodsInfoBO.getCategory().getCategoryDesignation());

                //转化标签列表
                List<GoodsTagVO> list2 = new ArrayList<>();
                for (int j = 0;j <goodsInfoBO.getTagList().size();j++){
                    GoodsTagVO item2 = new GoodsTagVO();
                    item2.setId(goodsInfoBO.getTagList().get(j).getId());
                    item2.setContent(goodsInfoBO.getTagList().get(j).getContent());
                    list2.add(item2);
                }

                //查找是否评价
                GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
                goodsIndentDO.setGoodsId(goodsInfoBO.getId());
                List<GoodsIndentBO> indentBOList = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
                Integer isEvaluated = -1;
                if (indentBOList != null){
                    isEvaluated = indentBOList.get(0).getAccEvaluated();
                }

                //设置MyGoodsVO属性
                item.setBuyerId(buyerId);
                item.setId(infoId);
                item.setCategory(categoryVO.getCategoryDesignation());
                item.setCondition(goodsInfoBO.getCondition());
                item.setImageLink(imageLink);
                item.setPrice(goodsInfoBO.getPrice());
                item.setOriginalPrice(goodsInfoBO.getOriginalPrice());
                item.setTitle(goodsInfoBO.getTitle());
                item.setTagList(list2);
                item.setSellerId(sellerId);
                item.setIsEvaluated(isEvaluated);
                list1.add(item);
            }

        }
        //按评价和id排序
        Collections.sort(list1,sort);

        //分页
        PageHelper<MyGoodsVO> pageHelper = new PageHelper<>(list1,5);
        List<MyGoodsVO> myGoodsVOS = pageHelper.getPageByNum(pageid);
        return myGoodsVOS;
    }

    @Override
    public void generateOrder(Long id, Long buyerId,Long sellerId) {
        //插入订单表
        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
        goodsIndentDO.setGoodsId(id);
        goodsIndentDO.setSellerId(sellerId);
        goodsIndentDO.setBuyerId(buyerId);
        goodsIndentDO.setSellerEvaluated(0);
        goodsIndentDO.setBuyerEvaluated(0);
        goodsIndentDAO.insertGoodsIndent(goodsIndentDO);

        //更新二手物品状态
        GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
        goodsInfoDO.setId(id);
        goodsInfoDO.setSellerId(sellerId);
        goodsInfoDO.setSold(2);
        goodsInfoDAO.updateGoodsInfo(goodsInfoDO);


    }

    @Override
    public void withdrawGoods(Long id) {
        goodsInfoDAO.deleteGoodsInfoById(id);
    }

    @Override
    public void alertGoods(Long id,String title, BigDecimal price, BigDecimal originPrice, String description, Long category,Integer condition, String[] images,String[] tags) {
        //更新基本信息
        GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
        goodsInfoDO.setCategory(category);
        goodsInfoDO.setId(id);
        goodsInfoDO.setCondition(condition);
        goodsInfoDO.setDescription(description);
        goodsInfoDO.setTitle(title);
        goodsInfoDO.setPrice(price);
        goodsInfoDO.setOriginalPrice(originPrice);
        goodsInfoDAO.updateGoodsInfo(goodsInfoDO);

        //删除所有标签关系
        goodsTagDAO.deleteGoodsTagById(id);
        //更新标签
        if (tags != null) {
            for (int i = 0; i < tags.length; i++) {
                TagOfGoodsDO item = new TagOfGoodsDO();
                item.setContent(tags[i]);
                //检查是否存在改标签，没有则增加
                if (tagOfGoodsDAO.checkGoodsTag(item.getContent()) == null) {
                    tagOfGoodsDAO.insertTagOfGoods(item);
                }
                Long tagID = tagOfGoodsDAO.checkGoodsTag(item.getContent());

                //增加标签与任务委托的对应关系
                GoodsTagDO goodsTagDO = new GoodsTagDO();
                goodsTagDO.setGoodsId(id);
                goodsTagDO.setTagId(tagID);
                goodsTagDAO.insertGoodsTag(goodsTagDO);
            }
        }

        //更新图片
        if (images != null) {
            goodsImageDAO.deleteGoodsImageById(id);
            for (int i = 0; i < images.length; i++) {
                GoodsImageDO item = new GoodsImageDO();
                item.setImageLink(images[i]);
                item.setGoodsId(id);
                goodsImageDAO.insertGoodsImage(item);
            }
        }

    }

    @Override
    public void evaluateBuyer(Long id, Long evaluatorId,Integer evaluation, String reason) {

        //获取订单id
        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
        goodsIndentDO.setGoodsId(id);
        goodsIndentDO.setSellerId(evaluatorId);
        List<GoodsIndentBO> list2 = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
        Long intentId = list2.get(0).getId();
        //插入评价
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
        goodsEvaluationDO.setEvaluation(evaluation);
        goodsEvaluationDO.setEvaluatorId(evaluatorId);
        goodsEvaluationDO.setReason(reason);
        goodsEvaluationDO.setGoodsId(id);
        goodsEvaluationDAO.insertGoodsEvaluation(goodsEvaluationDO);

        //获取评价id
        List<EvaluationBO> list = goodsEvaluationDAO.listGoodsEvaluationByDO(goodsEvaluationDO);
        Long evaluationId = list.get(0).getId();

        //更新订单信息
        goodsIndentDO = new GoodsIndentDO();
        goodsIndentDO.setId(intentId);
        goodsIndentDO.setSellerEvaluateId(evaluationId);
        goodsIndentDO.setSellerEvaluated(1);
        goodsIndentDAO.updateGoodsIndent(goodsIndentDO);

    }

    @Override
    public void evaluateSeller(Long id, Long evaluatorId,Integer evaluation, String reason) {

        //获取订单id
        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
        goodsIndentDO.setGoodsId(id);
        goodsIndentDO.setBuyerId(evaluatorId);
        List<GoodsIndentBO> list2 = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
        Long intentId = list2.get(0).getId();
        //插入评价
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
        goodsEvaluationDO.setEvaluation(evaluation);
        goodsEvaluationDO.setEvaluatorId(evaluatorId);
        goodsEvaluationDO.setReason(reason);
        goodsEvaluationDO.setGoodsId(id);
        goodsEvaluationDAO.insertGoodsEvaluation(goodsEvaluationDO);

        //获取评价id
        List<EvaluationBO> list = goodsEvaluationDAO.listGoodsEvaluationByDO(goodsEvaluationDO);
        Long evaluationId = list.get(0).getId();

        //更新订单信息
        goodsIndentDO = new GoodsIndentDO();
        goodsIndentDO.setId(intentId);
        goodsIndentDO.setBuyerEvaluateId(evaluationId);
        goodsIndentDO.setBuyerEvaluated(1);
        goodsIndentDAO.updateGoodsIndent(goodsIndentDO);
    }
}
