package com.example.fidledemo.collection.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * 分类工具类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper<T>
{
    /**
     * 信息列表
     */
    private List<T> infoList;

    /**
     * 总条数
     */
    private int totalNum;

    /**
     * 单页面页数
     */
    private int paperNum;

    /**
     * 当前页面
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 构造方法
     * @param infoList
     * @param paperNum
     */
    public PageHelper(List<T> infoList, int paperNum)
    {
        this.infoList = infoList;
        this.paperNum = paperNum;
        this.totalNum=infoList.size();
        this.currentPage=0;
        this.totalPage=(totalNum%paperNum)==0?(totalNum/paperNum):(totalNum/paperNum+1);
    }

    /**
     * 根据索引获得列表
     * @param start
     * @param end
     * @return
     */
    public List<T> getListByIndex(int start,int end)
    {
        if(start>=totalNum || end<=0)
        {
            return new LinkedList<>();
        }
        if(end>=totalNum)
        {
            end=totalNum;
        }
        return infoList.subList(start,end);
    }

    /**
     * 获取指定页号的内容
     * @return
     */
    public List<T> getPageByNum(int pageNum)
    {
        currentPage=pageNum;
        return getListByIndex((pageNum-1)*paperNum,pageNum*paperNum);
    }


    /**
     * 获得上一页的内容
     * @return
     */
    public List<T> getPrePage()
    {
        return getListByIndex((currentPage-1)*paperNum,currentPage--*paperNum);
    }

    /**
     * 获得下一页的内容
     * @return
     */
    public List<T> getNextPage()
    {
        return getListByIndex((currentPage-1)*paperNum,currentPage++*paperNum);
    }
}