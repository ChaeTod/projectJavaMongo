package DB.Requests.InsertManyRequest;

import DB.Connection.Connector;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertMany {
    public void insertMany(){
        Scanner in = new Scanner(System.in);
        Connector connection = new Connector();

        connection.getMongoDatabase();
        connection.getMongoDatabase();
        connection.getMongoCollection();

        List<Document[]> inputs = new ArrayList<>();

        System.out.println("Input the number of new users: ");
        int number = in.nextInt();
        Document[] newUsers = new Document[number];

        for (int i = 0; i < number; i++){
            System.out.println("Input the name: ");
            String name = in.next();
            in.nextLine();
            System.out.println("Input the age: ");
            int age = in.nextInt();

            System.out.println("Input the status: ");
            String status = in.next();
            newUsers[i] = new Document("name", name).append("age", age).append("status", status);
        }
        connection.getMongoCollection().insertMany(Arrays.asList(newUsers));
    }
}
