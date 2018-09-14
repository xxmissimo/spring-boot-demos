package com.issimo.web.bean;

public class Evaluate {
    private Integer id;

    private String msgper;

    private Integer goodsid;

    private String content;

    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgper() {
        return msgper;
    }

    public void setMsgper(String msgper) {
        this.msgper = msgper == null ? null : msgper.trim();
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}