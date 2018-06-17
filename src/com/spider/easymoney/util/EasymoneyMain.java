package com.spider.easymoney.util;

import com.dao.mapper.CommentMapper;
import com.dao.util.DBTools;
import com.po.StockComment;
import com.spider.easymoney.util.CommentUrl;
import com.spider.easymoney.util.EasymoneyUtil;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.spider.easymoney.util.EasymoneyUtil.RETRY_TIME;

/*
 * Create by s lion h on 2018/6/9
 */
public class EasymoneyMain implements Runnable{
    SqlSession session=DBTools.getSession();
    private List<String> stocklist=session.selectList("listStockId");

    public void getAllComment(String stockId) throws IOException {
//        获取股票id，爬取该id的text，date录入数据库
        //得到股的text id date
        Document document=null;
        CommentUrl commentUrl=new CommentUrl();
        commentUrl.setStockId(stockId);

        //获取页数
        int page = EasymoneyUtil.getPage(stockId);
        System.out.println("page:" + page);


        for (int i=1;i<=page;i++){
            int time = 0;//记录尝试连接次数
            List<String> dateList=new ArrayList<String>();
            List<String> textList=new ArrayList<String>();
            List<String> aList = new ArrayList<String>();
            commentUrl.setPage(i);
            System.out.println(commentUrl.getUrl());
            do{
                try {
                    document= Jsoup.connect(commentUrl.getUrl()).timeout(5000).get();
                    break;
                } catch (IOException e) {
                    time++;
                    if(time < RETRY_TIME){
                        System.out.println("请求超时，进行第" +time +"次重连!!");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e2) {
                            continue;
                        }
                    }

                }
            }while(time < RETRY_TIME);

            Elements texts=document.select(".articleh span:eq(2)");
            //取a标签
            Elements aTag = document.select(".articleh :eq(2)  a");
            for(Element element : aTag){
                //url过滤
                String url = element.attr("href");
                if(url.indexOf("/")==0 || url.indexOf("n") == 0){
                    aList.add(element.attr("href"));
                }
            }

            //获取date
            for(String url : aList){
                //遍历url
//                dateList.add("2018-04-04");
                dateList.add(EasymoneyUtil.findDateByATag(url));
            }

            //获取text
            for (Element element:texts){
                //text有两类 一类是正常的<span>下<a>有title属性，另一类是<a>没有title属性
                if(!element.select("a").attr("title").equals("")){
                    textList.add(element.select("a").attr("title"));
                } else{
                    textList.add(element.text());
                }
            }

            //	System.out.println("dataSize:" + dateList.size());
            //   System.out.println("textSize:" + textList.size());
            for (int n=0;n<dateList.size();n++){
            //	 System.out.println("dataList:" + dateList.get(n));
                StockComment stockComment=new StockComment();
                stockComment.setDate(dateList.get(n));
                stockComment.setText(textList.get(n));
                stockComment.setStockId(stockId);
//            	  System.out.println(n+" text:"+stockComment.getText()+" date:"+stockComment.getDate());
                try {
//                    完成的stockcomment写入数据库
//                    System.out.println(stockComment.toString());
                    session.insert("addStockComment",stockComment);
//                    session.commit();
//                    session.close();
                } catch (Exception e) {
                    //				 有些text含有编码问题，则跳过:惯性培养，强👍
                    e.printStackTrace();
                    System.out.println("text出错啦!!");
                }

            }
        }
        System.out.println(stockId + "done!!!!!!!!!!!!!!!!!");
    }

    public synchronized String getStockId(){
        String id=stocklist.get(1);
        stocklist.remove(1);
        return id;
    }

    @Override
    public void run() {
        try {
            for(int time=1;time<50;time++){
                if (stocklist!=null){
                    String id=getStockId();
                    System.out.println(Thread.currentThread().getName()+"正在处理 " + id+"（第"+time+"轮）");
                    getAllComment(id);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
