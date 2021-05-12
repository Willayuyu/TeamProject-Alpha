package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEvaluationVO {

    private Long taskId;

    private Long valuatorId;

    private String portrait;

    private String username;

    private Integer evaluation;

    private String reason;

    private Date createTime;
}
