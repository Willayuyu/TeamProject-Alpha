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

    private Long sellerId;

    private String title;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private String description;

    private Long category;

    private Integer condition;

    private Integer sold;

    //模糊字段(字符串)

    private Boolean titleLike;

    /**
     * 起始时间（用于发布时间的模糊查询）
     */
    private Date createTimeBegin;

    /**
     * 结束时间（用于发布时间的模糊查询）
     */
    private Date createTimeEnd;

    private Boolean descriptionLike;
}
