package com.jesse.jesseweb.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message {
    private Integer id;
    private String phone;
    private String validationCode;
    private Timestamp createDate;

    public Message(Integer id, String phone, String validationCode, Timestamp createDate) {
        this.id = id;
        this.phone = phone;
        this.validationCode = validationCode;
        this.createDate = createDate;
    }

    public Message(String phone, String validationCode, Timestamp createDate) {
        this.phone = phone;
        this.validationCode = validationCode;
        this.createDate = createDate;
    }

    public Message() {

    }
}
