package com.example.service_android;

import java.io.Serializable;

public class Song implements Serializable {
    private String tiitle;
    private String single;
    private int image;
    private int resource;

    public Song(String tiitle, String single, int image, int resource) {
        this.tiitle = tiitle;
        this.single = single;
        this.image = image;
        this.resource = resource;
    }

    public String getTiitle() {
        return tiitle;
    }

    public void setTiitle(String tiitle) {
        this.tiitle = tiitle;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
