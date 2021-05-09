package com.example.fidledemo.dao;

import com.example.fidledemo.BO.TagBO;
import com.example.fidledemo.DO.TagOfActivityDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyf
 */
@Repository
@Mapper
public interface TagOfActivityDAO {

    /**
     * 插入活动标签
     *
     * @param tagOfActivityDO
     */
    void insertTagOfActivity(TagOfActivityDO tagOfActivityDO);

    /**
     * 根据id查找单个活动标签
     *
     * @param id 需要查询的标签的id
     * @return TagBO 返回查询到的标签
     */
    TagBO getTagOfActivity(Long id);

    /**
     * 更新活动标签
     *
     * @param tagOfActivityDO 需要更新的标签
     */
    void updateTagOfActivity(TagOfActivityDO tagOfActivityDO);

    /**
     * 删除活动标签
     *
     * @param id
     */
    void deleteTagOfActivity(Long id);


    /**
     * 根据活动id查找该活动id的所有标签列表
     *
     * @param id 查询的活动信息的id
     * @return 返回该活动的所有标签
     */
    List<TagBO> listTagOfActivity(Long id);

    /**
     * 检查activityTag是否重复
     *
     * @param content
     * @return
     */
    Long checkActivityTag(String content);
}
