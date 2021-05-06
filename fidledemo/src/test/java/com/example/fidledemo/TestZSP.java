package com.example.fidledemo;

import com.example.fidledemo.DO.*;
import com.example.fidledemo.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestZSP {

    @Autowired
    ActivityReportMessageDAO activityReportMessageDAO;

    @Autowired
    GoodsEvaluationDAO goodsEvaluationDAO;

    @Autowired
    GoodsReportMessageDAO goodsReportMessageDAO;

    @Autowired
    SystemMessageDAO systemMessageDAO;

    @Autowired
    TaskEvaluationDAO taskEvaluationDAO;

    @Autowired
    TaskReportMessageDAO taskReportMessageDAO;

    /**
     * ActivityReportMessage插入
     */
    @Test
    void test1(){
        ActivityReportMessageDO activityReportMessageDO = new ActivityReportMessageDO();
        activityReportMessageDO.setId((long)1);
        activityReportMessageDO.setReason("不好用");
        activityReportMessageDO.setWhistleblowerId((long)1);
        activityReportMessageDO.setReportedActivityId((long)1);
        activityReportMessageDO.setTitle("编译原理投诉");
    }

    /**
     * ActivityReportMessage根据id查找
     */
    @Test
    void test2(){
        System.out.println(activityReportMessageDAO.getActivityReportMessageById((long) 333368522));
    }

    /**
     * ActivityReportMessage更新测试
     */
    @Test
    void test3(){
        ActivityReportMessageDO activityReportMessageDO = new ActivityReportMessageDO();
        activityReportMessageDO.setId(new Long(3));
        activityReportMessageDO.setWhistleblowerId(new Long(6));
        activityReportMessageDO.setReportedActivityId(new Long(7));
        activityReportMessageDO.setTitle("活动举报333333");
        activityReportMessageDO.setReason("不真实not real");
        activityReportMessageDO.setState(-1);
        activityReportMessageDAO.updateActivityReportMessage(activityReportMessageDO);
    }

    /**
     * ActivityReportMessage根据DO查找
     */
    @Test
    void test4(){
        ActivityReportMessageDO activityReportMessageDO = new ActivityReportMessageDO();
        activityReportMessageDO.setWhistleblowerId(new Long(6));
        activityReportMessageDO.setReportedActivityId(new Long(7));
        activityReportMessageDO.setTitleLike(Boolean.TRUE);
        activityReportMessageDO.setReasonLike(Boolean.TRUE);
        activityReportMessageDO.setTitle("活动举报");
        activityReportMessageDO.setReason("不真实");
        activityReportMessageDO.setState(-1);
        System.out.println("***"+activityReportMessageDAO.listActivityReportMessageByDO(activityReportMessageDO));
    }

    /**
     * ActivityReportMessage删除
     */
    @Test
    void test5(){
        activityReportMessageDAO.deleteActivityReportMessageById((long) 3);
    }

    /**
     * GoodsEvaluationDO插入
     */
    @Test
    void test6(){
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
        goodsEvaluationDO.setGoodsId((long) 3);
        goodsEvaluationDO.setEvaluatorId((long) 4);
        goodsEvaluationDO.setEvaluation(0);
        goodsEvaluationDO.setReason("好极了so good");
        goodsEvaluationDAO.insertGoodsEvaluation(goodsEvaluationDO);
    }

    /**
     * GoodsEvaluationDO更新
     */
    @Test
    void test7(){
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
        goodsEvaluationDO.setId((long) 2);
        goodsEvaluationDO.setGoodsId((long) 44);
        goodsEvaluationDO.setEvaluatorId((long) 55);
        goodsEvaluationDO.setEvaluation(0);
        goodsEvaluationDO.setReason("棒极了so good");
        goodsEvaluationDAO.updateGoodsEvaluation(goodsEvaluationDO);
    }

    /**
     * GoodsEvaluationDO根据id查找
     */
    @Test
    void test8(){
        System.out.println(goodsEvaluationDAO.getGoodsEvaluationById((long) 1));
    }

    /**
     * GoodsEvaluationDO 根据DO查找
     */
    @Test
    void test9(){
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
//        goodsEvaluationDO.setId((long) 1);
//        goodsEvaluationDO.setGoodsId((long) 44);
//        goodsEvaluationDO.setEvaluatorId((long) 55);
//        goodsEvaluationDO.setEvaluation(-1);
        goodsEvaluationDO.setReason("so good");
        goodsEvaluationDO.setReasonLike(Boolean.TRUE);
        System.out.println(goodsEvaluationDAO.listGoodsEvaluationByDO(goodsEvaluationDO));
    }

    /**
     * GoodsEvaluationDO删除
     */
    @Test
    void test10(){
        goodsEvaluationDAO.deleteGoodsEvaluationById((long) 1);
    }


    /**
     * GoodsReportMessageDAO插入
     */
    @Test
    void test11(){
        GoodsReportMessageDO goodsReportMessageDO = new GoodsReportMessageDO();
        goodsReportMessageDO.setWhistleblowerId((long) 2);
        goodsReportMessageDO.setReportedGoodsId((long) 3);
        goodsReportMessageDO.setTitle("书籍举报");
        goodsReportMessageDO.setReason("新旧不一");
        goodsReportMessageDO.setState(1);
        goodsReportMessageDAO.insertGoodsReportMessage(goodsReportMessageDO);
    }

    /**
     * GoodsReportMessageDAO更新
     */
    @Test
    void test12(){
        GoodsReportMessageDO goodsReportMessageDO = new GoodsReportMessageDO();
        goodsReportMessageDO.setId((long) 1);
        goodsReportMessageDO.setWhistleblowerId((long) 44);
        goodsReportMessageDO.setReportedGoodsId((long) 55);
        goodsReportMessageDO.setTitle("书籍举报1111");
        goodsReportMessageDO.setReason("新旧不一11111");
        goodsReportMessageDO.setState(0);
        goodsReportMessageDAO.updateGoodsReportMessage(goodsReportMessageDO);
    }

    /**
     * GoodsReportMessageDAO根据id查找
     */
    @Test
    void test13(){
        System.out.println(goodsReportMessageDAO.getGoodsReportMessageById((long) 1));
    }

    /**
     * GoodsReportMessageDAO 根据DO查找
     */
    @Test
    void test14(){
        GoodsReportMessageDO goodsReportMessageDO = new GoodsReportMessageDO();
    /*goodsReportMessageDO.setId((long) 1);
    goodsReportMessageDO.setWhistleblowerId((long) 44);
    goodsReportMessageDO.setReportedGoodsId((long) 55);*/
        goodsReportMessageDO.setTitle("书籍举报");
        goodsReportMessageDO.setReason("新旧不一");
        //goodsReportMessageDO.setState(-1);
        goodsReportMessageDO.setTitleLike(Boolean.TRUE);
        goodsReportMessageDO.setReasonLike(Boolean.TRUE);
        System.out.println(goodsReportMessageDAO.listGoodsReportMessageByDO(goodsReportMessageDO));
    }

    /**
     * GoodsReportMessageDAO删除
     */
    @Test
    void test15(){
        goodsReportMessageDAO.deleteGoodsReportMessageById((long) 1);
    }


    /**
     * SystemMessageDAO插入
     */
    @Test
    void test16(){
        SystemMessageDO systemMessageDO = new SystemMessageDO();
        systemMessageDO.setAccId((long) 2);
        systemMessageDO.setTitle("举报1");
        systemMessageDO.setContent("信息有假");
        systemMessageDO.setLink("www.baidu.com");
        systemMessageDO.setState(-1);
        systemMessageDAO.insertSystemMessage(systemMessageDO);
    }

    /**
     * SystemMessageDAO更新
     */
    @Test
    void test17(){
        SystemMessageDO systemMessageDO = new SystemMessageDO();
        systemMessageDO.setId((long) 1);
        systemMessageDO.setAccId((long) 4);
        systemMessageDO.setTitle("举报14");
        systemMessageDO.setContent("信息有假14");
        systemMessageDO.setLink("www.baidu.com14");
        systemMessageDO.setState(2);
        systemMessageDAO.updateSystemMessage(systemMessageDO);
    }

    /**
     * SystemMessageDAO根据id查找
     */
    @Test
    void test18(){
        System.out.println(systemMessageDAO.getSystemMessageById((long) 3));
    }

    /**
     * SystemMessageDAO 根据DO查找
     */
    @Test
    void test19(){
        SystemMessageDO systemMessageDO = new SystemMessageDO();
    /*systemMessageDO.setId((long) 1);
    systemMessageDO.setAccId((long) 4);*/
        systemMessageDO.setTitle("举报");
        systemMessageDO.setContent("信息有假");
        //systemMessageDO.setLink("www.baidu.com");
        //systemMessageDO.setState(2);
        systemMessageDO.setTitleLike(Boolean.TRUE);
        systemMessageDO.setContentLike(Boolean.TRUE);
        systemMessageDO.setLimit(Boolean.TRUE);
        systemMessageDO.setBegin(0);
        systemMessageDO.setSize(1);
        System.out.println(systemMessageDAO.listSystemMessageByDO(systemMessageDO));
    }

    /**
     * SystemMessageDAO删除
     */
    @Test
    void test20(){
        systemMessageDAO.deleteSystemMessageById((long) 1);
    }


    /**
     * TaskEvaluationDAO插入
     */
    @Test
    void test21(){
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
        taskEvaluationDO.setTaskId((long) 2);
        taskEvaluationDO.setEvaluatorId((long) 3);
        taskEvaluationDO.setEvaluation(1);
        taskEvaluationDO.setReason("薪资很好");
        taskEvaluationDAO.insertTaskEvaluation(taskEvaluationDO);
    }

    /**
     * TaskEvaluationDAO更新
     */
    @Test
    void test22(){
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
        taskEvaluationDO.setId((long) 1);
        taskEvaluationDO.setTaskId((long) 22);
        taskEvaluationDO.setEvaluatorId((long) 33);
        taskEvaluationDO.setEvaluation(-1);
        taskEvaluationDO.setReason("薪资很好11");
        taskEvaluationDAO.updateTaskEvaluation(taskEvaluationDO);
    }

    /**
     * TaskEvaluationDAO根据id查找
     */
    @Test
    void test23(){
        System.out.println(taskEvaluationDAO.getTaskEvaluationById((long) 1));
    }

    /**
     * TaskEvaluationDAO 根据DO查找
     */
    @Test
    void test24(){
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
    /*taskEvaluationDO.setId((long) 1);
    taskEvaluationDO.setTaskId((long) 22);
    taskEvaluationDO.setEvaluatorId((long) 33);
    taskEvaluationDO.setEvaluation(-1);*/
        taskEvaluationDO.setReasonLike(Boolean.TRUE);
        taskEvaluationDO.setReason("薪资很好");
        System.out.println(taskEvaluationDAO.listTaskEvaluationByDO(taskEvaluationDO));
    }

    /**
     * TaskEvaluationDAO删除
     */
    @Test
    void test25(){
        taskEvaluationDAO.deleteTaskEvaluationById((long) 1);
    }


    /**
     * TaskReportMessageDAO插入
     */
    @Test
    void test26(){
        TaskReportMessageDO taskReportMessageDO = new TaskReportMessageDO();
        taskReportMessageDO.setId((long) 1);
        taskReportMessageDO.setWhistleblowerId((long) 2);
        taskReportMessageDO.setReportedTaskId((long) 3);
        taskReportMessageDO.setTitle("任务举报1");
        taskReportMessageDO.setReason("不真实1");
        taskReportMessageDO.setState(1);
        taskReportMessageDAO.insertTaskReportMessage(taskReportMessageDO);
    }

    /**
     * TaskReportMessageDAO更新
     */
    @Test
    void test27(){
        TaskReportMessageDO taskReportMessageDO = new TaskReportMessageDO();
        taskReportMessageDO.setId((long) 1);
        taskReportMessageDO.setWhistleblowerId((long) 22);
        taskReportMessageDO.setReportedTaskId((long) 33);
        taskReportMessageDO.setTitle("任务举报11");
        taskReportMessageDO.setReason("不真实11");
        taskReportMessageDO.setState(0);
        taskReportMessageDAO.updateTaskReportMessage(taskReportMessageDO);
    }

    /**
     * TaskReportMessageDAO根据id查找
     */
    @Test
    void test28(){
        System.out.println(taskReportMessageDAO.getTaskReportMessageById((long) 2));
    }

    /**
     * TaskReportMessageDAO 根据DO查找
     */
    @Test
    void test29(){
        TaskReportMessageDO taskReportMessageDO = new TaskReportMessageDO();
    /*taskReportMessageDO.setId((long) 1);
    taskReportMessageDO.setWhistleblowerId((long) 22);
    taskReportMessageDO.setReportedTaskId((long) 33);*/
        taskReportMessageDO.setTitleLike(Boolean.TRUE);
        taskReportMessageDO.setReasonLike(Boolean.TRUE);
        taskReportMessageDO.setTitle("任务举报");
        taskReportMessageDO.setReason("不真实");
        //taskReportMessageDO.setState(2);
        System.out.println(taskReportMessageDAO.listTaskReportMessageByDO(taskReportMessageDO));
    }

    /**
     * TaskReportMessageDAO删除
     */
    @Test
    void test30(){
        taskReportMessageDAO.deleteTaskReportMessageById((long) 1);
    }

}
