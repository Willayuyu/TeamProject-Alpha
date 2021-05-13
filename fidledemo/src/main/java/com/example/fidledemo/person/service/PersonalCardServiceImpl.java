package com.example.fidledemo.person.service;

import com.example.fidledemo.BO.CreditBO;
import com.example.fidledemo.BO.EvaluationBO;
import com.example.fidledemo.BO.UserBO;
import com.example.fidledemo.DO.CreditDO;
import com.example.fidledemo.DO.GoodsEvaluationDO;
import com.example.fidledemo.DO.TaskEvaluationDO;
import com.example.fidledemo.VO.CreditVO;
import com.example.fidledemo.VO.GoodsEvaluationVO;
import com.example.fidledemo.VO.PersonVO;
import com.example.fidledemo.VO.TaskEvaluationVO;
import com.example.fidledemo.dao.CreditDAO;
import com.example.fidledemo.dao.GoodsEvaluationDAO;
import com.example.fidledemo.dao.TaskEvaluationDAO;
import com.example.fidledemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell
 */
@Service
public class PersonalCardServiceImpl implements PersonalCardService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    CreditDAO creditDAO;
    @Autowired
    GoodsEvaluationDAO goodsEvaluationDAO;
    @Autowired
    TaskEvaluationDAO taskEvaluationDAO;
    @Override
    public PersonVO getCard(Long id) {
        PersonVO personVO = new PersonVO();

        //获取基本信息
        UserBO userBO = userDAO.getUserById(id);
        personVO.setId(userBO.getId());
        personVO.setPortrait(userBO.getPortrait());
        personVO.setQq(userBO.getQq());
        personVO.setUsername(userBO.getUsername());
        personVO.setTel(userBO.getTelephone());

        //获取信誉信息
        CreditVO creditVO = new CreditVO();
        CreditDO creditDO = new CreditDO();
        creditDO.setUserId(id);
        List<CreditBO> list = creditDAO.listCreditByDO(creditDO);

        //如果信誉不存在则赋值空对象
        CreditBO item ;
        if (list != null && list.get(0) != null){
            item = list.get(0);
        }else {
            item = new CreditBO();
        }

        //设置信誉信息
        creditVO.setCreditScore(item.getCreditScore());
        creditVO.setDislikeNum(item.getDislikeNum());
        creditVO.setLikeNum(item.getLikeNum());
        personVO.setCredit(creditVO);
        return personVO;
    }

    @Override
    public List<GoodsEvaluationVO> getGoodsEvaluationByLike(Long id, Integer isLike) {
        List<GoodsEvaluationVO> list1 = new ArrayList<>();

        //查询id查询与该用户相关的评价
        GoodsEvaluationDO goodsEvaluationDO = new GoodsEvaluationDO();
        goodsEvaluationDO.setEvaluatorId(id);
        goodsEvaluationDO.setEvaluation(isLike);
        List<EvaluationBO> list = goodsEvaluationDAO.listGoodsEvaluationByUser(goodsEvaluationDO);

        //将EvaluationBO转化为VO
        for (int i = 0;i < list.size();i++){
            GoodsEvaluationVO item = new GoodsEvaluationVO();

            //转化基础信息
            item.setEvaluation(list.get(i).getEvaluation());
            item.setGoodsId(list.get(i).getInfoId());
            item.setCreateTime(list.get(i).getGmtInfo().getGmtCreate());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String timeString = format.format(item.getCreateTime());
            item.setTimeString(timeString);
            item.setReason(list.get(i).getReason());
            item.setValuatorId(list.get(i).getEvaluatorId());

            //查询评价者头像和用户名如果不存在则传递无
            UserBO userBO = userDAO.getUserById(item.getValuatorId());
            if (userBO.getPortrait() != null && userBO != null) {
                item.setPortrait(userBO.getPortrait());
            }else {
                item.setPortrait("无");
            }
            if (userBO.getUsername() != null && userBO != null) {
                item.setUsername(userBO.getUsername());
            }else {
                item.setUsername("无");
            }

            list1.add(item);
        }
        return list1;
    }

    @Override
    public List<TaskEvaluationVO> getTaskEvaluationByLike(Long id, Integer isLike) {
        List<TaskEvaluationVO> list = new ArrayList<>();

        //查询id查询与该用户相关的评价
        TaskEvaluationDO taskEvaluationDO = new TaskEvaluationDO();
        taskEvaluationDO.setEvaluatorId(id);
        taskEvaluationDO.setEvaluation(isLike);
        List<EvaluationBO> list1 = taskEvaluationDAO.listTaskEvaluationByUser(taskEvaluationDO);

        //将EvaluationBO转化为VO
        for (int i = 0;i < list1.size();i++){
            TaskEvaluationVO item = new TaskEvaluationVO();

            //转化基础信息
            item.setEvaluation(list1.get(i).getEvaluation());
            item.setTaskId(list1.get(i).getInfoId());
            item.setValuatorId(list1.get(i).getEvaluatorId());
            item.setCreateTime(list1.get(i).getGmtInfo().getGmtCreate());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String timeString = format.format(item.getCreateTime());
            item.setTimeString(timeString);
            item.setReason(list1.get(i).getReason());

            //查询评价者头像和用户名如果不存在则传递无
            UserBO userBO = userDAO.getUserById(item.getValuatorId());
            if (userBO.getPortrait() != null && userBO != null) {
                item.setPortrait(userBO.getPortrait());
            }else {
                item.setPortrait("无");
            }
            if (userBO.getUsername() != null && userBO != null) {
                item.setUsername(userBO.getUsername());
            }else {
                item.setUsername("无");
            }

            list.add(item);
        }

        return list;
    }
}

