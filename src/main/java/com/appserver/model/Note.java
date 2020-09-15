package com.appserver.model;

import java.util.Date;

public class Note {

    private String work;

    private String description;

    private Date date;

    /**
     * Nota
     */
    public Note(){

    }

    /**
     *
     * @param work Trabajo a realizar
     * @param description Descripcion del trabajo
     * @param date fecha en que se crea la nota
     */
    public Note(String work, String description,Date date) {
        this.work=work;
        this.description=description;
        this.date=date;
    }

    /**
     *
     * @return Nombre del trabajo a ejecutar
     */
    public String getWork() {
        return work;
    }

    /**
     * Actualiza el trabajo a realizar
     * @param work nuevo trabajo
     */
    public void setWork(String work) {
        this.work = work;
    }

    /**
     *
     * @return descripcion del trabajo a realizar
     */
    public String getDescription() {
        return description;
    }

    /**
     * Actualiza la descripcion del trabajo
     * @param description descripcion del trabajo a registrar
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return fecha en que se registro la nota
     */
    public Date getDate() {
        return date;
    }

    /**
     * Actualiza fecha de registro
     * @param date nueva fecha
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
