package com.example.fidledemo.backHomepage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @Author: ZSP
 */
public class DateUtils {

    public static Date addAndSubtractDaysByCalendar(Date dateTime/*待处理的日期*/, int n/*加减天数*/){

        //日期格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Calendar calstart = java.util.Calendar.getInstance();
        calstart.setTime(dateTime);

        calstart.add(java.util.Calendar.DAY_OF_WEEK, n);

        return calstart.getTime();
    }
}
