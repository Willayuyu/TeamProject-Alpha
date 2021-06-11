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
   * 发布者姓名
   */
  protected String pubName;

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
  protected List<TagBO> tagList;

  /**
   * 分类
   */
  protected CategoryBO category;

  /**
   * 操作时间信息
   */
  protected GmtInfo gmtInfo;

  /**
   * 构造方法
   * @param pubId
   * @param title
   * @param description
   * @param tagList
   * @param categoryId
   * @param categoryDesignation
   * @param type
   */
  public BaseInformation(Long pubId, String title, String description, List<TagBO> tagList,
                         Long categoryId, String categoryDesignation, Integer type)
  {
    this.pubId = pubId;
    this.title = title;
    this.description = description;
    this.tagList = tagList;
    this.category = new CategoryBO(categoryId,categoryDesignation,type);
  }
}
