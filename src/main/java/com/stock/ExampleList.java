package com.stock;

import com.dao.mapper.StockMapper;
import com.dao.util.DBTools;
import com.po.Stock;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 * Create by s lion h on 2018/6/23
 */
public class ExampleList {
    private static SqlSession session=DBTools.getSession();
    private static StockMapper stockMapper=session.getMapper(StockMapper.class);

    public static void main(String[] args) {
        List<Stock> stocks=stockMapper.listExampleStock();
//        System.out.println(stocks);

        for (Stock stock:stocks){
            String stockId= stock.getStockid();
            stockMapper.addTable(stockId);
            System.out.println(stockId+"create table finish");
        }
        System.out.println("stock list create table finish");
    }
}
