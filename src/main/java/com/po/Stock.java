package com.po;

/*
 * Create by s lion h on 2018/4/26
 */
public class Stock {
    private String stockid;
    private String stockName;

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public String getStockName() {
        return stockName;
    }


    public void setStockName(String stockName) {

        this.stockName = stockName;
    }
    @Override
    public String toString() {
        return "Stock{" +
                "stockid='" + stockid + '\'' +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
