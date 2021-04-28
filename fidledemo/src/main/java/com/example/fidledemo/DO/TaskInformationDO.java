package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZSP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskInformationDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long pub_id;

    private Integer task_state;

    private String title;

    private BigDecimal reward;

    private Date start_time;

    private Date end_time;

    private Integer category;

    private String description;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
    private Boolean rewardLike;

    private Boolean titleLike;

    private Boolean start_timeLike;

    private Boolean end_timeLike;

    private Boolean description_timeLike;
}
