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

    private Long task_info_id;

    private Long pub_id;

    private Long acc_id;

    private Long acc_evaluate_id;

    private Long pub_evaluate_id;

    private Integer is_pub_evaluated;

    private Integer is_acc_evaluated;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
}
