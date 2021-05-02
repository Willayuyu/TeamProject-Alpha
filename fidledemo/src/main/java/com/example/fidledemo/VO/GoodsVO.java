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
public class GoodsVO {

    private Long id;

    private Long pubId;

    private String title;

    private Double price;

    private Double originalPrice;

    private String description;

    private String category;

    private List<TaskTagVO> tagList;

    private List<String> picturesLink;

    private Integer collectState;
}
