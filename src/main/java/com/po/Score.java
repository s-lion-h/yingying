package com.po;

/*
 * Create by s lion h on 2018/5/9
 */
public class Score {
    private Integer id;
    private String stockid;
    private String date;
    private double postive;
    private double negative;
    private String method;
    private double score;

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

    public double getPostive() {
        return postive;
    }

    public void setPostive(double postive) {
        this.postive = postive;
    }

    public double getNegative() {
        return negative;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", stockid='" + stockid + '\'' +
                ", date='" + date + '\'' +
                ", postive=" + postive +
                ", negative=" + negative +
                ", method='" + method + '\'' +
                ", score=" + score +
                '}';
    }
}
