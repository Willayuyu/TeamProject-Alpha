package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 列表
 * @author 11313
 */
public interface IndexList<T>
{
  /**
   * 添加
   * @param t
   */
  void add(T t);

  /**
   * 根据id删除
   * @param id
   */
  void removeById(Long id);
}
