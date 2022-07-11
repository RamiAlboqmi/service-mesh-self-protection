package com;

import javax.persistence.*;
@Entity
public class Storeservicerequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String userip;



    @Column
    private String date;

    @Column
    private String username;
    @Column
    private String requestid;
    @Column
    private int requestcounttemp;
    @Column
    private int isnew;

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public void setRequestcounttemp(int requestcounttemp) {
        this.requestcounttemp = requestcounttemp;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    public String getUserip() {
        return userip;
    }

    public String getUsername() {
        return username;
    }

    public String getRequestid() {
        return requestid;
    }

    public int getRequestcounttemp() {
        return requestcounttemp;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
