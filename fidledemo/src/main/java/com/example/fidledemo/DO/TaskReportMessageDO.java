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

    private Long whistleblowerId;

    private Long reportedTaskId;

    private String title;

    private String reason;

    private Integer state;

    //模糊字段(字符串)

    private Boolean titleLike;

    private Boolean reasonLike;

    /**
     * 起始时间（用于发布时间的模糊查询）
     */
    private Date createTimeBegin;

    /**
     * 结束时间（用于发布时间的模糊查询）
     */
    private Date createTimeEnd;

}