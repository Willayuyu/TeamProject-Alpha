package com.example.fidledemo;

import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.RoleDO;
import com.example.fidledemo.backHomepage.service.AdminService;
import com.example.fidledemo.backLogin.utils.UUIDUtil;
import com.example.fidledemo.dao.RoleDAO;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSomething {
    @Autowired
    AdminService adminService;
    private static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    private static final int HASH_ITERATIONS = 16; // 自定义散列次数
    @Test
    public void mytest(){
        String uuid=UUIDUtil.getUUID();
        System.out.println(uuid);
        SimpleHash simpleHash = new SimpleHash(ALGORITHM_NAME, "123456", ByteSource.Util.bytes(uuid), HASH_ITERATIONS);
        System.out.println(simpleHash.toString());
    }
    @Test
    public void myTest(){
    }
}
