package com.example.fidledemo.DAO;

import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务信息DAO
 * @author 11313
 */
@Mapper
public interface TaskInfoDAO
{
  /**
   * 插入
   * @param infoDO
   */
  void insertTaskInfo(TaskInformationDO infoDO);

  /**
   * 更新
   * @param infoDO
   */
  void updateTaskInfo(TaskInformationDO infoDO);

  /**
   * 根据id获得任务信息
   * @param id
   * @return
   */
  TaskInfoBO getTaskInfoById(Long id);

  /**
   * 根据DO获得任务信息列表
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskInfoBO> listTaskInfoByDO(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

  /**
   * 根据DO搜索任务信息列表
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskInfoBO> listTaskInfoBySearch(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

  /**
   * 根据id删除任务信息
   * @param id
   */
  void deleteTaskInfoById(Long id);



}