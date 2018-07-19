package com.Sentiment;

import com.Sentiment.httpUtil.TcDoGet;
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
 */
public class Demo {
    @Test
    public void pageDemo() {
//        分页记录
        SqlSession session=DBTools.getSession();
//        List<TcSentiment> tcSentiments=session.selectList("listSentimentByIdNum");
        TcSentimentMapper tcSentimentMapper=session.getMapper(TcSentimentMapper.class);


//        List<TcSentiment> tcSentiments=tcSentimentMapper.listAllSentimentById("600002");
        List<TcSentiment> tcSentiments=tcSentimentMapper.listSentimentByIdNum(600008,0,1000);
        for (TcSentiment tcSentiment:tcSentiments){
            System.out.println(tcSentiment.toString());
        }
    }
    @Test
    public void jsonDemo() throws IOException, UnirestException {
        TcSentiment tcSentiment=TcDoGet.doGet("难过啊，好惨啊,嘤嘤嘤");
        System.out.println(tcSentiment);
    }
}
