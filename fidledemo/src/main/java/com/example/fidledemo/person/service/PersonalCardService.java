package com.example.fidledemo.moudle10.service;

import com.example.fidledemo.VO.*;

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
     * @param pageid
     * @return
     */
    List<GoodsEvaluationVO> getGoodsEvaluationByLike(Long id,Integer isLike,Integer pageid);

    /**
     * 根据好评或差评来筛选任务评价列表
     * @param id
     * @param isLike
     * @param pageid
     * @return
     */
    List<TaskEvaluationVO> getTaskEvaluationByLike(Long id,Integer isLike,Integer pageid);
}
