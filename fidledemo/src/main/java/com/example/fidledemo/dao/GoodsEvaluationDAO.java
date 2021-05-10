package com.example.fidledemo.dao;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.DO.GoodsEvaluationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ZSP
 */
@Mapper
@Repository
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
    void deleteGoodsEvaluationById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    EvaluationBO getGoodsEvaluationById(Long id);

    /**
     * 筛选
     * @param goodsEvaluation
     * @return
     */
    List<EvaluationBO> listGoodsEvaluationByDO(GoodsEvaluationDO goodsEvaluation);

    /**
     * 更新
     * @param goodsEvaluation
     */
    void updateGoodsEvaluation(GoodsEvaluationDO goodsEvaluation);

    /**
     * 筛选用户相关的所有评价
     * @param goodsEvaluationDO
     * @return
     */
    List<EvaluationBO> listGoodsEvaluationByUser(GoodsEvaluationDO goodsEvaluationDO);
}
