package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author WWJ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityInfoDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long pubId;

    private String title;

    private String address;

    private Date startTime;

    private Date endTime;

    private Long category;

    private String description;

    //模糊字段(字符串)

    private Boolean titleLike;

    private Boolean addressLike;

    private Boolean descriptionLike;

    /**
     * 起始时间（用于发布时间的模糊查询）
     */
    private Date createTimeBegin;

    /**
     * 结束时间（用于发布时间的模糊查询）
     */
    private Date createTimeEnd;


}
