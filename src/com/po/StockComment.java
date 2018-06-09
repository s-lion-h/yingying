package com.po;

/*
 * Create by s lion h on 2018/5/6
 */
public class StockComment {
    private Integer id;
    private String stockId;
    private int read=0;
    private String text;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
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
        return "StockComment{" +
                "id=" + id +
                ", stockId='" + stockId + '\'' +
                ", read=" + read +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
