package com.example.fidledemo.dao;

import com.example.fidledemo.BO.SystemMessageBO;
import com.example.fidledemo.DO.SystemMessageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZSP
 */
@Mapper
public interface SystemMessageDAO
{
    /**
     * 插入
     * @param systemMessage
     */
    void insertSystemMessage(SystemMessageDO systemMessage);

    /**
     * 删除
     * @param id
     */
    void deleteSystemMessageById(Long id);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SystemMessageBO getSystemMessageById(Long id);

    /**
     * 筛选
     * @param systemMessage
     * @return
     */
    List<SystemMessageBO> listSystemMessage(SystemMessageDO systemMessage);

    /**
     * 更新
     * @param systemMessage
     */
    void updateSystemMessage(SystemMessageDO systemMessage);
}
