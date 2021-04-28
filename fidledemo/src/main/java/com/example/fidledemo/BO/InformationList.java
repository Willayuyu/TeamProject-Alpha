package com.example.fidledemo.BO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 信息列表
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationList<T extends BaseInformation> implements IndexList<T>
{
  /**
   * 信息列表
   */
  private List<T> infoList;

  /**
   * 增加信息
   * @param t
   */
  @Override
  public void add(T t)
  {
    infoList.add(t);
  }


  /**
   * 根据id删除信息项
   * @param id
   */
  @Override
  public void removeById(Long id)
  {
    //遍历列表
      for (T info:infoList)
    {
      //若id匹配
      if(info.getId().equals(id))
      {
        //从列表中移除
        infoList.remove(info);
        break;
      }
    }
  }


}
