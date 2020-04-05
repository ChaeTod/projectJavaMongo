package Main;

import DB.Requests.DeleteRequest.Delete;
import DB.Requests.InsertManyRequest.InsertMany;
import DB.Requests.InsertOneRequest.InsertOne;
import DB.Requests.ShowDataBase.showDataBase;
import DB.Requests.UpdateRequest.Update;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        int choice = 0;
        do {
            System.out.println(" ");
            System.out.println("Please, make your choice:");
            System.out.println("1 - Input one into the database");
            System.out.println("2 - Input many into the database");
            System.out.println("3 - Update one");
            System.out.println("4 - Delete one");
            System.out.println("5 - Just show the database");
            System.out.println("0 - Exit");

            try {
                input = in.next();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You have inputted wrong format of a number! Do not use any symbols!");
                choice = 11;
            }

            switch (choice) {
                case 1: {
                    new InsertOne().insertOne();
                    break;
                }
                case 2: {
                    new InsertMany().insertMany();
                    break;
                }
                case 3: {
                    new Update().updateUser();
                    break;
                }
                case 4: {
                    new Delete().deleteUser();
                    break;
                }
                case 5: {
                    new showDataBase().showDataBase();
                    break;
                }
                default: {
                    if (!String.valueOf(choice).matches("[0-5]")) {
                        System.out.println("Please, use only numbers from 0 to 5!");
                    } else {
                        System.out.println("Have a nice day!");
                    }
                    break;
                }
            }
        } while (choice != 0);
    }
}
