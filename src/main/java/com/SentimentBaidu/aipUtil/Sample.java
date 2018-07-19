package com.SentimentBaidu.aipUtil;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/*
 * Create by s lion h on 2018/6/23
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "11434167";
    public static final String API_KEY = "tneN93fHGZAAkjwPTZqpK1Mb";
    public static final String SECRET_KEY = "Gb0G23ei2gw0PucxyC5cmHm3zOWcd4rG";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "log4j.properties");

        String text = "吃了几次，超喜欢，味道不错，特别是牛排；当然吃完还不用自己埋单，那简直就是人间美事了。";
//        String[] texts={"苹果是一家伟大的公司","苹果是一家垃圾的公司","苹果是一家坑货的公司"};

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();

        // 情感倾向分析
        JSONObject res = client.sentimentClassify(text, options);
        System.out.println(res.toString(2));
        System.out.println(res.getString("text"));
        JSONArray cfd=res.getJSONArray("items");
        System.out.println(cfd.getJSONObject(0).get("confidence"));

        /*
                {
            "text":"苹果是一家伟大的公司",
            "items":[
                {
                //积极、消极、中性,0,1,2
                    "sentiment":2,    //表示情感极性分类结果
                    "confidence":0.40, //表示分类的置信度
                    "positive_prob":0.73, //表示属于积极类别的概率
                    "negative_prob":0.27  //表示属于消极类别的概率
                }
            ]
        }
         */
    }
}