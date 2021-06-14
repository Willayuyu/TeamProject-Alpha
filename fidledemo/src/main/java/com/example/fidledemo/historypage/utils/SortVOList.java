package com.example.fidledemo.historypage.utils;

import com.example.fidledemo.VO.MyActivityVO;
import com.example.fidledemo.VO.MyGoodsVO;
import com.example.fidledemo.VO.MyTaskVO;

import java.util.Comparator;

public class SortVOList implements Comparator<Object> {


    @Override
    public int compare(Object o1, Object o2) {

        //对二手物品排序
        if (o1 instanceof MyGoodsVO){
            MyGoodsVO m1 = (MyGoodsVO) o1;
            MyGoodsVO m2 = (MyGoodsVO) o2;
            //先按是否评价进行排序，未评价在前，已评价在后
            if (!m1.getIsEvaluated().equals( m2.getIsEvaluated())){
                if (m1.getIsEvaluated() == 0) {
                    return -1;
                }else {
                    return 1;
                }
            }else {
                return (int)(m1.getId()-m2.getId());
            }
        }

        //对任务委托排序
        if (o1 instanceof MyTaskVO){
            MyTaskVO m1 = (MyTaskVO) o1;
            MyTaskVO m2 = (MyTaskVO) o2;
            //计算优先级，优先级从高到低为 进行中 已完成未评价 未接受 已完成已评价
            int state1 = 0;
            int state2 = 0;
            if (m1.getTaskState().equals("进行中")){
                state1 = 1;
            }
            if (m1.getTaskState().equals("已完成") && m1.getIsEvaluated().equals(0)){
                state1 = 2;
            }
            if (m1.getTaskState().equals("未接收")){
                state1 = 3;
            }
            if (m1.getTaskState().equals("已完成") && m1.getIsEvaluated().equals(1)){
                state1 = 4;
            }

            if (m2.getTaskState().equals("进行中")){
                state2 = 1;
            }
            if (m2.getTaskState().equals("已完成") && m2.getIsEvaluated().equals(0)){
                state2 = 2;
            }
            if (m2.getTaskState().equals("未接收")){
                state2 = 3;
            }
            if (m2.getTaskState().equals("已完成") && m2.getIsEvaluated().equals(1)){
                state2 = 4;
            }

            //先按是否评价进行排序，未评价在前，已评价在后
            if (state1 != state2){
                return state1-state2;
            }else {
                return (int)(m1.getId()-m2.getId());
            }

        }

        //活动排序
        if (o1 instanceof MyActivityVO){
            MyActivityVO m1 = (MyActivityVO) o1;
            MyActivityVO m2 = (MyActivityVO) o2;
            //活动按照id进行排序
            return (int)(m1.getId()-m2.getId());
        }
        return 0;
    }
}
