package com.example.fidledemo.dao;

import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.DO.GoodsInfoDO;
import com.example.fidledemo.DO.TagOfGoodsDO;
import com.example.fidledemo.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 二手物品DAO
 *
 * @author 11313
 */
@Mapper
@Repository
public interface GoodsInfoDAO {
    /**
     * 插入
     *
     * @param infoDO
     */
    void insertGoodsInfo(GoodsInfoDO infoDO);

    /**
     * 更新
     *
     * @param infoDO
     */
    void updateGoodsInfo(GoodsInfoDO infoDO);

    /**
     * 根据id获得二手物品信息
     *
     * @param id
     * @return
     */
    GoodsInfoBO getGoodsInfoById(Long id);

    /**
     * 根据DO查询二手物品列表
     *
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<GoodsInfoBO> listGoodsInfoByDO(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);

    /**
     * 根据DO搜索二手物品列表
     *
     * @param infoDO
     * @param tagDO
     * @return
     */
    List<GoodsInfoBO> listGoodsInfoBySearch(@Param("info") GoodsInfoDO infoDO, @Param("tag") TagOfGoodsDO tagDO);


    /**
     * 根据id删除二手物品
     *
     * @param id
     */
    void deleteGoodsInfoById(Long id);

    /**
     * 根据用户id返回其二手物品收藏夹内容
     *
     * @param userDO
     * @return
     */
    List<GoodsInfoBO> listGoodsEnshrineByUserDO(@Param("user") UserDO userDO);

    /**
     * 返回总二手物品数
     * @return
     */
    int getTotalGoodsNum();

    /**
     * 返回今日新增二手物品数
     * @return
     */
    int getNewGoodsNum();

    /**
     * 根据时间段返回二手物品数量
     * @param begin
     * @param end
     * @return
     */
    int getGoodsNumByTime(@Param("beginTime") Date begin, @Param("endTime")Date end);


}