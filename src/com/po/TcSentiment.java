package com.po;

/*
 * Create by s lion h on 2018/5/1
 */
public class TcSentiment {
    private Integer id;
    private String ret;
    private String msg;
    private String text;
    private Integer polar;
    private double confd;
    private String stockId;

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

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPolar() {
        return polar;
    }

    public void setPolar(Integer polar) {
        this.polar = polar;
    }

    public double getConfd() {
        return confd;
    }

    public void setConfd(double confd) {
        this.confd = confd;
    }

    @Override
    public String toString() {
        return "TcSentiment{" +
                "id=" + id +
                ", ret='" + ret + '\'' +
                ", msg='" + msg + '\'' +
                ", text='" + text + '\'' +
                ", polar=" + polar +
                ", confd=" + confd +
                ", stockId='" + stockId + '\'' +
                '}';
    }
}
