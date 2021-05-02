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
public class GoodsIndentDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private Long goodsId;

    private Long buyerId;

    private Long sellerId;

    private Long buyerEvaluateId;

    private Long sellerEvaluateId;

    private Integer sellerEvaluated;

    private Integer buyerEvaluated;

    //模糊字段(字符串)
}
