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
public class MyActivityVO {

    private Long id;

    private String title;

    private String category;

    private List<ActivityTagVO> tagList;
}
