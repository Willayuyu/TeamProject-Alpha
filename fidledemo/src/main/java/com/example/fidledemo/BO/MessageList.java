package com.example.fidledemo.BO;

import java.util.List;

/**
 * 消息列表
 * @author 11313
 */
public class MessageList<T extends BaseMessage> implements IndexList<T>
{

  /**
   * 消息列表
   */
  private List<T> messageList;


  /**
   * 增加消息
   * @param t
   */
  @Override
  public void add(T t)
  {
    messageList.add(t);
  }


  /**
   * 根据id删除消息项
   * @param id
   */
  @Override
  public void removeById(Long id)
  {
    //遍历列表
    for (T message:messageList)
    {
      //若id匹配
      if(message.getId().equals(id))
      {
        //从列表中移除
        messageList.remove(message);
        break;
      }
    }
  }

}
