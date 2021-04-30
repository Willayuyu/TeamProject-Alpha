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
public class ActivityItemVO {

    private BigInteger id;

    private String title;

    private String category;

    private Integer collectState;

    private List<ActivityTagVO> tagList;
}
