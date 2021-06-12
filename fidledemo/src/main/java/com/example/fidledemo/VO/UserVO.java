package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WWJ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String username;
    private int creditScore;
}
