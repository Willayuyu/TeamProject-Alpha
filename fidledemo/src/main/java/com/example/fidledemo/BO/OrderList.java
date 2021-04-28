package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 订单项列表
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderList<T extends BaseOrder> implements IndexList<T>
{
  /**
   * 订单列表
   */
  private List<T> orderList;

  /**
   * 增加订单
   * @param t
   */
  @Override
  public void add(T t)
  {
    orderList.add(t);
  }


  /**
   * 根据id删除订单项
   * @param id
   */
  @Override
  public void removeById(Long id)
  {
    //遍历列表
    for (T order : orderList) {
      //若id匹配
      if (order.getId().equals(id)) {
        //从列表中移除
        orderList.remove(order);
        break;
      }
    }
  }
}
