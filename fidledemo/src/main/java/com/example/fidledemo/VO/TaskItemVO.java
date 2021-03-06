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
public class TaskItemVO {

    /**
     *已收藏
     */
    public static final Integer COLLECT=1;

    /**
     *未收藏
     */
    public static final Integer DISCOLLECT=-1;

    private Long id;

    private Long pulisherId;

    private Long accepterId;

    private String title;

    private BigDecimal reward;

    private String category;

    private List<TaskTagVO> tagList;

    private Integer collectState;

    private String taskState;

    private PageInfoVO pageInfo;

    private String announcer;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date gmt_create;
}
