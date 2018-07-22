package com.stock.dayprice;

import com.dao.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

/*
 * Create by s lion h on 2018/7/2
 */
public class DataDemo {
    private static SqlSession session=DBTools.getSession();
//    获取stockexample的实例股票代码
    private static List<String> stocklist=session.selectList("listStockId");
//    根据sh600000获取交易日信息
    private static List<String> tradeDayList=session.selectList("getTradeDay");

    public static void main(String[] args) throws ParseException {
        for (String stockId:stocklist) {
            String stock="SH000001";
//            String stock="SH"+stockId;
            DataUrl dataUrl=new DataUrl(stock,"1451577600000","1529596800000");
            String url=dataUrl.getUrl();
            List<DataPo> list=KLineData.getDayKLineObjects(url,stock);
            if (list!=null) {
                for (DataPo dataPo : list) {
                    System.out.println(dataPo.toString());
                    session.insert("insertDayKLine", dataPo);
                }
            }
            session.commit();
        }

//        for (String trade:tradeDayList){
//            System.out.println(trade);
//        }
    }


}
