package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.VO.PersonVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface UserService {

    /**
     * 插入
     * @param user
     */
    void insertUser(UserDO user);

    /**
     * 更新
     * @param user
     */
    void updateUser(UserDO user);

    /**
     * 根据id获取User
     * @param id
     * @return
     */
    PersonVO getUserById(Long id);

    /**
     * 根据DO查询User列表
     * @param user
     * @return
     */
    List<PersonVO> listUserByDO(UserDO user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUserById(Long id);
}
