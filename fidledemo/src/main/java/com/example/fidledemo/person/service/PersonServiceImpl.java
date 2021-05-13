package com.example.fidledemo.person.service;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.VO.CreditVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    UserDAO userDAO;

    @Override
    public PersonVO getInfo(Long id){
        UserBO userBO = userDAO.getUserById(id);

        //如果查无该用户，则返回空值
        if (userBO != null) {
            //如果找不到对应的信誉信息则传空对象
            CreditBO creditBO = new CreditBO();
            if (userBO.getCredit() == null) {
                creditBO.setCreditScore(0);
                creditBO.setDislikeNum(0);
                creditBO.setLikeNum(0);
            } else {
                creditBO = userBO.getCredit();
            }
            CreditVO creditVO = new CreditVO(creditBO.getCreditScore(), creditBO.getLikeNum(), creditBO.getDislikeNum());
            PersonVO personVO = new PersonVO(userBO.getId(), userBO.getUsername(), userBO.getPortrait(), userBO.getQq(), userBO.getTelephone(), creditVO);
            personVO.setTel(userBO.getTelephone());
            return personVO;
        }else {
            return null;
        }
    }

    @Override
    public void alterInfo(String username, String qq, String tel, Long id){
        UserBO userBO = new UserBO(null,username,tel,qq,"","",null);
        userBO.setId(id);
        userDAO.updateUser(userBO.getUserDO());
    }
}

