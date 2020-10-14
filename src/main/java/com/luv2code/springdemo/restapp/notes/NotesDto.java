package com.luv2code.springdemo.restapp.notes;

import java.io.Serializable;

public class NotesDto implements Serializable {
    private static final long serialVersionUID = 3755955776286902927L;
    private String notesid;
    private String userid;
    private String title;
    private String body;

    public String getNotesid() {
        return notesid;
    }

    public void setNotesid(String notesid) {
        this.notesid = notesid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
