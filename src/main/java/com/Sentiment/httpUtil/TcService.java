package com.Sentiment.httpUtil;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.Calendar;

/*
 * Create by s lion h on 2018/4/28
 */
public class TcService {
    public static final String APPID="1106795729";
    public static final String APPKEY="dEL8Eb0Msg9r78zW";
    public static final String URL = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textpolar";

    //    秒级时间戳
    public String getTime_stamp(){
        String timestamp= Calendar.getInstance().getTimeInMillis()+"";
        timestamp=timestamp.substring(0,timestamp.length()-3);
        return timestamp;
    }
    //    16随机数保证签名不可预测
    public String getNonce_str(){
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands = new char[16];
        String nonce_str="";
        for (int i = 0; i < rands.length; i++)
        {
            int rand = (int) (Math.random() * a.length());
            rands[i] = a.charAt(rand);
            nonce_str=nonce_str+rands[i];
        }
        return nonce_str;
    }
    //    对请求的字符串url编码
    public String getUrlText(String plusItem){
        return URLEncoder.encode(plusItem);
    }
    //    拼接密钥得到签名字符串
    public String getSign_before(String nonce_str,String time_stamp,String text){
        String sign_before="app_id="+APPID+"&nonce_str="+nonce_str+"&text="+getUrlText(text)+"&time_stamp="+time_stamp+"&app_key="+APPKEY;
//        对sign_before摘要
//        String sign= DigestUtils.md5Hex(sign_before).toUpperCase();
        return sign_before;
    }
    //    签名
    public String getSign(String text){
        String nonce_str=getNonce_str();
        String time_stamp=getTime_stamp();
        String urlText=getUrlText(text);
        String sign_before;
        String sign;
        String param;

        sign_before=getSign_before(nonce_str,time_stamp,text);
//        System.out.println("sign_before:"+sign_before);
        sign= DigestUtils.md5Hex(sign_before).toUpperCase();
//        System.out.println("sign:"+sign);

        param="app_id="+APPID+"&time_stamp="+time_stamp+"&nonce_str="+nonce_str+"&sign="+sign+"&text="+urlText;
//        System.out.println("param:"+param);

//        拼接url

        String url=URL+"?"+param;
//        System.out.println(url);
        return url;

    }
}
