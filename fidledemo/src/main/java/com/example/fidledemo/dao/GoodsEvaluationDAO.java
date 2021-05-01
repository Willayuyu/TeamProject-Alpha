package com.example.fidledemo.dao;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.DO.GoodsEvaluationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZSP
 */
@Mapper
public interface GoodsEvaluationDAO {

    /**
     * 插入二手评价
     * @param goodsEvaluation
     */
    void insertGoodsEvaluation(GoodsEvaluationDO goodsEvaluation);

    /**
     * 删除
     * @param id
     */
    void deleteGoodsEvaluation(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    EvaluationBO getGoodsEvaluation(Long id);

    /**
     * 筛选
     * @param goodsEvaluation
     * @return
     */
    List<EvaluationBO> listGoodsEvaluation(GoodsEvaluationDO goodsEvaluation);

    /**
     * 更新
     * @param goodsEvaluation
     */
    void updateGoodsEvaluation(GoodsEvaluationDO goodsEvaluation);
}
