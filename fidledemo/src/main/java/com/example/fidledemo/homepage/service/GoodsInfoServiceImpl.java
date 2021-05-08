package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.VO.GoodsTagVO;
import com.example.fidledemo.VO.GoodsVO;
import com.example.fidledemo.VO.TaskTagVO;
import com.example.fidledemo.dao.GoodsInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService{

    @Autowired
    GoodsInfoDAO goodsInfoDAO;

    @Override
    public GoodsVO getGoodsInfoById(Long id) {
        GoodsInfoBO goodsInfoBO = goodsInfoDAO.getGoodsInfoById(id);
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setId(goodsInfoBO.getId());
        goodsVO.setPubId(goodsInfoBO.getPubId());
        goodsVO.setTitle(goodsInfoBO.getTitle());
        goodsVO.setPrice(goodsInfoBO.getPrice());
        goodsVO.setOriginalPrice(goodsInfoBO.getOriginalPrice());
        goodsVO.setDescription(goodsInfoBO.getDescription());
        goodsVO.setCategory(goodsInfoBO.getCategory().getCategoryDesignation());

        List<TagBO> tagList = goodsInfoBO.getTagList();
        List<TaskTagVO> taskTagVOS=new ArrayList<>();
        for (TagBO tagBO:tagList) {
            TaskTagVO taskTagVO = new TaskTagVO();
            taskTagVO.setId(tagBO.getId());
            taskTagVO.setContent(tagBO.getContent());
            taskTagVOS.add(taskTagVO);
        }

        goodsVO.setTagList(taskTagVOS);

        List<ImageBO> imageList = goodsInfoBO.getImageList();
        List<String> picturesLink=new ArrayList<>();
        for (ImageBO imageBO:imageList) {
            String link=imageBO.getImageLink();
            picturesLink.add(link);
        }

        goodsVO.setPicturesLink(picturesLink);
        goodsVO.setCondition(goodsInfoBO.getCondition());

        return goodsVO;
    }

    /**
     * 无关键词筛选
     * @param infoDO
     * @param tagDO
     * @return
     */
    @Override
    public List<GoodsItemVO> listGoodsInfoByDO(GoodsInfoDO infoDO, TagOfGoodsDO tagDO) {
        List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoByDO(infoDO, tagDO);
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

    /**
     * 关键词搜索
     * @param infoDO
     * @param tagDO
     * @return
     */
    @Override
    public List<GoodsItemVO> listGoodsInfoBySearch(GoodsInfoDO infoDO, TagOfGoodsDO tagDO) {
        List<GoodsInfoBO> goodsInfoBOS = goodsInfoDAO.listGoodsInfoBySearch(infoDO, tagDO);

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
