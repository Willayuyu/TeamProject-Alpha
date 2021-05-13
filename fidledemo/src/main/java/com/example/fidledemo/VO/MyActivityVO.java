package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyActivityVO {

    private Long id;

    private String title;

    private String category;

    private List<ActivityTagVO> tagList;

    private String imageLink;

    private String startTime;

    private String endTime;
}
