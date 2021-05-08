package com.example.fidledemo.homepage.service;

import com.example.fidledemo.VO.ActivityCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface ActivityCategoryService {

    /**
     * 返回所有已有的活动类别
     * @return
     */
    List<ActivityCategoryVO> listAllActivityCategory();
}
