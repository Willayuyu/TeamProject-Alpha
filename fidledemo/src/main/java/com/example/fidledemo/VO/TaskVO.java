package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskVO {

    private Long id;

    private Long pubId;

    private BigDecimal reward;

    private String title;

    private String description;

    private String category;

    private List<TaskTagVO> tagList;

    private Integer collectState;

    private Date startTime;

    private Date endTime;

}
