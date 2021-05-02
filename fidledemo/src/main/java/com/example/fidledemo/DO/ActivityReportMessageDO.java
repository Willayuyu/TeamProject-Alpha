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
public class ActivityReportMessageDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long whistleblowerId;

    private Long reportedActivityId;

    private String title;

    private String reason;

    private Integer state;

    //模糊字段(字符串)
    private Boolean titleLike;

    private Boolean reasonLike;
}