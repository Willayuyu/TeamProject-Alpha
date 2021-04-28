package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZSP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskReportMessageDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long whistleblower_id;

    private Long reported_task_id;

    private String title;

    private String reason;

    private Integer state;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
    private Boolean titleLike;

    private Boolean reasonLike;
}