package com.luv2code.springdemo.restapp.dto;

import java.io.Serializable;

public class EmployeeDto  implements Serializable {
    private static final long serialVersionUID = 1851332884629817362L;
    private long id;//From the database
    private String firstname;
    private String lastname;
    private String email;

    public EmployeeDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
