package com.example.fidledemo.DAO;

import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户持久层
 * @author 11313
 */
@Mapper
public interface UserDAO
{
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
  UserBO getUserById(Long id);

  /**
   * 根据DO查询User列表
   * @param user
   * @return
   */
  List<UserBO> listUserByDO(UserDO user);

  /**
   * 根据id删除User
   * @param id
   */
  void deleteUserById(Long id);
}