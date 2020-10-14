package com.luv2code.springdemo.restapp.sneakers;

import javax.persistence.*;

@Entity
@Table(name = "sneakers_img")
public class SneakersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_img")
    private String type_img;
    @Column(name = "name")
    private String name;

    @Column(name = "picByte")
    private byte [] picByte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_img() {
        return type_img;
    }

    public void setType_img(String type_img) {
        this.type_img = type_img;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
