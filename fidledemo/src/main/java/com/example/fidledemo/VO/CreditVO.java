package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditVO {

    private Integer creditScore;

    private Integer likeNum;

    private Integer dislikeNum;

}
