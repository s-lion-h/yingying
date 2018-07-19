package com.stock.dayprice;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * Create by s lion h on 2018/7/19
 */
public class TimeFormat {
    @Test
    public void test() throws ParseException {
        String time="Tue Jun 12 00:00:00 +0800 2018";
        /*String time="Tue Jun 12 2018";
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss ‘CST’ yyyy");
//        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
        Date date=null;
        date=format.parse(time);
        System.out.println(date);*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date = dateFormat.parse(time);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(date);
        System.out.println(format.format(date));
    }

    public static String timeFormat(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date = simpleDateFormat.parse(time);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date8=format.format(date);
        return date8;
    }
}
