package com.example.fidledemo.historypage.service;

import com.example.fidledemo.VO.MyTaskVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
public interface MyTaskService {
    /**
     * 查找已发布的任务委托列表
     * @param pageid
     * @param pubId
     * @return
     */
    List<MyTaskVO> listTaskPublished(Integer pageid, Long pubId);

    /**
     * 查找已接受的任务委托列表
     * @param pageid
     * @param accId
     * @return
     */
    List<MyTaskVO> listTaskAccepted(Integer pageid,Long accId);

    /**
     * 进行任务
     * @param id
     * @param accId
     * @param pubId
     */
    void conductTask(Long id,Long accId,Long pubId);

    /**
     * 删除任务
     * @param id
     */
    void deleteTaskById(Long id);

    /**
     * 完成任务
     * @param id
     */
    void finishTaskById(Long id,Long userId);

    /**
     * 取消任务
     * @param id
     */
    void cancelTaskById(Long id);

    /**
     * 修改任务委托信息
     * @param id
     * @param title
     * @param reward
     * @param description
     * @param category
     * @param startTime
     * @param endTime
     * @param tags
     */
    void alterTask(Long id, String title, BigDecimal reward, String description, Long category, Date startTime, Date endTime, String[] tags);

    /**
     * 评价发布者
     * @param id
     * @param evaluatorId
     * @param evaluation
     * @param reason
     */
    void evaluatePublisher(Long id,Long evaluatorId,Integer evaluation,String reason);

    /**
     * 评价接收者
     * @param id
     * @param evaluatorId
     * @param evaluation
     * @param reason
     */
    void evaluateAccepter(Long id,Long evaluatorId,Integer evaluation,String reason);


}
