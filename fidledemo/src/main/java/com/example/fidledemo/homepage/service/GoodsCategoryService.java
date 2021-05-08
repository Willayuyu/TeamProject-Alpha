package com.example.fidledemo.homepage.service;

import com.example.fidledemo.VO.GoodsCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface GoodsCategoryService {

    /**
     * 返回所有已有的二手物品类别
     */
    List<GoodsCategoryVO> listAllGoodsCategory();
}
