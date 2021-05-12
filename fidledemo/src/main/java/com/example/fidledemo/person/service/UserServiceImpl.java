package com.example.fidledemo.moudle10.service;

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
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;

    @Override
    public PersonVO getInfo(Long id){
        UserBO userBO = userDAO.getUserById(id);
        CreditBO creditBO = userBO.getCredit();
        CreditVO creditVO = new CreditVO(creditBO.getCreditScore(),creditBO.getLikeNum(),creditBO.getDislikeNum());
        PersonVO personVO = new PersonVO(userBO.getId(),userBO.getUsername(),userBO.getPortrait(),userBO.getQq(),userBO.getTelephone(),creditVO);
        personVO.setTel(userBO.getTelephone());
        return  personVO;
    }

    @Override
    public void alterInfo(String username, String qq, String tel, Long id){
        UserBO userBO = new UserBO(null,username,tel,qq,"","",null);
        userBO.setId(id);
        userDAO.updateUser(userBO.getUserDO());
    }
}
