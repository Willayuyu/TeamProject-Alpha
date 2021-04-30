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
public class GoodsTag {

    private BigInteger id;

    private String content;
}
