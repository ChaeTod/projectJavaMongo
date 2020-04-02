package DB.Connection;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Connector {

    public MongoClient getMongoConnector() {
        MongoClient mongo = new MongoClient("localhost", 27017); //create a mongo client
        System.out.println("Connected to the database successfully");
        return mongo;
    }

    public MongoDatabase getMongoDatabase(){
        MongoDatabase database = getMongoConnector().getDatabase("company");
        return database;
    }

    public MongoCollection getMongoCollection(){
        MongoCollection<Document> collection = getMongoDatabase().getCollection("users");
        return collection;
    }
}