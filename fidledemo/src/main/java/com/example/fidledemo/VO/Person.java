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
public class Person {

    private BigInteger id;

    private String username;

    private String portrait;

    private String qq;

    private String tel;

    private Credit credit;
}
