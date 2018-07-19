package com.po;

/*
 * Create by s lion h on 2018/6/23
 */
public class BdSentiment {
    private Integer id;
    private String date;
    private String text;
    private Integer sentiment;
    private double confidence;
    private double positive_prob;
    private double negative_prob;
    private String stockId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSentiment() {
        return sentiment;
    }

    public void setSentiment(Integer sentiment) {
        this.sentiment = sentiment;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getPositive_prob() {
        return positive_prob;
    }

    public void setPositive_prob(double positive_prob) {
        this.positive_prob = positive_prob;
    }

    public double getNegative_prob() {
        return negative_prob;
    }

    public void setNegative_prob(double negative_prob) {
        this.negative_prob = negative_prob;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return "BdSentiment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", sentiment=" + sentiment +
                ", confidence=" + confidence +
                ", positive_prob=" + positive_prob +
                ", negative_prob=" + negative_prob +
                ", stockId='" + stockId + '\'' +
                '}';
    }
}
