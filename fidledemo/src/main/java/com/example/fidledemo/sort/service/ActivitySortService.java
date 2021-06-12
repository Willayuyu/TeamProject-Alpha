package com.example.fidledemo.sort.service;

import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.TaskItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 11313
 */
public interface ActivitySortService
{
  /**
   * 搜索活动列表并根据时间降序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<ActivityItemVO> listActivityInfoBySearchOrderByDateDesc(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tagDO);

  /**
   * 搜索活动列表并根据时间升序排序
   * @param infoDO
   * @param tagDO
   * @return
   */
  List<ActivityItemVO> listActivityBySearchOrderByDateASC(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tagDO);
}
