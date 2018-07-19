package com.SentimentBaidu;

import com.SentimentBaidu.aipUtil.BdDoget;
import com.dao.mapper.CommentMapper;
import com.dao.mapper.TcSentimentMapper;
import com.dao.util.DBTools;
import com.po.BdSentiment;
import com.po.StockComment;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2018/6/23
 */
public class BdSentimentMain {
    private static SqlSession session=DBTools.getSession();
    private static CommentMapper commentMapper=session.getMapper(CommentMapper.class);
    private static TcSentimentMapper tcSentimentMapper=session.getMapper(TcSentimentMapper.class);

    public static void main(String[] args) {
//        List<String> stocks=commentMapper.listStockId();
        List<String> stocks=new ArrayList<String>();
        stocks.add("600019");
        stocks.add("600020");
        for (String stockId:stocks){
            System.out.println("begin to use api with "+stockId);
//            List<BdSentiment> sentiments=commentMapper.listBdSentimentLimit(Integer.parseInt(stockId),20200,100000);
            List<BdSentiment> sentiments=commentMapper.listBdSentiment(stockId);
            int times=1;
            for (BdSentiment bdSentiment:sentiments){
//                System.out.println(bdSentiment.toString());
                if (bdSentiment.getText()==null){
                    continue;
                }

                try{

//                调用baidu api
                BdSentiment ret=BdDoget.doGet(bdSentiment.getText());
//                complete bdsentiment
                bdSentiment.setSentiment(ret.getSentiment());
                bdSentiment.setConfidence(ret.getConfidence());
                bdSentiment.setPositive_prob(ret.getPositive_prob());
                bdSentiment.setNegative_prob(ret.getNegative_prob());
                bdSentiment.setStockId(stockId);

//                System.out.println(bdSentiment.toString());
                tcSentimentMapper.updateBdSentiment(bdSentiment);
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }


//                session.commit();

                times++;
//                完成200次api commit一次数据
                if(times%200==0){
                    session.commit();
                    System.out.println("commit "+stockId+" with "+times);
                }
            }
            session.commit();
            System.out.println(stockId+"sentiment finish");
        }
    }
}
