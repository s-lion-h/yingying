package com.spider.easymoney.util;

/*
 * Create by s lion h on 2018/4/26
 */
public class CommentUrl {
    private final String URLSTART="http://guba.eastmoney.com/list,";
    private final String URLEND=".html";
    /*
        * http://guba.eastmoney.com/list,002344_1.html
        * http://guba.eastmoney.com/list,002344_2.html
        * 股票代码+",f_page"
        * 按发帖时间排序
        */
    private String stockId;
    private Integer page;
    private String url;

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getUrl() {
        return URLSTART+stockId+",f_"+page+URLEND;
    }
}
