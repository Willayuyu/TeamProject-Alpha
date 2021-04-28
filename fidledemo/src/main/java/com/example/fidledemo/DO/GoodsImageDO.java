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
public class GoodsImageDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long goods_id;

    private String image_link;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
}
