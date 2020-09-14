package com.appserver.model;

public class Note {

    private String work;

    private String description;

    public Note(){

    }

    public Note(String work, String description) {
        this.work=work;
        this.description=description;
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
}
