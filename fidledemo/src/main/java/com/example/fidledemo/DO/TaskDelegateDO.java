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
public class TaskDelegateDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long taskInfoId;

    private Long pubId;

    private Long accId;

    private Long accEvaluateId;

    private Long pubEvaluateId;

    private Integer pubEvaluated;

    private Integer accEvaluated;

    //模糊字段(字符串)
}
