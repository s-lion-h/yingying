package com.analysis.score;

import com.analysis.calculation.CalculationUtil;
import com.analysis.date.DateService;
import com.analysis.date.DateUtil;
import com.dao.mapper.ScoreMapper;
import com.dao.mapper.StockMapper;
import com.dao.util.DBTools;
import com.po.BdSentiment;
import com.po.Score;
import com.po.Stock;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2018/6/25
 */
public class ScoreService {
    private static SqlSession session=DBTools.getSession();
    private static StockMapper stockMapper=session.getMapper(StockMapper.class);
    private static ScoreMapper scoreMapper=session.getMapper(ScoreMapper.class);

/*
* 1.获取stockexample
* 2.    list 2016->now的时间
* 3.        DateService.listByDate()获取list
* 4.        CalculationUtil.avgStmCfd/avgStmAvg
* 5.        mapper->db
* */
    @Test
    public void listStockExample() throws ParseException {
        List<String> dates=DateUtil.listDateAtoB("2016-01-01","2018-06-22");

        for (Stock stock:stockMapper.listExampleStock()){
            for (String date:dates){
                Score cfdScore=CalculationUtil.avgStmCfd(stock.getStockid(),date);
                if (!Double.isNaN(cfdScore.getPostive())){
                    System.out.println(cfdScore.getStockid()+" "+date+
                            ", score:"+cfdScore.getScore()+
                            " avgStmCfd: " +
                            "positive:"+cfdScore.getPostive()+
                            " negative:"+cfdScore.getNegative());

                    Score avgScore=CalculationUtil.avgStmAvg(stock.getStockid(),date);
                    System.out.println(avgScore.getStockid()+" "+date+
                            ", score:"+avgScore.getScore()+
                            " avgStmAvg: " +
                            "positive:"+avgScore.getPostive()+
                            " negative:"+avgScore.getNegative());
                    //insert db
                    scoreMapper.insertScore(cfdScore);
                    scoreMapper.insertScore(avgScore);
                }
            }
            session.commit();
        }
    }

}
