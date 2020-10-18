package com.luv2code.springdemo.restapp.notes;

import com.luv2code.springdemo.restapp.auth.User;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class NoteEntity {
    @Id
private String notesid;

    private String title;
private String body;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "userid")
private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNotesid() {
        return notesid;
    }

    public void setNotesid(String notesid) {
        this.notesid = notesid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
