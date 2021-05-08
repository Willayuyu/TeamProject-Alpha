package com.example.fidledemo;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.BO.TaskInfoBO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.collection.service.CollectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestCollection {
    @Autowired
    CollectionService collectionService;

    /**
     * 测试活动信息收藏页
     */
    @Test
    public void test1() {
        UserDO userDO = new UserDO();
        userDO.setId((long) 2);
        List<ActivityInfoBO> activityInfoBOS = collectionService.listActivityEnshrineByUserDO(userDO);
        System.out.println(activityInfoBOS);
    }

    /**
     * 测试任务委托收藏页
     */
    @Test
    public void test2() {
        UserDO userDO = new UserDO();
        userDO.setId((long) 2);
        List<TaskInfoBO> taskInfoBOS = collectionService.listTaskEnshrineByUserDO(userDO);
        System.out.println(taskInfoBOS);
    }
}
