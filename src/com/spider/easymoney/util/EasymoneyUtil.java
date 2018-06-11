package com.spider.easymoney.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/*
 * Create by s lion h on 2018/6/9
 */
public class EasymoneyUtil {
    public static final int RETRY_TIME = 10000;


//     传入股票id 即可返回总页数
    public static int getPage(String id) throws IOException {
        String text = null;
        Document doc = Jsoup.connect("http://guba.eastmoney.com/list,"+id+".html").get();
        Elements pager_elements = doc.select("span[data-pager]");
        for(Element e :pager_elements){
            text = e.attr("data-pager");
        }
        //String text = "list,000882_|49912|80|1";
        String[] str = text.split("\\|");
        String totalNum = str[1];
        String OnePage = str[2];
        System.out.println("total:" + totalNum + "    OnePage:" + OnePage);
        int total = Integer.parseInt(totalNum);
        int page = Integer.parseInt(OnePage);
        //除得尽就为 total / 80
        if(total % page * 1.0  == 0){
            return total / page;
        }
        return total / page + 1;
//        return 3;
    }

//    获取帖子标题的a标签，返回该帖子的发布时间
    public static String findDateByATag(String url){
        //判断有的url有/  有的url没有
        //		news,cjpl,765409212.html
        //   	/news,600000,765422514.html
        //		System.out.println("url:" + url);
        if(url.indexOf("/") == -1){
            //没有/
            url = "/" + url;
        }
        int time = 0;
        Document document=null;
        do{
            try {
        //				System.out.println("开始尝试第" +time +"次连接a标签");
                document= Jsoup.connect("http://guba.eastmoney.com"+url).timeout(8000).get();
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("error:"+e.getMessage());
                time++;
                if(time < RETRY_TIME){
                    System.out.println("请求超时，进行第" +time +"次重连a标签连接!!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e2) {
                        continue;
                    }
                }
            }
        }while(time < RETRY_TIME);
        Elements texts=document.select(".zwfbtime");
        //		System.out.println("texts:" + texts.text());
        //发表于 2018-06-08 17:44:31 股吧网页版  截取时间
        //有些网页被删掉
        String date = "";
        if(texts.text().length()>22){
            date = texts.text().substring(4, 23);
        }
        return date;
    }


}
