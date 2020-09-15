package com.appserver;

import com.appserver.model.Note;
import com.appserver.services.NotesService;
import com.google.gson.Gson;

import java.util.Date;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    /**
     * Controlador de operaciones
     * @param args
     */
    public static void main( String[] args ) {
        Gson json = new Gson();
        System.out.println(getPort());
        port(getPort());
        NotesService service = new NotesService();
        staticFileLocation("static");
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        get("/note",(req, res)->{
            res.header("Content-Type","application/json");
            return json.toJson(service.getAll());
        });
        post("/note",(rq,rs)->{
            Note note = json.fromJson(rq.body(), Note.class);
            note.setDate(new Date(System.currentTimeMillis()));
            service.add(note);
            return  "";
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3032;
    }

}
