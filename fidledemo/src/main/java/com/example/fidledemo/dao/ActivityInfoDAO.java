package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 活动信息DAO
 * @author 11313
 */
@Repository
@Mapper
public interface ActivityInfoDAO
{
  /**
   * 插入
   * @param infoDO
   */
  void insertActivityInfo(ActivityInfoDO infoDO);

  /**
   * 更新
   * @param infoDO
   */
  void updateActivityInfo(ActivityInfoDO infoDO);

  /**
   * 根据id获取活动信息
   * @param id
   * @return
   */
  ActivityInfoBO getActivityInfoById(long id);

  /**
   * 根据DO获取活动信息列表
   * @param infoDO
   * @param tag
   * @return
   */
  List<ActivityInfoBO> listActivityInfoByDO(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);

  /**
   * 根据DO搜索活动信息列表
   * @param infoDO
   * @param tag
   * @return
   */
  List<ActivityInfoBO> listActivityInfoBySearch(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);


  /**
   * 根据id删除活动信息
   * @param id
   */
  void deleteActivityInfoById(Long id);

  /**
   * 根据用户id返回其活动信息收藏夹内容
   * @param userDO
   * @return
   */
  List<ActivityInfoBO> listActivityEnshrineByUserDO(@Param("user") UserDO userDO);

  /**
   * 返回总活动数
   * @return
   */
  int getTotalActivityNums();

  /**
   * 返回今日新增活动数
   * @return
   */
  int getNewActivityNums();

  /**
   * 根据时间段返回活动数量
   * @param begin
   * @param end
   * @return
   */
  int getActivityNumByTime(@Param("beginTime") Date begin, @Param("endTime")Date end);

}
