package com.example.fidledemo.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 后台任务列表项
 * @Author: ZSP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackTaskItemVO {


    private Long id;

    private Long pulisherId;

    private String title;

    private String category;


    private PageInfoVO pageInfo;

    private String announcer;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date gmt_create;
}
