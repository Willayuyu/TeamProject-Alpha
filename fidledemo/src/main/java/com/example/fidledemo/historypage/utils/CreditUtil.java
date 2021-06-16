package com.example.fidledemo.historypage.utils;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.DO.CreditDO;
import com.example.fidledemo.dao.CreditDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cxx
 */
@Component
public class CreditUtil {
    @Autowired
    CreditDAO creditDAO;

    static final Integer addScore = 1;
    static final Integer decreseScore = 3;

    /**
     * 根据所给的id对该用户进行信用分的加减
     * @param id 需要进行信用分操作的用户id
     * @param flag -1为减分，1为加分
     */
    public void score(Long id,int flag){

        //查找该用户的当前信用分
        Integer currentScore = 0;
        CreditDO creditDO = new CreditDO();
        creditDO.setUserId(id);
        List<CreditBO> list = creditDAO.listCreditByDO(creditDO);
        if (list.size() != 0){
            currentScore = list.get(0).getCreditScore();
            creditDO.setId(list.get(0).getId());

            if (flag == 1){
                //进行加分操作
                creditDO.setCreditScore(currentScore + addScore);
                creditDAO.updateCredit(creditDO);
            }else {
                //减分操作
                creditDO.setCreditScore(currentScore - decreseScore);
                creditDAO.updateCredit(creditDO);
            }
        }
    }

    /**
     * 根据评价是否是好评更新用户的信誉信息
     * @param id 用户id
     * @param flag 是否是好评 1:好评 -1：差评
     */
    public void addLikeOrDislikeNum(Long id,int flag){
        CreditDO creditDO = new CreditDO();
        creditDO.setUserId(id);
        List<CreditBO> list = creditDAO.listCreditByDO(creditDO);
        if (list.size() != 0){
            creditDO.setId(list.get(0).getId());

            if (flag == 1){
                //增加好评数
                creditDO.setLikeNum(list.get(0).getLikeNum() + 1);
                creditDAO.updateCredit(creditDO);
            }else {
                //增加差评数
                creditDO.setDislikeNum(list.get(0).getDislikeNum() + 1);
                creditDAO.updateCredit(creditDO);
            }
        }
    }
}

