package com.example.bottom_navigation.model;

public class Message {
    private int img;
    private String name,titile,gio;

    public Message(int img_1, String s, String s1) {
    }

    public Message(int img, String name, String titile, String gio) {
        this.img = img;
        this.name = name;
        this.titile = titile;
        this.gio = gio;
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

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }
}
