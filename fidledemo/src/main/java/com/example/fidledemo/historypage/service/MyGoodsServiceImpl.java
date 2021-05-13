//package com.example.fidledemo.moudle10.service;
//
//import com.example.fidledemo.BO.*;
//import com.example.fidledemo.DO.*;
//import com.example.fidledemo.VO.GoodsCategoryVO;
//import com.example.fidledemo.VO.GoodsImageVO;
//import com.example.fidledemo.VO.GoodsTagVO;
//import com.example.fidledemo.VO.MyGoodsVO;
//import com.example.fidledemo.dao.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author zyf
// */
//@Service
//public class MyGoodsServiceImpl implements MyGoodsService{
//
//    @Autowired
//    GoodsInfoDAO goodsInfoDAO;
//
//    @Autowired
//    GoodsIndentDAO goodsIndentDAO;
//
//    @Autowired
//    GoodsEvaluationDAO goodsEvaluationDAO;
//
//    @Autowired
//    TagOfGoodsDAO tagOfGoodsDAO;
//
//    @Autowired
//    GoodsTagDAO goodsTagDAO;
//
//    @Autowired
//    GoodsImageDAO goodsImageDAO;
//
//    @Override
//    public List<MyGoodsVO> listGoodsOnSale(Integer pageid,Long sellerId) {
//        GoodsInfoBO goodsInfoBO=new GoodsInfoBO(sellerId, "", "", null,
//                null, "",
//                null,null,null,null);
//        goodsInfoBO.setSold(1);
//        GoodsInfoDO goodsInfoDO= goodsInfoBO.getGoodsInfoDO();
//        goodsInfoDO.setLimit(Boolean.TRUE);
//        goodsInfoDO.setBegin((pageid-1)*5);
//        goodsInfoDO.setSize(5);
//        System.out.println(goodsInfoDO);
//        List<GoodsInfoBO> list = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());
//        List <MyGoodsVO> list1 = new ArrayList<>();
//        for (int i =0 ;i<list.size();i++) {
//            GoodsInfoBO item = list.get(i);
//            String imageLink = item.getImageList().get(0).getImageLink();
//            GoodsCategoryVO categoryVO = new GoodsCategoryVO();
//            categoryVO.setCategoryId(item.getCategory().getCategoryId());
//            categoryVO.setCategoryDesignation(item.getCategory().getCategoryDesignation());
//            List<GoodsTagVO> list2 = new ArrayList<>();
//            for (int j = 0;j <item.getTagList().size();j++){
//                GoodsTagVO item2 = new GoodsTagVO();
//                item2.setId(item.getTagList().get(j).getId());
//                item2.setContent(item.getTagList().get(j).getContent());
//                list2.add(item2);
//            }
//            MyGoodsVO myGoodsVO = new MyGoodsVO(item.getId(),item.getPubId(),null,item.getTitle(),item.getPrice(),item.getOriginalPrice(),imageLink,item.getCondition(),categoryVO.getCategoryDesignation(),list2);
//            list1.add(myGoodsVO);
//        }
//        for (int i = 0;i<list1.size();i++){
//            System.out.println(list1.get(i));
//        }
//            return list1;
//    }
//
//    @Override
//    public List<MyGoodsVO> listGoodsSold(Integer pageid,Long sellerId) {
//        GoodsInfoBO goodsInfoBO=new GoodsInfoBO(sellerId, "", "", null,
//                null, "",
//                null,null,null,null);
//        goodsInfoBO.setSold(2);
//        GoodsInfoDO goodsInfoDO= goodsInfoBO.getGoodsInfoDO();
//        goodsInfoDO.setLimit(Boolean.TRUE);
//        goodsInfoDO.setBegin((pageid-1)*5);
//        goodsInfoDO.setSize(5);
//        List<GoodsInfoBO> list = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());
//        List <MyGoodsVO> list1 = new ArrayList<>();
//        for (int i =0 ;i<list.size();i++) {
//            GoodsInfoBO item = list.get(i);
//            String imageLink = item.getImageList().get(0).getImageLink();
//            GoodsCategoryVO categoryVO = new GoodsCategoryVO();
//            categoryVO.setCategoryId(item.getCategory().getCategoryId());
//            categoryVO.setCategoryDesignation(item.getCategory().getCategoryDesignation());
//            List<GoodsTagVO> list2 = new ArrayList<>();
//            for (int j = 0;j <item.getTagList().size();j++){
//                GoodsTagVO item2 = new GoodsTagVO();
//                item2.setId(item.getTagList().get(j).getId());
//                item2.setContent(item.getTagList().get(j).getContent());
//                list2.add(item2);
//            }
//            MyGoodsVO myGoodsVO = new MyGoodsVO(item.getId(),item.getPubId(),null,item.getTitle(),item.getPrice(),item.getOriginalPrice(),imageLink,item.getCondition(),categoryVO.getCategoryDesignation(),list2);
//            list1.add(myGoodsVO);
//        }
//
//        return list1;
//    }
//
//    @Override
//    public List<MyGoodsVO> listGoodsBuying(Integer pageid,Long id) {
//        GoodsIndentDO indentDO = new GoodsIndentDO();
//        indentDO.setBuyerId(id);
//        indentDO.setLimit(Boolean.TRUE);
//        indentDO.setBegin((pageid-1)*5);
//        indentDO.setSize(5);
//        List<GoodsIndentBO> list = goodsIndentDAO.listGoodsIndentByDO(indentDO);
//        List<MyGoodsVO> list1 = new ArrayList<>();
//        for (int i = 0;i <list.size();i++){
//            MyGoodsVO item = new MyGoodsVO();
//            Long infoId = list.get(i).getInfoId();
//            Long buyerId = list.get(i).getAccId();
//            Long sellerId = list.get(i).getPubId();
//
//
//            GoodsInfoBO goodsInfoBO1 = goodsInfoDAO.getGoodsInfoById(infoId);
//            GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
//            goodsInfoDO.setTitle(goodsInfoBO1.getTitle());
//            goodsInfoDO.setPrice(goodsInfoBO1.getPrice());
//            goodsInfoDO.setSellerId(goodsInfoBO1.getPubId());
//            goodsInfoDO.setDescription(goodsInfoBO1.getDescription());
//            goodsInfoDO.setCondition(goodsInfoBO1.getCondition());
//            goodsInfoDO.setCategory(goodsInfoBO1.getCategory().getCategoryId());
//            List<GoodsInfoBO> goodsInfoBOList = goodsInfoDAO.listGoodsInfoByDO(goodsInfoDO,new TagOfGoodsDO());
//            GoodsInfoBO goodsInfoBO = goodsInfoBOList.get(0);
//
//            String imageLink = goodsInfoBO.getImageList().get(0).getImageLink();
//            GoodsCategoryVO categoryVO = new GoodsCategoryVO();
//            categoryVO.setCategoryId(goodsInfoBO.getCategory().getCategoryId());
//            categoryVO.setCategoryDesignation(goodsInfoBO.getCategory().getCategoryDesignation());
//            List<GoodsTagVO> list2 = new ArrayList<>();
//            for (int j = 0;j <goodsInfoBO.getTagList().size();j++){
//                GoodsTagVO item2 = new GoodsTagVO();
//                item2.setId(goodsInfoBO.getTagList().get(j).getId());
//                item2.setContent(goodsInfoBO.getTagList().get(j).getContent());
//                list2.add(item2);
//            }
//            item.setBuyerId(buyerId);
//            item.setId(infoId);
//            item.setCategory(categoryVO.getCategoryDesignation());
//            item.setCondition(goodsInfoBO.getCondition());
//            item.setImageLink(imageLink);
//            item.setPrice(goodsInfoBO.getPrice());
//            item.setOriginalPrice(goodsInfoBO.getOriginalPrice());
//            item.setTitle(goodsInfoBO.getTitle());
//            item.setTagList(list2);
//            item.setSellerId(sellerId);
//            list1.add(item);
//        }
//        return list1;
//    }
//
//    @Override
//    public void generateOrder(Long id, Long buyerId,Long sellerId) {
//        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
//        goodsIndentDO.setGoodsId(id);
//        goodsIndentDO.setSellerId(sellerId);
//        goodsIndentDO.setBuyerId(buyerId);
//        goodsIndentDO.setSellerEvaluated(0);
//        goodsIndentDO.setBuyerEvaluated(0);
//        goodsIndentDAO.insertGoodsIndent(goodsIndentDO);
//
//    }
//
//    @Override
//    public void withdrawGoods(Long id) {
//        goodsInfoDAO.deleteGoodsInfoById(id);
//    }
//
//    @Override
//    public void alertGoods(Long id,String title, BigDecimal price, BigDecimal originPrice, String description, Long category,Integer condition, String[] images,String[] tags) {
//        //更新基本信息
//        GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
//        goodsInfoDO.setCategory(category);
//        goodsInfoDO.setId(id);
//        goodsInfoDO.setCondition(condition);
//        goodsInfoDO.setDescription(description);
//        goodsInfoDO.setTitle(title);
//        goodsInfoDO.setPrice(price);
//        goodsInfoDO.setOriginalPrice(originPrice);
//        goodsInfoDAO.updateGoodsInfo(goodsInfoDO);
//
//        //更新标签
//        goodsTagDAO.deleteGoodsTagById(id);
//        //更新标签
//        for (int i = 0;i < tags.length;i++){
//            TagOfGoodsDO item = new TagOfGoodsDO();
//            item.setContent(tags[i]);
//            //检查是否存在改标签，没有则增加
//            if(tagOfGoodsDAO.checkGoodsTag(item.getContent()) == null){
//                tagOfGoodsDAO.insertTagOfGoods(item);
//            }
//            Long tagID =tagOfGoodsDAO.checkGoodsTag(item.getContent());
//
//            //增加标签与任务委托的对应关系
//            GoodsTagDO goodsTagDO = new GoodsTagDO();
//            goodsTagDO.setGoodsId(id);
//            goodsTagDO.setTagId(tagID);
//            goodsTagDAO.insertGoodsTag(goodsTagDO);
//        }
//
//        //更新图片
//        //更新图片
//        for (int i = 0;i < images.length;i++){
//            GoodsImageDO item = new GoodsImageDO();
//            item.setImageLink(images[i]);
//            item.setGoodsId(id);
//            if (goodsImageDAO.getGoodsImageByLink(item.getImageLink()) == null){
//                goodsImageDAO.insertGoodsImage(item);
//            }
//        }
//
//    }
//
//    @Override
//    public void evaluateBuyer(Long id, Long evaluatorId,Integer evaluation, String reason) {
//
//        //获取订单id
//        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
//        goodsIndentDO.setGoodsId(id);
//        goodsIndentDO.setSellerId(evaluatorId);
//        List<GoodsIndentBO> list2 = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
//        Long intentId = list2.get(0).getId();
//        //插入评价
//        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
//        goodsEvaluationDO.setEvaluation(evaluation);
//        goodsEvaluationDO.setEvaluatorId(evaluatorId);
//        goodsEvaluationDO.setReason(reason);
//        goodsEvaluationDO.setGoodsId(id);
//        goodsEvaluationDAO.insertGoodsEvaluation(goodsEvaluationDO);
//
//        //获取评价id
//        List<EvaluationBO> list = goodsEvaluationDAO.listGoodsEvaluationByDO(goodsEvaluationDO);
//        Long evaluationId = list.get(0).getId();
//
//        //更新订单信息
//        goodsIndentDO = new GoodsIndentDO();
//        goodsIndentDO.setId(intentId);
//        goodsIndentDO.setSellerEvaluateId(evaluationId);
//        goodsIndentDO.setSellerEvaluated(1);
//        goodsIndentDAO.updateGoodsIndent(goodsIndentDO);
//
//    }
//
//    @Override
//    public void evaluateSeller(Long id, Long evaluatorId,Integer evaluation, String reason) {
//
//        //获取订单id
//        GoodsIndentDO goodsIndentDO = new GoodsIndentDO();
//        goodsIndentDO.setGoodsId(id);
//        goodsIndentDO.setBuyerId(evaluatorId);
//        List<GoodsIndentBO> list2 = goodsIndentDAO.listGoodsIndentByDO(goodsIndentDO);
//        Long intentId = list2.get(0).getId();
//        //插入评价
//        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
//        goodsEvaluationDO.setEvaluation(evaluation);
//        goodsEvaluationDO.setEvaluatorId(evaluatorId);
//        goodsEvaluationDO.setReason(reason);
//        goodsEvaluationDO.setGoodsId(id);
//        goodsEvaluationDAO.insertGoodsEvaluation(goodsEvaluationDO);
//
//        //获取评价id
//        List<EvaluationBO> list = goodsEvaluationDAO.listGoodsEvaluationByDO(goodsEvaluationDO);
//        Long evaluationId = list.get(0).getId();
//
//        //更新订单信息
//        goodsIndentDO = new GoodsIndentDO();
//        goodsIndentDO.setId(intentId);
//        goodsIndentDO.setBuyerEvaluateId(evaluationId);
//        goodsIndentDO.setBuyerEvaluated(1);
//        goodsIndentDAO.updateGoodsIndent(goodsIndentDO);
//    }
//}
