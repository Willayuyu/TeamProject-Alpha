package com.example.fidledemo;

import com.example.fidledemo.DO.*;
import com.example.fidledemo.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: WWJ
 */

@SpringBootTest
class TestWWJ {
    
    @Autowired
    AdminDAO adminDAO;


    @Autowired
    GoodsTagDAO goodsTagDAO;

    @Autowired
    ActivityTagDAO activityTagDAO;

    @Autowired
    TaskTagDAO taskTagDAO;

    @Autowired
    GoodsEnshrineDAO goodsEnshrineDAO;

    @Autowired
    TaskEnshrineDAO taskEnshrineDAO;

    @Autowired
    ActivityEnshrineDAO activityEnshrineDAO;



    /**
     * AdminDAO插入
     */
    @Test
    void test1(){
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount("root");
        adminDO.setPassword("123456");
        adminDO.setSalt("654321");
        adminDAO.insertAdmin(adminDO);
    }
    /**
     * AdminDAO更新
     */
    @Test
    void test2(){
        AdminDO adminDO = new AdminDO();
        adminDO.setId((long) 1);
        adminDO.setAccount("root1");
        adminDO.setPassword("1234561");
        adminDO.setSalt("6543211");
        adminDAO.updateAdmin(adminDO);
    }
    /**
     * AdminDAO根据DO查找
     */
    @Test
    void test3(){
        AdminDO adminDO = new AdminDO();
        adminDO.setId((long) 1);
        adminDO.setAccountLike(Boolean.TRUE);
        adminDO.setDistinct(Boolean.TRUE);
        adminDO.setLimit(Boolean.TRUE);
        adminDO.setBegin(0);
        adminDO.setSize(1);
        adminDO.setAccount("root");
        adminDO.setSalt("6543211");
        System.out.println(adminDAO.listAdminByDO(adminDO));
    }

    /**
     * AdminDAO删除
     */
    @Test
    void test4(){
        adminDAO.deleteAdminById(1);
    }

    /**
     * GoodsTagDAO插入
     */
    @Test
    void test5(){
        GoodsTagDO goodsTagDO = new GoodsTagDO();
        goodsTagDO.setGoodsId((long) 1);
        goodsTagDO.setTagId((long) 2);
        goodsTagDAO.insertGoodsTag(goodsTagDO);
    }

    /**
     * GoodsTagDAO更新
     */
    @Test
    void test6(){
        GoodsTagDO goodsTagDO = new GoodsTagDO();
        goodsTagDO.setId((long) 1);
        goodsTagDO.setGoodsId((long) 3);
        goodsTagDO.setTagId((long) 4);
        goodsTagDAO.updateGoodsTag(goodsTagDO);
    }

    /**
     * GoodsTagDAO删除
     */
    @Test
    void test7(){
        goodsTagDAO.deleteGoodsTag(1);
    }


    /**
     * ActivityTagDO插入
     */
    @Test
    void test8(){
        ActivityTagDO activityTagDO = new ActivityTagDO();
        activityTagDO.setActivityId((long) 2);
        activityTagDO.setTagId((long) 1);
        activityTagDAO.insertActivityTag(activityTagDO);
    }

    /**
     * ActivityTagDO更新
     */
    @Test
    void test9(){
        ActivityTagDO activityTagDO = new ActivityTagDO();
        activityTagDO.setActivityId((long) 4);
        activityTagDO.setTagId((long) 3);
        activityTagDO.setId((long) 1);
        activityTagDAO.updateActivityTag(activityTagDO);
    }

    /**
     * ActivityTagDO删除
     */
    @Test
    void test10(){
        activityTagDAO.deleteActivityTag(1);
    }


    /**
     * TaskTagDAO插入
     */
    @Test
    void test11(){
        TaskTagDO taskTagDO = new TaskTagDO();
        taskTagDO.setTagId((long) 1);
        taskTagDO.setTaskId((long) 2);
        taskTagDAO.insertTaskTag(taskTagDO);
    }

    /**
     * TaskTagDAO更新
     */
    @Test
    void test12(){
        TaskTagDO taskTagDO = new TaskTagDO();
        taskTagDO.setId((long) 1);
        taskTagDO.setTagId((long) 3);
        taskTagDO.setTaskId((long) 4);
        taskTagDAO.updateTaskTag(taskTagDO);
    }

    /**
     * TaskTagDAO删除
     */
    @Test
    void test13(){
        taskTagDAO.deleteTaskTag(1);
    }



    /**
     * GoodsEnshrineDAO插入
     */
    @Test
    void test14(){
        GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
        goodsEnshrineDO.setGoodsId((long) 1);
        goodsEnshrineDO.setUserId((long) 2);
        goodsEnshrineDAO.insertGoodsEnshrine(goodsEnshrineDO);
    }

    /**
     * GoodsEnshrineDAO更新
     */
    @Test
    void test15(){
        GoodsEnshrineDO goodsEnshrineDO = new GoodsEnshrineDO();
        goodsEnshrineDO.setId((long) 1);
        goodsEnshrineDO.setGoodsId((long) 3);
        goodsEnshrineDO.setUserId((long) 4);
        goodsEnshrineDAO.updateGoodsEnshrine(goodsEnshrineDO);
    }

    /**
     * GoodsEnshrineDAO删除
     */
    @Test
    void test16(){
        goodsEnshrineDAO.deleteGoodsEnshrine(1);
    }



    /**
     * TaskEnshrineDAO插入
     */
    @Test
    void test17(){
        TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
        taskEnshrineDO.setTaskId((long) 1);
        taskEnshrineDO.setUserId((long) 2);
        taskEnshrineDAO.insertTaskEnshrine(taskEnshrineDO);
    }

    /**
     * TaskEnshrineDAO更新
     */
    @Test
    void test18(){
        TaskEnshrineDO taskEnshrineDO = new TaskEnshrineDO();
        taskEnshrineDO.setId((long) 1);
        taskEnshrineDO.setTaskId((long) 3);
        taskEnshrineDO.setUserId((long) 4);
        taskEnshrineDAO.updateTaskEnshrine(taskEnshrineDO);
    }

    /**
     * TaskEnshrineDAO删除
     */
    @Test
    void test19(){
        taskEnshrineDAO.deleteTaskEnshrine(1);
    }




    /**
     * ActivityEnshrineDAO插入
     */
    @Test
    void test20(){
        ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
        activityEnshrineDO.setActivityId((long) 1);
        activityEnshrineDO.setUserId((long) 2);
        activityEnshrineDAO.insertActivityEnshrine(activityEnshrineDO);
    }

    /**
     * ActivityEnshrineDAO更新
     */
    @Test
    void test21(){
        ActivityEnshrineDO activityEnshrineDO = new ActivityEnshrineDO();
        activityEnshrineDO.setId((long) 1);
        activityEnshrineDO.setActivityId((long) 3);
        activityEnshrineDO.setUserId((long) 4);
        activityEnshrineDAO.updateActivityEnshrine(activityEnshrineDO);
    }

    /**
     * ActivityEnshrineDAO删除
     */
    @Test
    void test22(){
        activityEnshrineDAO.deleteActivityEnshrine(1);
    }
}
