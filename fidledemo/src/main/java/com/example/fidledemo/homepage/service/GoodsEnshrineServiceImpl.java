package com.example.fidledemo.homepage.service;

import com.example.fidledemo.DO.GoodsEnshrineDO;
import com.example.fidledemo.dao.GoodsEnshrineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ZSP
 */
@Service
public class GoodsEnshrineServiceImpl implements GoodsEnshrineService{
    @Autowired
    GoodsEnshrineDAO goodsEnshrineDAO;
    @Override
    public void updateGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO) {

    }

    @Override
    public void insertGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO) {
        goodsEnshrineDAO.insertGoodsEnshrine(goodsEnshrineDO);
    }

    @Override
    public void deleteGoodsEnshrine(long id) {

    }

    @Override
    public void deleteGoodsEnshrineByDO(GoodsEnshrineDO goodsEnshrineDO) {
        goodsEnshrineDAO.deleteGoodsEnshrineByDO(goodsEnshrineDO);
    }

    @Override
    public Long getGoodsEnshrine(GoodsEnshrineDO goodsEnshrineDO) {
        return goodsEnshrineDAO.getGoodsEnshrine(goodsEnshrineDO);
    }


}
