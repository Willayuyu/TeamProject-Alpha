package com.example.fidledemo.dao;

import com.example.fidledemo.BO.ReportMessageBO;
import com.example.fidledemo.DO.GoodsReportMessageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Mapper
@Repository
public interface GoodsReportMessageDAO {

    /**
     * 插入二手举报信息
     * @param goodsReportMessage
     */
    void insertGoodsReportMessage(GoodsReportMessageDO goodsReportMessage);

    /**
     * 删除
     * @param id
     */
    void deleteGoodsReportMessageById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    ReportMessageBO getGoodsReportMessageById(Long id);

    /**
     * 筛选
     * @param goodsReportMessage
     * @return
     */
    List<ReportMessageBO> listGoodsReportMessageByDO(GoodsReportMessageDO goodsReportMessage);

    /**
     * 更新
     * @param goodsReportMessage
     */
    void updateGoodsReportMessage(GoodsReportMessageDO goodsReportMessage);

}
