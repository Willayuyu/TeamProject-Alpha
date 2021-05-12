package com.example.fidledemo.publish.service;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.GoodsInfoBO;
import com.example.fidledemo.BO.ImageBO;
import com.example.fidledemo.BO.TaskInfoBO;

/**
 * @author WWJ
 */
public interface PublishService {
    /**
     * 将TaskInfoBO转换成TaskInformationDO并插入task_information中
     *
     * @param taskInfoBO
     */
    void insertTask(TaskInfoBO taskInfoBO);

    /**
     * 将GoodsInfoBO转换成GoodsInformationDO并插入goods_information中
     *
     * @param goodsInfoBO
     */
    void insertGoods(GoodsInfoBO goodsInfoBO);

    /**
     * 将ActivityInfoBO转换成ActivityInformationDO并插入activity_information中
     *
     * @param activityInfoBO
     */
    void insertActivity(ActivityInfoBO activityInfoBO);

    /**
     * 判断taskTag是否存在
     *
     * @param taskTag
     * @return
     */
    Long checkTaskTag(String taskTag);

    /**
     * 判断goodsTag是否存在
     *
     * @param goodsTag
     * @return
     */
    Long checkGoodsTag(String goodsTag);

    /**
     * 判断activityTag是否存在
     *
     * @param activityTag
     * @return
     */
    Long checkActivityTag(String activityTag);

    /**
     * 将imageBO插入activity_image中
     *
     * @param imageBO
     */
    Long insertImage(ImageBO imageBO);

    /**
     * 根据id删除图片
     *
     * @param imageBO
     * @return
     */
    void deleteImage(ImageBO imageBO);

    /**
     * @param imageBO
     * @return
     */
    Long getImageIdByLink(ImageBO imageBO);

}
