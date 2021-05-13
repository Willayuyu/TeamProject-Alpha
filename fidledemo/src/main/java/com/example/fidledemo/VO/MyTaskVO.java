package com.example.fidledemo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zyf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyTaskVO {

    private Long id;

    private Long pulisherId;

    private Long accepterId;

    private String title;

    private BigDecimal reward;

    private String category;

    private List<TaskTagVO> tagList;

    private String taskState;

    public void setState(Integer state){

        if (state.equals(new Integer(-1))) {
            this.setTaskState("已取消");
        } else if (state.equals(new Integer(1))) {
            this.setTaskState("未接收");
        } else if (state.equals(new Integer(2))) {
            this.setTaskState("进行中");
        } else if (state.equals(new Integer(3))) {
            this.setTaskState("已完成");
        }
    }
}
