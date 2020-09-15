package com.appserver.model;

import java.util.Date;

public class Note {

    private String work;

    private String description;

    private Date date;

    public Note(){

    }

    public Note(String work, String description,Date date) {
        this.work=work;
        this.description=description;
        this.date=date;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
