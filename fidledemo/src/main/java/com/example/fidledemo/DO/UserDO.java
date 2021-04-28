package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZSP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    //查询限制字段
    private Boolean limit;

    private Integer begin;

    private Integer size;

    private Boolean distinct;

    //数据库字段
    private Long id;

    private String username;

    private String tel;

    private String qq;

    private String wechat_account;

    private String portrait;

    private Date gmt_create;

    private Date gmt_modified;

    //模糊字段(字符串)
    private Boolean usernameLike;

    private Boolean qqLike;

    private Boolean telLike;
}
