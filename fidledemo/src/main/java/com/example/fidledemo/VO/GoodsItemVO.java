package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsItemVO {

    private Long id;

    private Long sellerId;

    private Long buyerId;

    private String title;

    private Double price;

    private Double originalPrice;

    private String imageLink;

    private Integer condition;

    private String category;

    private Integer collectState;

    private List<GoodsTagVO> tagList;

}
