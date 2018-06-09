package com.po;

/*
 * Create by s lion h on 2018/5/9
 */
public class Score {
    private Integer id;
    private String stockid;
    private String date;
    private double score;

    public Score() {
    }

    public Score(String stockid, String date, double score) {
        this.stockid = stockid;
        this.date = date;
        this.score = score;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
