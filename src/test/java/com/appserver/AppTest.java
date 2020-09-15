package com.appserver;


import com.appserver.model.Note;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Inicia el servidor
     */
    @BeforeClass
    public static void startServer(){
        App.main(null);
    }

    /**
     * Verifica que se añada una nota
     * @throws Exception
     */
    @Test
    public void shouldAddAnElement() throws Exception {
        Note[] notes = new Gson().fromJson(Unirest.get("http://localhost:3032/note").asString().getBody().toString(), Note[].class);
        int cont = 0;
        for(Note note:notes){
            if(note.getWork().equals("Study") && note.getDescription().equals("Setup")) cont+=1;
        }
        Unirest.post("http://localhost:3032/note").header("Content-Type","application/json").body("{\"work\":\"Study\",\"description\":\"Setup\"}").asJson().getBody();


        System.out.println(Unirest.get("http://127.0.0.1:3032/note").asString().getBody().toString());
        notes = new Gson().fromJson(Unirest.get("http://localhost:3032/note").asString().getBody().toString(), Note[].class);
        int cont2 = 0;
        for(Note note: notes){
            if(note.getWork().equals("Study") && note.getDescription().equals("Setup")) cont2+=1;
        }
        assertEquals(cont+1,cont2);
    }

    /**
     * Apaga el servidor web
     */
    @AfterClass
    public static void stop(){
        Spark.stop();
    }
}
