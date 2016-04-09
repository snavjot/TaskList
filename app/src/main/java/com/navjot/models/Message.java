package com.navjot.models;

/**
 * Created by navjot on 9/4/16.
 */
public class Message {
    public static String ID = "Id";
    public static String ADDREDSS = "Address";
    private long id;
    private String address;
    private long person;
    private String body;

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
