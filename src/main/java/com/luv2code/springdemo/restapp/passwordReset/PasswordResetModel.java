package com.luv2code.springdemo.restapp.passwordReset;

import com.luv2code.springdemo.restapp.auth.User;

import javax.persistence.*;

@Entity
@Table(name = "passwordreset")
public class PasswordResetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    @Column(name = "token")
    public String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "userid")
    public User user;
}
