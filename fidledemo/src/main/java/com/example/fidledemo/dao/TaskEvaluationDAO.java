package com.example.fidledemo.dao;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.DO.TaskEvaluationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Mapper
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
    void deleteTaskEvaluation(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    EvaluationBO getTaskEvaluation(Long id);

    /**
     * 筛选
     * @param taskEvaluation
     * @return
     */
    List<EvaluationBO> listTaskEvaluation(TaskEvaluationDO taskEvaluation);

    /**
     * 更新
     * @param taskEvaluation
     */
    void updateTaskEvaluation(TaskEvaluationDO taskEvaluation);
}
