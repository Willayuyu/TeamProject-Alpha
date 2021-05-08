package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.VO.GoodsCategoryVO;
import com.example.fidledemo.dao.GoodsCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{

    @Autowired
    GoodsCategoryDAO categoryDAO;

    @Override
    public List<GoodsCategoryVO> listAllGoodsCategory() {
        List<CategoryBO> categoryList = categoryDAO.listAllGoodsCategory();

        List<GoodsCategoryVO> categoryVOS=new ArrayList<>();

        for (CategoryBO categoryBO:categoryList) {
            GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO();
            //要设置id还是CategoryId????????????????????
            goodsCategoryVO.setCategoryId(categoryBO.getCategoryId());
            goodsCategoryVO.setCategoryDesignation(categoryBO.getCategoryDesignation());
            categoryVOS.add(goodsCategoryVO);
        }

        return categoryVOS;
    }
}
