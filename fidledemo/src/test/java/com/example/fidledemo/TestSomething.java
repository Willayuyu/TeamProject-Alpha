package com.example.fidledemo;

import com.example.fidledemo.backHomepage.service.AdminService;
import com.example.fidledemo.reportHandling.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSomething {
    @Autowired
    AdminService adminService;
    @Autowired
    ReportService reportService;
    @Test
    public void mytest(){
    }
    @Test
    public void myTest(){
    }
}
