# BO  readme

- 分类（category）、标签（tag）、图片（image）没有按照数据库设计分成三种类别的三个类，而是通过**type**字段区分所属类型（活动、二手、任务）

例如

```java
package com.example.fidledemo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类别
 * @author 11313
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBO
{
  //分类

  public static final Integer GOODS=1;

  public static final Integer TASK=2;

  public static final Integer ACTIVITY=3;


  private Long id;

  /**
   * 类别编号
   */
  private Integer categoryId;

  /**
   *  类别名称
   */
  private String categoryDesignation;

  /**
   * 类别分类
   */
  private Integer type;

}

```

- **type**和**category**的区别：**type**指的是活动、二手、任务三种类型的信息；**category**指的是信息的分类（如二手分为服饰、鞋子等等）

- 每个BO里都有转换为DO的方法;包含其他BO集合的BO也写了将集合转换为DO集合的方法