package com.example.fidledemo.dao;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.DO.CreditDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信誉DAO
 * @author 11313
 */
@Mapper
@Repository
public interface CreditDAO
{
  /**
   * 插入
   * @param creditDO
   */
  void insertCredit(CreditDO creditDO);

  /**
   * 更新
   * @param creditDO
   */
  void updateCredit(CreditDO creditDO);

  /**
   * 根据id获得用户信誉信息
   * @param id
   * @return
   */
  CreditBO getCreditById(Long id);

  /**
   * 根据DO获得用户信誉信息列表
   * @param creditDO
   * @return
   */
  List<CreditBO> listCreditByDO(CreditDO creditDO);

  /**
   * 根据id删除
   * @param id
   */
  void deleteCreditById(Long id);



}