package com.stock.dayprice;

import com.dao.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.util.List;

/*
 * Create by s lion h on 2018/7/2
 */
public class DataDemo {
    private static SqlSession session=DBTools.getSession();
    private List<String> stocklist=session.selectList("listStockId");

    public static void main(String[] args) throws ParseException {
        String stock="SH600011";
        DataUrl dataUrl=new DataUrl(stock,"1451577600000","1529596800000");
        String url=dataUrl.getUrl();
        List<DataPo> list=KLineData.getDayKLineObjects(url,stock);



        for (DataPo dataPo:list){
            System.out.println(dataPo.toString());
            session.insert("insertDayKLine",dataPo);
        }
        session.commit();
    }
}
