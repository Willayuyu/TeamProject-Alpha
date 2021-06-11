package com.example.fidledemo.dao;

import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 任务信息DAO
 * @author 11313
 */
@Mapper
@Repository
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

  /**
   *  根据用户id返回其任务委托收藏夹内容
   * @param userDO
   * @return
   */
  List<TaskInfoBO> listTaskEnshrineByUserDO(@Param("user") UserDO userDO);

  /**
   * 返回总任务数
   * @return
   */
  int getTotalTaskNums();

  /**
   * 返回今日新增任务数
   * @return
   */
  int getNewTaskNums();



}