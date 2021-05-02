package com.example.fidledemo.BO;

import com.example.fidledemo.DO.TaskDelegateDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 任务委托项
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDelegateBO extends BaseOrder
{

  /**
   * 任务委托信息
   */
  private TaskInfoBO taskInfo;

  /**
   * 构造方法
   * @param pubId
   * @param accId
   * @param taskInfo
   */
  public TaskDelegateBO(Long pubId, Long accId, TaskInfoBO taskInfo)
  {
    super(pubId, accId);
    this.taskInfo = taskInfo;
  }

  /**
   * TaskDelegateDO
   * @return
   */
  public TaskDelegateDO getTaskDelegateDO()
  {
    TaskDelegateDO delegateDO=new TaskDelegateDO();
    delegateDO.setTaskInfoId(this.taskInfo.getId());
    delegateDO.setPubId(this.pubId);
    delegateDO.setAccId(this.accId);
    delegateDO.setPubEvaluated(this.pubEvaluated);
    delegateDO.setAccEvaluated(this.accEvaluated);
    return delegateDO;
  }


}
