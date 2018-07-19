package com.analysis;

import com.analysis.calculation.CalculationUtil;
import com.analysis.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;

/*
 * Create by s lion h on 2018/6/25
 */
public class Demo {
    private static final String IDDEMO="600011";
    private static final String DATEDEMO="2018-06-11";
    private static final String DATEA="2018-05-11";
    private static final String DATEB="2018-06-11";

    @Test
    public void calDemo(){
        CalculationUtil.avgStmAvg(IDDEMO,DATEDEMO);
        CalculationUtil.avgStmCfd(IDDEMO,DATEDEMO);
    }
    @Test
    public void dateDemo() throws ParseException {
        DateUtil.listDateAtoB(DATEA,DATEB);
//        for (String date:DateUtil.listDateAtoB(DATEA,DATEB)){
//            System.out.println(date);
//        }
    }
}
