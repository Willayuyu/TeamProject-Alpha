package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.CategoryBO;
import com.example.fidledemo.VO.TaskCategoryVO;
import com.example.fidledemo.dao.TaskCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class TaskCategoryServiceImpl implements TaskCategoryService{

    @Autowired
    TaskCategoryDAO taskCategoryDAO;
    @Override
    public List<TaskCategoryVO> listAllTaskCategory() {
        List<CategoryBO> categoryBOS = taskCategoryDAO.listAllTaskCategory();
        List<TaskCategoryVO> taskCategoryVOS=new ArrayList<>();
        for (CategoryBO categoryBO:categoryBOS) {
            TaskCategoryVO taskCategoryVO = new TaskCategoryVO();
            //?????????????????
            taskCategoryVO.setCategoryId(categoryBO.getCategoryId());
            taskCategoryVO.setCategoryDesignation(categoryBO.getCategoryDesignation());
            taskCategoryVOS.add(taskCategoryVO);
        }
        return taskCategoryVOS;
    }
}
