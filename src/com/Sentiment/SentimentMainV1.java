package com.Sentiment;

import com.dao.mapper.TcSentimentMapper;
import com.dao.util.DBTools;
import com.po.TcSentiment;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/*
 * Create by s lion h on 2018/6/19
 * 1.取stockexample
 * 2.遍历list->stockId
 * 2.1 get->id,comment
 * 2.2 doGet->comment && id,stockId
 * 2.3 JsonObject->完整TcSentiment
 * 2.4 update->confd,polar
 */
public class SentimentMainV1 {
    SqlSession session=DBTools.getSession();
    TcSentimentMapper tcSentimentMapper=session.getMapper(TcSentimentMapper.class);
    private List<String> stocklist=session.selectList("listStockId");

    @Test
    public void gogogo() {
        for (String stockId:stocklist){
            List<TcSentiment> tcSentiments=tcSentimentMapper.listSentimentByIdNum(Integer.parseInt(stockId),0,100);
            for (TcSentiment tcSentiment:tcSentiments){
                tcSentiment.setStockId(stockId);
                System.out.println(tcSentiment.toString());
            }
        }
    }
}
