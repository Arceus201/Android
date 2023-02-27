package com.example.th1.model;

public class CongViec {
    private  int img;
    private String name,des,date;

    public CongViec(){

    }

    public CongViec(int img, String name, String des, String date) {
        this.img = img;
        this.name = name;
        this.des = des;
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
