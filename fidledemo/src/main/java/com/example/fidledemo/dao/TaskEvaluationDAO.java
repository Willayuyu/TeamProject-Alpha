package com.example.fidledemo.dao;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.DO.TaskEvaluationDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Mapper
@Repository
public interface TaskEvaluationDAO {

    /**
     * 插入任务委托评价
     * @param taskEvaluation
     */
    void insertTaskEvaluation(TaskEvaluationDO taskEvaluation);

    /**
     * 删除
     * @param id
     */
    void deleteTaskEvaluationById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    EvaluationBO getTaskEvaluationById(Long id);

    /**
     * 筛选
     * @param taskEvaluation
     * @return
     */
    List<EvaluationBO> listTaskEvaluationByDO(TaskEvaluationDO taskEvaluation);

    /**
     * 更新
     * @param taskEvaluation
     */
    void updateTaskEvaluation(TaskEvaluationDO taskEvaluation);

    /**
     * 筛选所有用户相关的评价
     * @param taskEvaluation
     * @return
     */
    List<EvaluationBO> listTaskEvaluationByUser(TaskEvaluationDO taskEvaluation);
}
