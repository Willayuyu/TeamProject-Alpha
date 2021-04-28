package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WWJ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfoDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long seller_id;

    private String title;

    private BigDecimal price;

    private BigDecimal original_price;

    private String description;

    private Integer category;

    private Integer condition;

    private Integer is_sold;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
    private Boolean titleLike;

    private Boolean priceLike;

    private Boolean descriptionLike;
}
