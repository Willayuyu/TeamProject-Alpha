package com.example.fidledemo.dao;

import com.example.fidledemo.BO.TaskDelegateBO;
import com.example.fidledemo.DO.TaskDelegateDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  任务委托DAO
 * @author 11313
 */
@Mapper
public interface TaskDelegateDAO
{
  /**
   * 插入
   * @param delegateDO
   */
  void insertTaskDelegate(TaskDelegateDO delegateDO);

  /**
   * 更新
   * @param delegateDO
   */
  void updateTaskDelegate(TaskDelegateDO delegateDO);

  /**
   * 根据id获得任务委托
   * @param id
   * @return
   */
  TaskDelegateBO getTaskDelegateById(Long id);

  /**
   * 根据DO获得任务委托列表
   * @param delegateDO
   * @return
   */
  List<TaskDelegateBO> listTaskDelegateByDO(TaskDelegateDO delegateDO);


  /**
   * 根据id删除任务委托
   * @param id
   */
  void deleteTaskDelegateById(Long id);






}