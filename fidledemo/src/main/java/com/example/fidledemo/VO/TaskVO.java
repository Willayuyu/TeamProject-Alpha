package com.example.fidledemo.VO;

import com.alibaba.fastjson.annotation.JSONField;
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

    private BigDecimal reward;

    private String title;

    private String description;

    private String category;

    private List<TaskTagVO> tagList;

    private Integer collectState;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer state;
}
