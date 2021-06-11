package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.DO.TaskReportMessageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Mapper
@Repository
public interface TaskReportMessageDAO {

    /**
     * 插入任务举报信息
     * @param taskReportMessage
     */
    void insertTaskReportMessage(TaskReportMessageDO taskReportMessage);

    /**
     * 删除
     * @param id
     */
    void deleteTaskReportMessageById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    ReportMessageBO getTaskReportMessageById(Long id);

    /**
     * 筛选
     * @param taskReportMessage
     * @return
     */
    List<ReportMessageBO> listTaskReportMessageByDO(TaskReportMessageDO taskReportMessage);

    /**
     * 更新
     * @param taskReportMessage
     */
    void updateTaskReportMessage(TaskReportMessageDO taskReportMessage);

    /**
     * 根据DO返回举报数
     * @param taskReportMessage
     * @return
     */
    int getTaskReportNumByDO(TaskReportMessageDO taskReportMessage);
}
