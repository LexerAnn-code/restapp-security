package com.luv2code.springdemo.restapp.passwordReset;

public class PasswordRequestModelNew {
    private String token;
    private String passwordtyped;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPasswordtyped() {
        return passwordtyped;
    }

    public void setPasswordtyped(String passwordtyped) {
        this.passwordtyped = passwordtyped;
    }
}
