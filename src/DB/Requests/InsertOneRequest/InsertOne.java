package DB.Requests.InsertOneRequest;

import DB.Connection.Connector;

import java.sql.Connection;
import java.util.Scanner;
import org.bson.Document;


public class InsertOne {
    public void insertOne(){
        Scanner in = new Scanner(System.in);

        Connector connector = new Connector();
        connector.getMongoConnector();
        connector.getMongoDatabase();
        connector.getMongoCollection();

        System.out.println("Input the name: ");
        String name = in.nextLine();
        System.out.println("Input the age: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.println("Input the status: ");
        String status = in.nextLine();

        Document inputs = new Document("name", name).append("age", age).append("status", status);
        connector.getMongoCollection().insertOne(inputs);
        connector.getMongoConnector().close();
    }
}
