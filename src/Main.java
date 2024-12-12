import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> userAccounts = new ArrayList<>();

        storeAccounts(userAccounts);

        Scanner askUser = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your Account Name: ");
            String accountName = askUser.nextLine();

            System.out.println("Enter your Account PIN Number: ");
            String accountPin = askUser.nextLine();


        }

    }

    static void storeAccounts(ArrayList<ArrayList<String>> userAccounts) {

        ArrayList<String> user1 = new ArrayList<>(); // first user account added
        user1.add("Christian Naira");
        user1.add("1234");
        user1.add("10000");

        ArrayList<String> user2 = new ArrayList<>(); // second user account added
        user2.add("John Doe");
        user2.add("5678");
        user2.add("50000");

        ArrayList<String> user3 = new ArrayList<>(); // third user account added
        user3.add("Pierre Lawrence");
        user3.add("4321");
        user3.add("20000");

        ArrayList<String> user4 = new ArrayList<>(); // fourth user account added
        user4.add("John Smith");
        user4.add("1357");
        user4.add("600");

        ArrayList<String> user5 = new ArrayList<>(); // fifth user account added
        user5.add("Bryan Bes");
        user5.add("2468");
        user5.add("40000");

        userAccounts.add(user1);
        userAccounts.add(user2);
        userAccounts.add(user3);
        userAccounts.add(user4);
        userAccounts.add(user5);

    }

}