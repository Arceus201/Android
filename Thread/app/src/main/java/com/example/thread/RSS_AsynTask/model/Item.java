package com.example.thread.RSS_AsynTask.model;

public class Item {
    private String title,des,pubdate,link;

    public Item() {
    }

    public Item(String title, String des, String pubdate, String link) {
        this.title = title;
        this.des = des;
        this.pubdate = pubdate;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
