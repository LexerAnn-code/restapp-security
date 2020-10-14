package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.notes.NoteEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()

public class User implements Serializable {
    private static final long serialVersionUID = 4372108913972509771L;

    public User() {
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

    @Id
    @Column(name = "userid",nullable = false)
    public String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
@Column(nullable = false)
    private String userName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default false")
    private Boolean emailVerificationStatus=false;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)

    private List<NoteEntity> notes;

    public List<NoteEntity> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEntity> notes) {
        this.notes = notes;
    }
}
