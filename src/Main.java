import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> userAccounts = new ArrayList<>();

        storeAccounts(userAccounts);

        Scanner askUser = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your Account Name: "); // ask the user to enter his account name
            String accountName = askUser.nextLine(); // storing the user input account name value

            System.out.println("Enter your Account PIN Number: "); // ask the user to enter his account Pin
            String accountPin = askUser.nextLine(); // storing the user input account Pin value

            checkUserAccount(userAccounts, accountName, accountPin); // check the user account if existing

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

    static void checkUserAccount(ArrayList<ArrayList<String>> userAccounts, String accountName, String accountPin) {

        boolean status = false;

        // loop the user account lists to check if the user input account name and account pin are existing
        for (ArrayList<String> userAccount: userAccounts) {

            if (userAccount.get(0).toLowerCase().equals(accountName.toLowerCase()) && userAccount.get(1).equals(accountPin)) {

                System.out.println("====== Successfully logged in! ======\n");

            } else {

                status = true;

            }

        }

        // if the user account was not found, this will be output, it will return back asking the user account name and account pin
        if (status) {

            System.out.println("====== Wrong credentials! ======"); // print out if the user input wrong account name and pin

        }

    }

}