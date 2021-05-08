package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.DO.TaskInformationDO;
import com.example.fidledemo.VO.TaskItemVO;
import com.example.fidledemo.VO.TaskVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface TaskInfoService {

    /**
     * 根据id获得任务信息
     * @param id
     * @return
     */
    TaskVO getTaskInfoById(Long id);

    /**
     * 根据DO获得任务信息列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<TaskItemVO> listTaskInfoByDO(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);

    /**
     * 根据DO搜索任务信息列表
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<TaskItemVO> listTaskInfoBySearch(@Param("info") TaskInformationDO infoDO, @Param("tag") TagOfTaskDO tagDO);
}
