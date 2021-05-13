package com.example.fidledemo.person.service;

import com.example.fidledemo.VO.GoodsEvaluationVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.VO.TaskEvaluationVO;

import java.util.List;

/**
 * @author zyf
 */
public interface PersonalCardService {
    /**
     * 根据用户id返回个人名平
     * @param id
     * @return
     */
    PersonVO getCard(Long id);

    /**
     * 根据好评或差评来筛选二手物品评价列表
     * @param id
     * @param isLike
     * @return
     */
    List<GoodsEvaluationVO> getGoodsEvaluationByLike(Long id, Integer isLike);

    /**
     * 根据好评或差评来筛选任务评价列表
     * @param id
     * @param isLike
     * @return
     */
    List<TaskEvaluationVO> getTaskEvaluationByLike(Long id, Integer isLike);
}

