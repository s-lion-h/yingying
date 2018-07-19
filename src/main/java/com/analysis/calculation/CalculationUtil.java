package com.analysis.calculation;

import com.analysis.date.DateService;
import com.po.BdSentiment;
import com.po.Score;

/*
 * Create by s lion h on 2018/6/25
 */
public class CalculationUtil {
    /*
    * @Param("stockId","date")
    * @Return("BdSentiment")
    * 自信度*polar
    * 返回该id某天的平均值
    * */
    public static Score avgStmCfd(String stockId, String date){
        double positiveSum=0;
        double negativeSum=0;

        Score avgScore = new Score();

        int times=0;
        for (BdSentiment bdSentiment:DateService.listByDate(stockId,date)){
            positiveSum=positiveSum+bdSentiment.getConfidence()*bdSentiment.getPositive_prob();
            negativeSum=negativeSum+bdSentiment.getNegative_prob()*bdSentiment.getNegative_prob();
            times++;
        }
        avgScore.setStockid(stockId);
        avgScore.setDate(date);
        avgScore.setPostive(positiveSum/times);
        avgScore.setNegative(negativeSum/times);
        avgScore.setMethod("avgStmCfd");
        avgScore.setScore(avgScore.getPostive()-avgScore.getNegative());

//        System.out.println(avgStm.toString());
        return avgScore;
    }

    /*
     * @Param("stockId","date")
     * @Return("BdSentiment")
     * polar
     * 取均值
     * 返回该id某天的平均值
     * */
    public static Score avgStmAvg(String stockId,String date){
        double positiveSum=0;
        double negativeSum=0;

        Score avgScore = new Score();

        int times=0;
        for (BdSentiment bdSentiment:DateService.listByDate(stockId,date)){
            positiveSum=positiveSum+bdSentiment.getPositive_prob();
            negativeSum=negativeSum+bdSentiment.getNegative_prob();
            times++;
        }
        avgScore.setStockid(stockId);
        avgScore.setDate(date);
        avgScore.setPostive(positiveSum/times);
        avgScore.setNegative(negativeSum/times);
        avgScore.setMethod("avgStmAvg");
        avgScore.setScore(avgScore.getPostive()-avgScore.getNegative());
//        System.out.println(avgStm.toString());
        return avgScore;
    }
}
