package com.example.fidledemo.historypage.service;

import com.example.fidledemo.VO.MyActivityVO;

import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
public interface MyActivityService {

    /**
     * 返回已发布的活动列表
     * @param pageid
     * @param pubId
     * @return
     */
    List<MyActivityVO> listActivityPublished(Integer pageid, Long pubId);

    /**
     * 根据id删除活动
     * @param id
     */
    void deleteActivityById(Long id);

    /**
     * 更新活动信息
     * @param id
     * @param title
     * @param address
     * @param startTime
     * @param endTime
     * @param category
     * @param description
     * @param images
     * @param tags
     */
    void alterActivity(Long id, String title, String address, Date startTime, Date endTime, Long category, String description, String[] images, String[] tags);
}