package com.example.fidledemo.sort.service;

import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.GoodsItemVO;
import com.example.fidledemo.VO.TaskItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 11313
 */
public interface TaskSortService
{
  /**
   * 搜索任务列表并根据时间降序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskItemVO> listGoodsInfoBySearchOrderByDateDesc(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

  /**
   * 搜索任务列表并根据时间升序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskItemVO> listGoodsInfoBySearchOrderByDateASC(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

  /**
   * 搜索任务列表并根据报酬降序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskItemVO> listTaskInfoBySearchOrderByRewardDesc(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

  /**
   * 搜索任务列表并根据报酬升序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<TaskItemVO> listTaskInfoBySearchOrderByRewardASC(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);
}
