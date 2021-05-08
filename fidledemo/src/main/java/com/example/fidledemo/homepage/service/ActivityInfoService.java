package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.VO.ActivityItemVO;
import com.example.fidledemo.VO.ActivityVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface ActivityInfoService {

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
    ActivityVO getActivityInfoById(long id);

    /**
     * 根据DO获取活动信息列表
     * @param infoDO
     * @param tag
     * @return
     */
    List<ActivityItemVO> listActivityInfoByDO(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);

    /**
     * 根据DO搜索活动信息列表
     * @param infoDO
     * @param tag
     * @return
     */
    List<ActivityItemVO> listActivityInfoBySearch(@Param("info") ActivityInfoDO infoDO, @Param("tag") TagOfActivityDO tag);


    /**
     * 根据id删除活动信息
     * @param id
     */
    void deleteActivityInfoById(Long id);
}
