package com.example.fidledemo.moudle10.service;

import com.example.fidledemo.VO.PersonVO;

public interface UserService {

    PersonVO getInfo(Long id);

    void alterInfo(String username,String qq,String tel,Long id);
}