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
public class Activity {

    private BigInteger id;

    private BigInteger pubId;

    private String title;

    private String description;

    private String category;

    private List<ActivityTag> tagList;

    private Date startTime;

    private Date endTime;

    private Integer collectState;

    private List<String> picturesLink;

}
