package com.appserver.services;

import com.appserver.db.Data;
import com.appserver.model.Note;

import java.util.List;

public class NotesService {

    private Data data = new Data();

    /**
     * Registra una nueva nota
     * @param note nota a registrar
     */
    public void add(Note note){
        data.add(note);
    }

    /**
     *
     * @return Todas las notas almacenadas en la base de datos.
     */
    public List<Note> getAll() {
        return data.getNotes();
    }
}
