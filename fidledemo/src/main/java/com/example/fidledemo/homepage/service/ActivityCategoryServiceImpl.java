package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.VO.ActivityCategoryVO;
import com.example.fidledemo.dao.ActivityCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService{

    @Autowired
    ActivityCategoryDAO activityCategoryDAO;
    @Override
    public List<ActivityCategoryVO> listAllActivityCategory() {
        List<CategoryBO> categoryBOS = activityCategoryDAO.listAllActivityCategory();
        List<ActivityCategoryVO> activityCategoryVOS=new ArrayList<>();
        for (CategoryBO categoryBO:categoryBOS) {
            ActivityCategoryVO activityCategoryVO = new ActivityCategoryVO();
            activityCategoryVO.setCategoryId(categoryBO.getCategoryId());
            activityCategoryVO.setCategoryDesignation(categoryBO.getCategoryDesignation());
            activityCategoryVOS.add(activityCategoryVO);
        }
        return activityCategoryVOS;
    }
}
