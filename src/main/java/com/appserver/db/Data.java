package com.appserver.db;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.appserver.model.Note;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Data {

    private MongoDatabase database;

    private MongoClient mongoClient;


    private AtomicInteger inte = new AtomicInteger(0);

    public Data(){
        ConnectionString connString = new ConnectionString(
                "mongodb://ec2-100-25-103-0.compute-1.amazonaws.com"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("NotesApp");
    }

    public List<Note> getNotes(){
        MongoCollection<Document> collection = database.getCollection("Notes");
        ArrayList<Note> notes = new ArrayList<>();
        for(Document doc : collection.find()){
            Note note = new Note();
            note.setWork(doc.get("work_id").toString());
            note.setDescription(doc.get("description").toString());
            notes.add(note);
        }

        return notes;
    }

    public void add(Note note){
        Document doc = new Document("_id",new ObjectId());
        doc.append("work_id",note.getWork());
        doc.append("description",note.getDescription());
        MongoCollection<Document> collection = database.getCollection("Notes").withWriteConcern(WriteConcern.MAJORITY);
        collection.insertOne(doc);
        System.out.println(collection.count());
    }

}
