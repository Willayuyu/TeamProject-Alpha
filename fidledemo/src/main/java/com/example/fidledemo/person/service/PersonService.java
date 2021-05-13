package com.example.fidledemo.person.service;

import com.example.fidledemo.VO.PersonVO;

public interface PersonService {

    PersonVO getInfo(Long id);

    void alterInfo(String username,String qq,String tel,Long id);
}

