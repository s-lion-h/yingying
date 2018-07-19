package com.stock;

import com.yilihjy.savesinastockdata.HistoryData;

/*
 * Create by s lion h on 2018/7/2
 */
public class PriceDemo {
    public static void main(String[] args) {
//        System.out.println(DataPo.get1DKlineData("603259"));
        System.out.println(HistoryData.get1WKlineData("600011"));
    }
}
