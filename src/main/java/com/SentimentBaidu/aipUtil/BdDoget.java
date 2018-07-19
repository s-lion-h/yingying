package com.SentimentBaidu.aipUtil;

import com.baidu.aip.nlp.AipNlp;
import com.po.BdSentiment;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Create by s lion h on 2018/6/23
 */
public class BdDoget {
    //设置APPID/AK/SK
    public static final String APP_ID = "11434167";
    public static final String API_KEY = "tneN93fHGZAAkjwPTZqpK1Mb";
    public static final String SECRET_KEY = "Gb0G23ei2gw0PucxyC5cmHm3zOWcd4rG";
    //初始化百度api
    private static final AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);


    public static BdSentiment doGet(String text){
        BdSentiment bdSentiment=new BdSentiment();

        JSONObject result = client.sentimentClassify(text,null);
//        System.out.println(result);

        if (!result.has("items")){

            return null;
        }
        JSONArray items=result.getJSONArray("items");
//        json封装bdsentiment
        bdSentiment.setText(result.getString("text"));
        bdSentiment.setSentiment((Integer) items.getJSONObject(0).get("sentiment"));
        bdSentiment.setConfidence(Double.valueOf(items.getJSONObject(0).get("confidence").toString()) );
        bdSentiment.setPositive_prob(Double.valueOf(items.getJSONObject(0).get("positive_prob").toString()) );
        bdSentiment.setNegative_prob(Double.valueOf(items.getJSONObject(0).get("negative_prob").toString()) );

        return  bdSentiment;
    }
}
