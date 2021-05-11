package com.example.fidledemo.homepage.service;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.UserDO;
import com.example.fidledemo.VO.CreditVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public void insertUser(UserDO user) {

    }

    @Override
    public void updateUser(UserDO user) {

    }

    @Override
    public PersonVO getUserById(Long id) {
        UserBO userBO = userDAO.getUserById(id);
        PersonVO personVO = new PersonVO();
        if (userBO!=null){
            personVO.setId(userBO.getId());
            personVO.setUsername(userBO.getUsername());
            personVO.setPortrait(userBO.getPortrait());
            personVO.setQq(userBO.getQq());
            personVO.setTel(userBO.getTelephone());
            CreditBO creditBO = userBO.getCredit();

            CreditVO creditVO = new CreditVO();
            if(creditBO!=null){
                creditVO.setCreditScore(creditBO.getCreditScore());
                creditVO.setLikeNum(creditBO.getLikeNum());
                creditVO.setDislikeNum(creditBO.getDislikeNum());
            }

            personVO.setCredit(creditVO);
        }

        return personVO;
    }

    @Override
    public List<PersonVO> listUserByDO(UserDO user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
