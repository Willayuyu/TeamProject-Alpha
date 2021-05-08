package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.CreditDO;
import com.example.fidledemo.VO.CreditVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public interface CreditService {

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
    CreditVO getCreditById(Long id);

    /**
     * 根据DO获得用户信誉信息列表
     * @param creditDO
     * @return
     */
    List<CreditVO> listCreditByDO(CreditDO creditDO);

    /**
     * 根据id删除
     * @param id
     */
    void deleteCreditById(Long id);

}
