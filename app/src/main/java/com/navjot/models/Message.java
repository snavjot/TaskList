package com.navjot.models;

import java.util.Date;

/**
 * Created by navjot on 9/4/16.
 */
public class Message {

    public static String ID = "_id";
    public static String ADDREDSS = "address";
    public static String PERSONID = "person";
    public static String DATE = "date";
    public static String SENTDATE = "date_sent";
    public static String BODY = "body";

    private long id;
    private String address;
    private long personId;
    private String body;
    private Date date;
    private Date sentDate;

    /**
     * This function provides the header for the CSV file
     * @return String of column name for csv file
     */
    public static String csvHeader() {
        String csvHeader = "";
        csvHeader = csvHeader + "_id, ";
        csvHeader = csvHeader + "address, ";
        csvHeader = csvHeader + "personId, ";
        csvHeader = csvHeader + "date, ";
        csvHeader = csvHeader + "date_sent, ";
        csvHeader = csvHeader + "body";
        return csvHeader;
    }

    /**
     * This method fetches the values for all the fields of Message Object
     * and creates a string of comma separated values
     * @return String
     */
    public String messageCSV() {
        String csv;
        csv = "" + getId() + ", " + getAddress() + ", " + getPersonId() + ", " + getDate() +
                ", " + getSentDate() + ", " + getBody();
        return csv;

    }

    // Setter Methods
    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void  setDate(long millisec) {
        this.date = new Date(millisec);
    }

    public void setSentDate(long millisec) {
        this.sentDate = new Date(millisec);
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    // Getter Methods

    public long getId() {
        return id;
    }

    public long getPersonId() {
        return this.personId;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBody() {
        return this.body;
    }

    public Date getDate() {
        return this.date;
    }

    public Date getSentDate() {
        return this.sentDate;
    }

}
