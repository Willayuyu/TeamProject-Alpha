package com.example.fidledemo.homepage.service;


import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.VO.GoodsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsInfoService {

    /**
     * 根据id获得二手物品信息
     * @param id
     * @return
     */
    GoodsVO getGoodsInfoById(Long id);

    /**
     * 根据DO查询二手物品列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<GoodsItemVO> listGoodsInfoByDO(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

    /**
     * 根据DO搜索二手物品列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<GoodsItemVO> listGoodsInfoBySearch(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);
}
