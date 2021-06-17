package com.example.fidledemo.sort.service;

import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.VO.GoodsTagVO;
import com.example.fidledemo.dao.GoodsInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsSortServiceImpl implements GoodsSortService
{
  @Autowired
  GoodsInfoDAO goodsInfoDAO;

  @Override
  public List<GoodsItemVO> listGoodsInfoBySearchOrderByConditionDesc(GoodsInfoDO infoDO, TagOfGoodsDO tagDO)
  {
    List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearchOrderByConditionDESC(infoDO, tagDO);

    List<GoodsItemVO> goodsItemVOS = new ArrayList<>();

    for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
      GoodsItemVO goodsItemVO = new GoodsItemVO();
      goodsItemVO.setId(goodsInfoBO.getId());
      goodsItemVO.setSellerId(goodsInfoBO.getPubId());
      goodsItemVO.setTitle(goodsInfoBO.getTitle());
      goodsItemVO.setPrice(goodsInfoBO.getPrice());
      goodsItemVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
      goodsItemVO.setImageLink(goodsInfoBO.getImageList().get(0).getImageLink());
      goodsItemVO.setCondition(goodsInfoBO.getCondition());
      goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

      goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
      goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

      List<TagBO> tagList = goodsInfoBO.getTagList();
      List<GoodsTagVO> goodsTagVOS = new ArrayList<>();
      for (TagBO tagBO:tagList) {
        GoodsTagVO goodsTagVO = new GoodsTagVO();
        goodsTagVO.setId(tagBO.getId());
        goodsTagVO.setContent(tagBO.getContent());
        goodsTagVOS.add(goodsTagVO);
      }
      goodsItemVO.setTagList(goodsTagVOS);
      goodsItemVOS.add(goodsItemVO);
    }
    return goodsItemVOS;
  }

  @Override
  public List<GoodsItemVO> listGoodsInfoBySearchOrderByConditionASC(GoodsInfoDO infoDO, TagOfGoodsDO tagDO)
  {
    List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearchOrderByConditionASC(infoDO, tagDO);

    List<GoodsItemVO> goodsItemVOS = new ArrayList<>();

    for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
      GoodsItemVO goodsItemVO = new GoodsItemVO();
      goodsItemVO.setId(goodsInfoBO.getId());
      goodsItemVO.setSellerId(goodsInfoBO.getPubId());
      goodsItemVO.setTitle(goodsInfoBO.getTitle());
      goodsItemVO.setPrice(goodsInfoBO.getPrice());
      goodsItemVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
      goodsItemVO.setImageLink(goodsInfoBO.getImageList().get(0).getImageLink());
      goodsItemVO.setCondition(goodsInfoBO.getCondition());
      goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

      goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
      goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

      List<TagBO> tagList = goodsInfoBO.getTagList();
      List<GoodsTagVO> goodsTagVOS = new ArrayList<>();
      for (TagBO tagBO:tagList) {
        GoodsTagVO goodsTagVO = new GoodsTagVO();
        goodsTagVO.setId(tagBO.getId());
        goodsTagVO.setContent(tagBO.getContent());
        goodsTagVOS.add(goodsTagVO);
      }
      goodsItemVO.setTagList(goodsTagVOS);
      goodsItemVOS.add(goodsItemVO);
    }
    return goodsItemVOS;
  }

  @Override
  public List<GoodsItemVO> listGoodsInfoBySearchOrderByPriceDesc(GoodsInfoDO infoDO, TagOfGoodsDO tagDO)
  {
    List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearchOrderByPriceDESC(infoDO, tagDO);

    List<GoodsItemVO> goodsItemVOS = new ArrayList<>();

    for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
      GoodsItemVO goodsItemVO = new GoodsItemVO();
      goodsItemVO.setId(goodsInfoBO.getId());
      goodsItemVO.setSellerId(goodsInfoBO.getPubId());
      goodsItemVO.setTitle(goodsInfoBO.getTitle());
      goodsItemVO.setPrice(goodsInfoBO.getPrice());
      goodsItemVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
      goodsItemVO.setImageLink(goodsInfoBO.getImageList().get(0).getImageLink());
      goodsItemVO.setCondition(goodsInfoBO.getCondition());
      goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

      goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
      goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

      List<TagBO> tagList = goodsInfoBO.getTagList();
      List<GoodsTagVO> goodsTagVOS = new ArrayList<>();
      for (TagBO tagBO:tagList) {
        GoodsTagVO goodsTagVO = new GoodsTagVO();
        goodsTagVO.setId(tagBO.getId());
        goodsTagVO.setContent(tagBO.getContent());
        goodsTagVOS.add(goodsTagVO);
      }
      goodsItemVO.setTagList(goodsTagVOS);
      goodsItemVOS.add(goodsItemVO);
    }
    return goodsItemVOS;
  }

  @Override
  public List<GoodsItemVO> listGoodsInfoBySearchOrderByPriceASC(GoodsInfoDO infoDO, TagOfGoodsDO tagDO)
  {
    List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearchOrderByPriceASC(infoDO, tagDO);

    List<GoodsItemVO> goodsItemVOS = new ArrayList<>();

    for (GoodsInfoBO goodsInfoBO:goodsInfoBOS) {
      GoodsItemVO goodsItemVO = new GoodsItemVO();
      goodsItemVO.setId(goodsInfoBO.getId());
      goodsItemVO.setSellerId(goodsInfoBO.getPubId());
      goodsItemVO.setTitle(goodsInfoBO.getTitle());
      goodsItemVO.setPrice(goodsInfoBO.getPrice());
      goodsItemVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
      goodsItemVO.setImageLink(goodsInfoBO.getImageList().get(0).getImageLink());
      goodsItemVO.setCondition(goodsInfoBO.getCondition());
      goodsItemVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

      goodsItemVO.setGmt_create(goodsInfoBO.getGmtInfo().getGmtCreate());
      goodsItemVO.setAnnouncer(goodsInfoBO.getPubName());

      List<TagBO> tagList = goodsInfoBO.getTagList();
      List<GoodsTagVO> goodsTagVOS = new ArrayList<>();
      for (TagBO tagBO:tagList) {
        GoodsTagVO goodsTagVO = new GoodsTagVO();
        goodsTagVO.setId(tagBO.getId());
        goodsTagVO.setContent(tagBO.getContent());
        goodsTagVOS.add(goodsTagVO);
      }
      goodsItemVO.setTagList(goodsTagVOS);
      goodsItemVOS.add(goodsItemVO);
    }
    return goodsItemVOS;
  }
}
