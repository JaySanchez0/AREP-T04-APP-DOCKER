package com.appserver.services;

import com.appserver.db.Data;
import com.appserver.model.Note;

import java.util.List;

public class NotesService {

    private Data data = new Data();

    public void add(Note note){
        data.add(note);
    }

    public List<Note> getAll() {
        return data.getNotes();
    }
}
