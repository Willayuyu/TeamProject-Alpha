package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 信息抽象类
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseInformation
{
  protected Long id;

  /**
   * 发布方id
   */
  protected Long pubId;

  /**
   * 标题
   */
  protected String title;

  /**
   * 详细描述
   */
  protected String description;

  /**
   * 标签列表
   */
  protected List<TagBO> tagBOList;

  /**
   * 分类
   */
  protected Integer category;

  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;
}
