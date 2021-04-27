## 注解、注释

- @Passtoken：跳过认证（不需要用户权限的接口/不涉及增删改）

- @UserLoginToken：需要认证（需要用户权限的接口）

- 类、属性、方法 用javadoc注释



## 接口

- 获取数据：用request.getParameter("xxx")读取,而不使用@RequestParam;
- 接口格式

```
  @PostMapping("/xxx")
  @UserLoginToken
  public String xss(HttpServletRequest request)
  {

    String input=request.getParameter("input");

    //.............................业务逻辑

    Object data=new Object();
    return JSON.toJSONString(Result.successResult(data));
  }
```

- 返回状态码

- 200：请求成功

  1001：无访问权限

  1002：会话过期

  1003：登录状态异常

  1004：访问资源为空

  1050：服务端错误





## 实体类转换

- BO->VO

  后端返回数据时，根据前端需求，展示对应信息，把底层细节屏蔽

- BO->DO

  业务层完成业务操作，进行数据持久化时，把BO转换为DO

- 转换方法

```java
public class TaskTransform
{
  //BO->VO
  public TaskVO transformBOtoVO(TaskBO taskBO)
  {
    TaskVO taskVO=new TaskVO();
	taskVO.setTitle(taskBO.getTitle());
    //..............

    return taskVO;
  }

  //BO->DO
  public TaskDO transformBOtoDO(TaskBO taskBO)
  {
    TaskDO taskDO=new TaskDO();
	taskDO.setTitle(taskBO.getTitle());
    //..............

    return taskDO;
  }
}
```







## DO

### 写法

```java
package com.example.fidledemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDO
{
  //查询限制字段
  private Boolean limit;
    
  private Integer begin;
    
  private Integer size;  
    

  private Boolean distinct;


  //属性字段
  private Long id;

  private String title;

  private String content;

  private Date createTime;

  private Date endTime;


  //模糊字段(字符串)
  private Boolean titleLike;

  private Boolean contentLike;

}
```





### 用法

- 插入

  ```java
  TaskDO taskDO=new TaskDO(PARAM1,PARAM2.....);
  ```

- 更新

  ```java
  TaskDO taskDO=new TaskDO();
  //set需要更新的字段
  taskDO.setId(123456);
  taskDO.setTitle("title");
  taskDO.setContent("content");
  ```

- 查询

  ```java
  TaskDO taskDO=new TaskDO();
  //set需要查询的字段
  taskDO.setId(123456);
  taskDO.setTitle("title");
  taskDO.setContent("content");
  //set查询限制
  taskDO.setLimit(Boolean.TRUE);
  taskDO.setBegin(0);	//limit起始索引
  taskDO.setSize(10); //limit size 
  taskDO.setDistinct(Boolean.TRUE);
  //set是否模糊查询
  taskDO.setTitleLike(Boolean.TRUE);
  ```



## Mapper

- 查询

  ```xml
  <select id="XXX" parameterType=" " resultMap="">
      SELECT
      <if test="distinct !=NULL AND distinct!=''">DISTINCT</if>
      * FROM `table`
      <where>
          <if test="title !=NULL AND title !=''">
              <if test="titleLike !=NULL AND titleLike !='' ">
                  AND title LIKE #{title}				
              </if>
              <if test="titleLike ==NULL OR titleLike ==''">
              	AND title=#{title}	
              </if>
          </if>
      </where>
      <if test="limit !=NULL AND limit!='' ">limit #{begin},#{size}</if>
  </select>
  ```

  

- 更新

  ```xml
  <update id="XXX" parameterType=" ">
      UPDATE `table`
      <set>
          <if test="title !=NULL AND title !=''">title=#{title},</if>
          <if test="content !=NULL AND content !='' ">content=#{content},</if>
      </set>
      WHERE id=#{id}
  </select>
  ```

  



## 分工、分包、计划

### 计划：

- 五一前：DO、VO、BO、转换类

- 五一期间：大家玩吧！！！！！！！！！！！！！！！！！！！！！！！！！！！！查缺补漏
- 5.6——5.11：基础功能
  - 5.6——5.8：dao层、mapper
  - 5.9——5.11：业务、接口

- 5.12——5.14：交互、统一测试



每个阶段做完统一测试一遍！！！！！



每天push一次！！！！



### 提交日志：

（简述：修改了啥、增加了啥）——名字+学号

