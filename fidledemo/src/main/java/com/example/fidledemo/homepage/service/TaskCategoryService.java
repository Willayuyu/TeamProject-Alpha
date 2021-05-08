package com.example.fidledemo.homepage.service;

import com.example.fidledemo.VO.TaskCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface TaskCategoryService {

    /**
     * 返回所有已有的任务委托类别
     */
    List<TaskCategoryVO> listAllTaskCategory();
}
