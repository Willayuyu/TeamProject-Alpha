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

    /**
     *已收藏
     */
    public static final Integer COLLECT=1;

    /**
     *未收藏
     */
    public static final Integer DISCOLLECT=-1;

    private Long id;

    private String title;

    private String category;

    private Integer collectState;

    private List<ActivityTagVO> tagList;

    private String imageLink;

    private PageInfoVO pageInfo;
}
