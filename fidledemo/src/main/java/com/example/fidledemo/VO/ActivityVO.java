package com.example.fidledemo.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityVO {

    private Long id;

    private Long pubId;

    private String title;

    private String address;

    private String description;

    private String category;

    private List<ActivityTagVO> tagList;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer collectState;

    private List<String> picturesLink;

}
