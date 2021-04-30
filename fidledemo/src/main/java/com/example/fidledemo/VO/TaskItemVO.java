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
public class TaskItemVO {

    private BigInteger id;

    private BigInteger pulisherId;

    private BigInteger accepterId;

    private String title;

    private Double reward;

    private String category;

    private List<TaskTagVO> categoryList;

    private Integer collectState;

    private String taskState;
}
