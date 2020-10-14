package com.luv2code.springdemo.restapp.auth;

import java.util.List;

public class UserReq {
private String userName;
private String email;
private String password;


    public UserReq() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
