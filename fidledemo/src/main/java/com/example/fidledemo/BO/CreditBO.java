package com.example.fidledemo.BO;

import com.example.fidledemo.DO.CreditDO;
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

  /**
   * 构造方法
   * @param userId
   * @param creditScore
   * @param likeNum
   * @param dislikeNum
   */
  public CreditBO(Long userId, Integer creditScore, Integer likeNum, Integer dislikeNum)
  {
    this.userId = userId;
    this.creditScore = creditScore;
    this.likeNum = likeNum;
    this.dislikeNum = dislikeNum;
  }

  /**
   * 获得CreditDO
   * @return
   */
  public CreditDO getCreditDO()
  {
    CreditDO creditDO=new CreditDO();
    creditDO.setUserId(this.userId);
    creditDO.setCreditScore(this.creditScore);
    creditDO.setLikeNum(this.likeNum);
    creditDO.setDislikeNum(this.dislikeNum);
    return creditDO;
  }
}
