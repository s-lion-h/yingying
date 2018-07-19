package com.Sentiment;

import com.Sentiment.httpUtil.TcDoGet;
import com.dao.mapper.CommentMapper;
import com.dao.mapper.TcSentimentMapper;
import com.dao.util.DBTools;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.po.TcSentiment;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
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
    private static SqlSession session=DBTools.getSession();

    private static TcSentimentMapper tcSentimentMapper=session.getMapper(TcSentimentMapper.class);
//    CommentMapper commentMapper=session.getMapper(CommentMapper.class);

    private static List<String> stocklist=session.selectList("listStockId");

    public static void main(String[] args) throws IOException, UnirestException {
        for (String stockId:stocklist){
            System.out.println("beginning packaging "+stockId);
            List<TcSentiment> tcSentiments=tcSentimentMapper.listSentimentByIdNum(Integer.parseInt(stockId),0,160000);
            System.out.println(stockId+"的list封装完成");
            int times=1;
            for (TcSentiment tcSentiment:tcSentiments){
//                封装数据库数据
                tcSentiment.setStockId(stockId);
//                System.out.println(tcSentiment.toString());

//                tcsentiment结果封装
                TcSentiment sentimentEntity=TcDoGet.doGet(tcSentiment.getText());
                tcSentiment.setPolar(sentimentEntity.getPolar());
                tcSentiment.setConfd(sentimentEntity.getConfd());

//                update confd polar到db
                try{
//                    commentMapper.updateSentiment(tcSentiment);
                    tcSentimentMapper.updateSentiment(tcSentiment);
//                    session.commit();
                }catch (Exception e){
                    System.out.println("update失败，network error");
                    e.printStackTrace();
                }

//                System.out.println(tcSentiment.toString());
                times++;
                if (times%200==0){
                    System.out.println("抽插update"+times);
                    session.commit();
                }
            }
//            end commit
            session.commit();
            System.out.println(stockId+"sentiment finish");
        }
    }
}
