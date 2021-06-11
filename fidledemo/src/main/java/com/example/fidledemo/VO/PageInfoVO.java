package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 页面信息类
 * @Author: ZSP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoVO {

    private Integer currentPage;

    private Integer totalPage;

    private Integer totalNum;

}
