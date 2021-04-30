package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private BigInteger id;

    private BigInteger pubId;

    private String title;

    private Double price;

    private Double originalPrice;

    private String description;

    private String category;

    private List<TaskTag> tagList;

    private List<String> picturesLink;

    private Integer collectState;
}
