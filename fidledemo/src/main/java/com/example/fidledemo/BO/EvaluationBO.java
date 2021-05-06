package com.example.fidledemo.BO;

import com.example.fidledemo.DO.GoodsEvaluationDO;
import com.example.fidledemo.DO.TaskEvaluationDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评价
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationBO
{
  //评价类别

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;



  //评价

  /**
   * 差评
   */
  public static final Integer BAD=-1;

  /**
   * 好评
   */
  public static final Integer GOOD=1;


  //数据字段

  private Long id;

  /**
   * 对应的信息id
   */
  private Long infoId;

  /**
   * 评价者id
   */
  private Long evaluatorId;

  /**
   * 评价理由
   */
  private String reason;

  /**
   * 评价
   */
  private Integer evaluation;

  /**
   * 评价类别
   */
  private Integer type;

  /**
   * 操作时间信息
   */
  private GmtInfo gmtInfo;

  /**
   * 构造方法
   * @param infoId
   * @param evaluatorId
   * @param reason
   * @param evaluation
   * @param type
   */
  public EvaluationBO(Long infoId, Long evaluatorId,
                      String reason, Integer evaluation, Integer type)
  {
    this.infoId = infoId;
    this.evaluatorId = evaluatorId;
    this.reason = reason;
    this.evaluation = evaluation;
    this.type = type;
  }

  /**
   * 获得GoodsEvaluationDO
   * @return
   */
  public GoodsEvaluationDO getGoodsEvaluationDO()
  {
    if (type.equals(GOODS))
    {
      GoodsEvaluationDO goodsEvaluationDO=new GoodsEvaluationDO();
      goodsEvaluationDO.setId(this.id);
      goodsEvaluationDO.setGoodsId(this.infoId);
      goodsEvaluationDO.setEvaluatorId(this.evaluatorId);
      goodsEvaluationDO.setEvaluation(this.evaluation);
      goodsEvaluationDO.setReason(this.reason);
      return goodsEvaluationDO;
    }
    else
    {
      return null;
    }
  }

  /**
   * 获得GoodsEvaluationDO
   * @return
   */
  public TaskEvaluationDO getTaskEvaluationDO()
  {
    if (type.equals(TASK))
    {
      TaskEvaluationDO evaluationDO=new TaskEvaluationDO();
      evaluationDO.setId(this.id);
      evaluationDO.setTaskId(this.infoId);
      evaluationDO.setEvaluatorId(this.evaluatorId);
      evaluationDO.setEvaluation(this.evaluation);
      evaluationDO.setReason(this.reason);
      return evaluationDO;
    }
    else
    {
      return null;
    }
  }
}
