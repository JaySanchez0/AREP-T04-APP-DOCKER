package com.appserver;

import com.appserver.model.Note;
import com.appserver.services.NotesService;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Gson json = new Gson();
        port(getPort());
        NotesService service = new NotesService();
        staticFileLocation("static");
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        get("/note",(req, res)->{
            res.header("Content-Type","application/json");
            return json.toJson(service.getAll());
        });
        post("/note",(rq,rs)->{
            service.add(json.fromJson(rq.body(), Note.class));
            return  "";
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 80;
    }

}
