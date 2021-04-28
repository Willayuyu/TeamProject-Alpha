package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信誉DO
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditBO
{
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 信誉分
   */
  private Integer creditScore;

  /**
   * 点赞数
   */
  private Integer likeNum;

  /**
   * 点踩数
   */
  private Integer dislikeNum;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;
}
