package com.SentimentBaidu;

import com.SentimentBaidu.aipUtil.BdDoget;
import com.po.BdSentiment;
import org.junit.Test;

/*
 * Create by s lion h on 2018/6/24
 */
public class Demo {
    @Test
    public void itd(){
        /*
        * 0，1边界错误
        * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
        * at com.SentimentBaidu.aipUtil.BdDoget.doGet(BdDoget.java:29)
        * at com.SentimentBaidu.BdSentimentMain.main(BdSentimentMain.java:31)
        *
        * fit confidence
        * error:prob can not update
        *
        * ...函数调错了
         */
        BdSentiment testB=BdDoget.doGet("何时");
        System.out.println(testB.toString());

    }
}
