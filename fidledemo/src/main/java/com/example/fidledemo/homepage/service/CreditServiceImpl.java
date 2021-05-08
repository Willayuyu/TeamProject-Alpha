package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.DO.CreditDO;
import com.example.fidledemo.VO.CreditVO;
import com.example.fidledemo.dao.CreditDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    CreditDAO creditDAO;

    @Override
    public void insertCredit(CreditDO creditDO) {

    }

    @Override
    public void updateCredit(CreditDO creditDO) {

    }

    @Override
    public CreditVO getCreditById(Long id) {
        CreditBO creditBO = creditDAO.getCreditById(id);
        CreditVO creditVO = new CreditVO();
        creditVO.setCreditScore(creditBO.getCreditScore());
        creditVO.setLikeNum(creditBO.getLikeNum());
        creditVO.setDislikeNum(creditBO.getDislikeNum());
        return creditVO;
    }

    @Override
    public List<CreditVO> listCreditByDO(CreditDO creditDO) {
        return null;
    }

    @Override
    public void deleteCreditById(Long id) {

    }
}
