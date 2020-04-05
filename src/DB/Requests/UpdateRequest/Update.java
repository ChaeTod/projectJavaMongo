package DB.Requests.UpdateRequest;

import DB.Connection.Connector;
import org.bson.Document;

import java.util.Scanner;

public class Update {
    public void updateUser() {
        Scanner in = new Scanner(System.in);
        Connector connector = new Connector();

        connector.getMongoConnector();
        connector.getMongoDatabase();
        connector.getMongoCollection();

        System.out.println("Input the name of the user you want to update: ");
        String name = in.nextLine();

        Document input = new Document();
        input.put("name", name);

        System.out.println("Input new name for the selected user: ");
        String updateName = in.next();
        System.out.println("Input new age for the selected user: ");
        int updateAge = in.nextInt();
        System.out.println("Input new status for the selected user: ");
        String updateStatus = in.next();

        Document updateInfo = new Document("name", updateName).append("age", updateAge).append("status", updateStatus);
        Document select = new Document("$set", updateInfo);
        connector.getMongoCollection().updateOne(input, select);
        connector.getMongoConnector().close();
    }
}
