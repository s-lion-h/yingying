package com.spider.easymoney;

import com.spider.easymoney.util.EasymoneyMain;

/*
 * Create by s lion h on 2018/6/9
 */
public class EasymoneySpider {
//    最大线程数,虽然大于5之后请求速度跟不上。。。
    private static final int MAX_THREAD=5;

    public static void main(String[] args) {
        EasymoneyMain easymoneyMain=new EasymoneyMain();
        System.out.println("当前线程量："+MAX_THREAD);

        for(int i=1;i<=MAX_THREAD;i++){
            new Thread(easymoneyMain).start();
        }
    }
}
