package com.example.fidledemo;

import com.example.fidledemo.DO.TagOfTaskDO;
import com.example.fidledemo.dao.TagOfTaskDAO;
import com.example.fidledemo.publish.service.PublishService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPublish {
    @Autowired
    TagOfTaskDAO tagOfTaskDAO;
    @Autowired
    PublishService publishService;
    @Test
    public void test(){
        System.out.println(publishService.checkTaskTag("hhhhh"));
    }

    @Test
    public void test1(){
        TagOfTaskDO tagOfTaskDO = new TagOfTaskDO();
        tagOfTaskDO.setContent("111111");
        tagOfTaskDAO.insertTagOfTask(tagOfTaskDO);
    }
}
