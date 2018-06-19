package com.Sentiment.httpUtil;

import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.po.TcSentiment;
import com.alibaba.fastjson.JSON;
//import org.json.JSONObject;
import java.io.IOException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import static com.Sentiment.httpUtil.HttpRequestUtil.HttpRequest;

/*
 * Create by s lion h on 2018/4/29
 */
public class TcDoGet {
//    妈个鸡好气哦 嘤嘤嘤
    public static TcSentiment doGet(String text) throws UnirestException, IOException {
//        获取请求返回值
        TcService ts=new TcService();
        String sign=ts.getSign(text);
        String jsonStr=HttpRequest(sign);

        JSONObject jsonObj= JSON.parseObject(jsonStr);
        JSONObject jsonData= JSON.parseObject(jsonObj.get("data").toString());

//        对象化tcsentiment
        TcSentiment tcs=new TcSentiment();
        tcs.setText(text);
        tcs.setRet(jsonObj.get("ret").toString());
        tcs.setMsg(jsonObj.get("msg").toString());
        tcs.setPolar((Integer) jsonData.get("polar"));
        String confd=jsonData.get("confd").toString();
        tcs.setConfd(Double.valueOf(confd));

        return tcs;
    }

}
