package com.example.fidledemo.historypage.service;

import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.BO.TaskDelegateBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.*;
import com.example.fidledemo.VO.MyTaskVO;
import com.example.fidledemo.VO.TaskTagVO;
import com.example.fidledemo.dao.*;
import com.example.fidledemo.historypage.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zyf
 */
@Service
public class MyTaskServiceImpl implements MyTaskService{

    @Autowired
    TaskInfoDAO taskInfoDAO;

    @Autowired
    TaskDelegateDAO taskDelegateDAO;

    @Autowired
    TaskTagDAO taskTagDAO;

    @Autowired
    TagOfTaskDAO tagOfTaskDAO;

    @Autowired
    TaskEvaluationDAO taskEvaluationDAO;
    @Override
    public List<MyTaskVO> listTaskPublished(Integer pageid, Long pubId) {

        //设置任务信息查询DO（插入查询字段pubid，通过发布者id筛选任务信息表）
        TaskInformationDO taskInformationDO = new TaskInformationDO();
        taskInformationDO.setPubId(pubId);
        List<TaskInfoBO> list = taskInfoDAO.listTaskInfoByDO(taskInformationDO,new TagOfTaskDO());
        //分页

        //将查询返回的TaskInfoBO转化为MyTaskVO
        List<MyTaskVO> list2 = new ArrayList<>();
        for (int i = 0;i < list.size();i++){
            MyTaskVO item = new MyTaskVO();

            //转换标签列表
            List<TaskTagVO> list3 = new ArrayList<>();
            for (int j = 0;j < list.get(i).getTagList().size();j++){
                TaskTagVO item2 = new TaskTagVO();
                item2.setId(list.get(i).getTagList().get(j).getId());
                item2.setContent(list.get(i).getTagList().get(j).getContent());
                list3.add(item2);
            }
            item.setTagList(list3);

            //转换其他基础信息
            item.setId(list.get(i).getId());
            item.setCategory(list.get(i).getCategory().getCategoryDesignation());
            item.setState(list.get(i).getState());
            item.setReward(list.get(i).getReward());
            item.setTitle(list.get(i).getTitle());
            item.setPulisherId(pubId);
            list2.add(item);
        }

        //分页
        PageHelper<MyTaskVO> pageHelper = new PageHelper<>(list2,5);
        List<MyTaskVO> myTaskVOS = pageHelper.getPageByNum(pageid);
        return myTaskVOS;
    }

    @Override
    public List<MyTaskVO> listTaskAccepted(Integer pageid, Long accId) {

        //通过接受方ID构建TaskDelegateDO表查询任务订单表
        TaskDelegateDO taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setAccId(accId);
        List<TaskDelegateBO> list = taskDelegateDAO.listTaskDelegateByDO(taskDelegateDO);
        //分页

        //获取订单表中接受方为accid的订单对应的任务信息ID
        List<Long> list2 = new ArrayList<>();
        for (int i = 0;i < list.size();i++){
            Long l = list.get(i).getInfoId();
            list2.add(l);
        }


        //通过id查找任务委托信息
        List<TaskInfoBO> list1 = new ArrayList<>();
        for (int i = 0;i < list2.size();i++){
            TaskInfoBO taskInfoBO = taskInfoDAO.getTaskInfoById(list2.get(i));

            //如果不存在则跳过此条信息
            if (taskInfoBO != null){
                list1.add(taskInfoBO);
            }
        }

        //将TaskInfoBO转换为MyTaskVO
        List<MyTaskVO> list3 = new ArrayList<>();
        for (int i = 0;i < list1.size();i++){
            MyTaskVO item = new MyTaskVO();
            //转换标签
            List<TaskTagVO> list4 = new ArrayList<>();
            for (int j = 0;j < list1.get(i).getTagList().size();j++){
                TaskTagVO item2 = new TaskTagVO();
                item2.setId(list1.get(i).getTagList().get(j).getId());
                item2.setContent(list1.get(i).getTagList().get(j).getContent());
                list4.add(item2);
            }

            //设置其他基础信息
            item.setId(list1.get(i).getId());
            item.setCategory(list1.get(i).getCategory().getCategoryDesignation());
            item.setTagList(list4);
            item.setState(list1.get(i).getState());
            item.setReward(list1.get(i).getReward());
            item.setTitle(list1.get(i).getTitle());
            item.setPulisherId(list1.get(i).getPubId());
            item.setAccepterId(accId);
            list3.add(item);
        }

        //分页
        PageHelper<MyTaskVO> pageHelper = new PageHelper<>(list3,5);
        List<MyTaskVO> myTaskVOS = pageHelper.getPageByNum(pageid);
        return myTaskVOS;
    }

    @Override
    public void conductTask(Long id, Long accId, Long pubId) {
        //增加任务委托项
        TaskDelegateDO taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setTaskInfoId(id);
        taskDelegateDO.setPubId(pubId);
        taskDelegateDO.setAccId(accId);
        taskDelegateDO.setAccEvaluated(0);
        taskDelegateDO.setPubEvaluated(0);
        taskDelegateDAO.insertTaskDelegate(taskDelegateDO);

        //更新任务状态
        TaskInformationDO taskInformationDO = new TaskInformationDO();
        taskInformationDO.setId(id);
        taskInformationDO.setTaskState(2);
        taskInfoDAO.updateTaskInfo(taskInformationDO);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskInfoDAO.deleteTaskInfoById(id);
    }

    @Override
    public void finishTaskById(Long id) {
        TaskInformationDO taskInformationDO = new TaskInformationDO();
        taskInformationDO.setId(id);
        taskInformationDO.setTaskState(3);
        taskInfoDAO.updateTaskInfo(taskInformationDO);
    }

    @Override
    public void cancelTaskById(Long id) {
        //删除相关的任务委托项
        TaskDelegateDO taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setTaskInfoId(id);
        List<TaskDelegateBO> list = taskDelegateDAO.listTaskDelegateByDO(taskDelegateDO);
        Long id2 = list.get(0).getId();
        taskDelegateDAO.deleteTaskDelegateById(id2);

        //更新任务信息状态
        TaskInformationDO taskInformationDO = new TaskInformationDO();
        taskInformationDO.setId(id);
        taskInformationDO.setTaskState(1);
        taskInfoDAO.updateTaskInfo(taskInformationDO);
    }

    @Override
    public void alterTask(Long id, String title, BigDecimal reward, String description, Long category, Date startTime, Date endTime, String[] tags) {
        TaskInformationDO taskInformationDO = new TaskInformationDO();
        taskInformationDO.setCategory(category);
        taskInformationDO.setId(id);
        taskInformationDO.setStartTime(startTime);
        taskInformationDO.setEndTime(endTime);
        taskInformationDO.setTitle(title);
        taskInformationDO.setReward(reward);
        taskInformationDO.setDescription(description);
        taskInfoDAO.updateTaskInfo(taskInformationDO);

        //删除所有标签关系
        taskTagDAO.deleteTaskTagById(id);

        //添加新的标签关系
        for (int i = 0;i < tags.length;i++){
            TagOfTaskDO item = new TagOfTaskDO();
            item.setContent(tags[i]);
            //检查是否存在改标签，没有则增加
            if(tagOfTaskDAO.checkTaskTag(item.getContent()) == null){
                tagOfTaskDAO.insertTagOfTask(item);
            }
            Long tagID =tagOfTaskDAO.checkTaskTag(item.getContent());

            //增加标签与任务委托的对应关系
            TaskTagDO taskTagDO = new TaskTagDO();
            taskTagDO.setTaskId(id);
            taskTagDO.setTagId(tagID);
            taskTagDAO.insertTaskTag(taskTagDO);
        }



    }

    @Override
    public void evaluatePublisher(Long id, Long evaluatorId, Integer evaluation, String reason) {

        //获取订单id
        TaskDelegateDO taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setTaskInfoId(id);
        taskDelegateDO.setAccId(evaluatorId);
        List<TaskDelegateBO> list2 = taskDelegateDAO.listTaskDelegateByDO(taskDelegateDO);
        Long deletgateId = list2.get(0).getId();
        //插入评价
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
        taskEvaluationDO.setEvaluation(evaluation);
        taskEvaluationDO.setEvaluatorId(evaluatorId);
        taskEvaluationDO.setReason(reason);
        taskEvaluationDO.setTaskId(id);
        taskEvaluationDAO.insertTaskEvaluation(taskEvaluationDO);
        //获取评价id
        List<EvaluationBO> list = taskEvaluationDAO.listTaskEvaluationByDO(taskEvaluationDO);
        Long evaluationId = list.get(0).getId();
        //更新订单信息
        taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setId(deletgateId);
        taskDelegateDO.setAccEvaluateId(evaluationId);
        taskDelegateDO.setAccId(evaluatorId);
        taskDelegateDO.setAccEvaluated(1);
        taskDelegateDAO.updateTaskDelegate(taskDelegateDO);
    }

    @Override
    public void evaluateAccepter(Long id, Long evaluatorId, Integer evaluation, String reason) {

        //获取订单id
        TaskDelegateDO taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setTaskInfoId(id);
        taskDelegateDO.setPubId(evaluatorId);
        List<TaskDelegateBO> list2 = taskDelegateDAO.listTaskDelegateByDO(taskDelegateDO);
        Long deletgateId = list2.get(0).getId();
        //插入评价
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
        taskEvaluationDO.setEvaluation(evaluation);
        taskEvaluationDO.setEvaluatorId(evaluatorId);
        taskEvaluationDO.setReason(reason);
        taskEvaluationDO.setTaskId(id);
        taskEvaluationDAO.insertTaskEvaluation(taskEvaluationDO);
        //获取评价id
        List<EvaluationBO> list = taskEvaluationDAO.listTaskEvaluationByDO(taskEvaluationDO);
        Long evaluationId = list.get(0).getId();
        //更新订单信息
        taskDelegateDO = new TaskDelegateDO();
        taskDelegateDO.setId(deletgateId);
        taskDelegateDO.setPubEvaluateId(evaluationId);
        taskDelegateDO.setPubId(evaluatorId);
        taskDelegateDO.setPubEvaluated(1);
        taskDelegateDAO.updateTaskDelegate(taskDelegateDO);
    }
}
