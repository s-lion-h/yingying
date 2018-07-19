package com.stock.tradeday;

import com.dao.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/*
 * Create by s lion h on 2018/7/19
 */
public class CalDemo {
    private static SqlSession session=DBTools.getSession();
    private static List<String> tradeDayList=session.selectList("getTradeDay");

    @Test
    public void dd(){
        String stockId="600000";

        for (String day:tradeDayList){

        }

    }

}
