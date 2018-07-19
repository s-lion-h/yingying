package com.analysis.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * Create by s lion h on 2018/6/25
 */
public class DateUtil {
    /*
    * @Param("a","b")
    * @Return("dates")
    * 返回list的从a到b的date-8
    * */
    public static List<String> listDateAtoB(String a, String b) throws ParseException {
//         定义起止日期
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(a);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(b);

        List<String> dates=new ArrayList<String>();
//         定义日期实例
        Calendar dd = Calendar.getInstance();
//         设置日期起始时间
        dd.setTime(start);

//         判断是否到结束日期
        while(dd.getTime().before(end)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String str = sdf.format(dd.getTime());
            System.out.println(str);
            dates.add(str);
//             进行当前日期月份加1
//            dd.add(Calendar.MONTH, 1);
            dd.add(Calendar.DATE, 1);
        }
        return dates;
    }
}
