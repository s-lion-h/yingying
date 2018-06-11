package com.spider.easymoney.po;

/*
 * Create by s lion h on 2018/5/6
 */
@Deprecated
public class EasymoneyComment {
    private Integer id;
    private String stockid;
    private int read=0;
    private String text;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EasymoneyComment{" +
                "id=" + id +
                ", stockid='" + stockid + '\'' +
                ", read=" + read +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
