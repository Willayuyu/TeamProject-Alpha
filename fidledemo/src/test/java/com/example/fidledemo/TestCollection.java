package com.example.fidledemo;

import com.example.fidledemo.BO.ActivityInfoBO;
import com.example.fidledemo.DO.ActivityInfoDO;
import com.example.fidledemo.DO.TagOfActivityDO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.collection.service.CollectionService;
import com.example.fidledemo.dao.ActivityInfoDAO;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class TestCollection {
    @Autowired
    CollectionService collectionService;
    @Autowired
    ActivityInfoDAO activityInfoDAO;
    @Test
    public void test(){
        UserDO userDO = new UserDO();
        userDO.setId((long)2);
        List<ActivityInfoBO> activityInfoBOS = collectionService.listActivityEnshrineByUserDO(userDO);
        System.out.println(activityInfoBOS);
    }
}
