package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {

    private BigInteger id;

    private String username;

    private String portrait;

    private String qq;

    private String tel;

    private CreditVO credit;
}
