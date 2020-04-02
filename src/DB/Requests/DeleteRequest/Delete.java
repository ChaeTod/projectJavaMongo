package DB.Requests.DeleteRequest;

import DB.Connection.Connector;
import org.bson.Document;

import java.util.Scanner;

public class Delete {
    public void deleteUser(){
        Scanner in = new Scanner(System.in);
        Connector connector = new Connector();

        connector.getMongoConnector();
        connector.getMongoDatabase();
        connector.getMongoCollection();

        System.out.println("Input the name of the user you want to delete: ");
        String name = in.nextLine();

        Document input = new Document();
        input.put("name", name);

        connector.getMongoCollection().deleteOne(input);
        connector.getMongoConnector().close();
    }
}
