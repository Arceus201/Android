package com.example.androidintent.StartActivityForResult.model;

import java.io.Serializable;

public class Account_1 implements Serializable {
    private  String username,password;

    public Account_1() {
    }

    public Account_1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
