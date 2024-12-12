import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> userAccounts = new ArrayList<>();

        storeAccounts(userAccounts);

        System.out.println(userAccounts);

    }

    static void storeAccounts(ArrayList<ArrayList<String>> userAccounts) {

        ArrayList<String> user1 = new ArrayList<>();
        user1.add("Christian Naira");
        user1.add("1234");
        user1.add("10000");

        userAccounts.add(user1);

    }

}