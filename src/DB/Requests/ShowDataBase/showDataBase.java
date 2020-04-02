package DB.Requests.ShowDataBase;

import com.mongodb.client.*;
import org.bson.Document;
import DB.Connection.Connector;

public class showDataBase {
    public final void showDataBase(){  // show all info in collection
        Connector connection = new Connector();
        connection.getMongoConnector();
        connection.getMongoDatabase();

        try (MongoCursor<Document> cursor = connection.getMongoCollection().find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }
}
