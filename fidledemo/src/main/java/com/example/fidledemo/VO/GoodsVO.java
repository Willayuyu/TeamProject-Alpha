package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO {

    /**
     *已收藏
     */
    public static final Integer COLLECT=1;

    /**
     *未收藏
     */
    public static final Integer DISCOLLECT=-1;

    private Long id;

    private Long pubId;

    private String title;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private String description;

    private String category;

    private List<GoodsTagVO> tagList;

    private List<String> picturesLink;

    private Integer collectState;

    private Integer condition;
}
