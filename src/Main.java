import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> userAccounts = new ArrayList<>(); //userAccount Lists
        storeAccounts(userAccounts); // add default user accounts
        Scanner askUser = new Scanner(System.in); // ask the user to enter login credentials

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
        for (ArrayList<String> userAccount : userAccounts) {

            String transactionType = ""; // store the transaction type of user input

            if (userAccount.get(0).toLowerCase().equals(accountName.toLowerCase()) && userAccount.get(1).equals(accountPin)) {
                System.out.println("====== Successfully logged in! ======\n");
                userAccountOptions(userAccount, accountName, accountPin, transactionType); // user selects option
                break;
            } else {
                status = true;
            }
        }

        // if the user account was not found, this will be output, it will return back asking the user account name and account pin
        if (status) {
            System.out.println("====== Wrong credentials! ======"); // print out if the user input wrong account name and pin


        }

    }

    static void userAccountOptions(ArrayList<String> userAccount, String accountName, String accountPin, String transactionType) {

        Scanner askOption = new Scanner(System.in);

        System.out.println("Please select: (Withdraw, Deposit, Balance Inquiry, Log-out)");

        String userOption = ""; // store user input options, either ("withdraw", "deposit", "balance inquiry", "logout")

        while (true) {

            userOption = askOption.nextLine().toLowerCase();

            // if the user input was in the selections
            if (userOption.equals("withdraw") || userOption.equals("deposit") || userOption.equals("balance inquiry") || userOption.equals("logout")) {
                break;
            }

            // if the user input was not in the selection, this will be an output
            System.out.println(userOption + " is not available");

        }

        //  store user input transaction type
        transactionType = userOption;

        double convertAccountBalance = Double.parseDouble(userAccount.get(2)); // converting an account balance string type to double type
        DecimalFormat df = new DecimalFormat("0.00"); // initializing the two zeros (0.00) pattern
        String userAccountBalance = df.format(convertAccountBalance); // adding two zeros (0.00) at the end of a numeric string.

        // identifying the user selection
        switch (userOption) {

            // each transaction type has corresponding method to perform the program functionality

            case "withdraw":
                withdrawMoney(userAccount, accountName, accountPin, transactionType, userAccountBalance);
                break;
            case "deposit":
                depositMoney(userAccount, accountName, accountPin, transactionType, userAccountBalance);
                break;
            case "balance inquiry":
                checkBalance(userAccount, accountName, accountPin, transactionType, userAccountBalance);
                break;
            case "logout":
                System.out.println("User account has been successfully logged out!");
                break;

        }

    }


    static void withdrawMoney(ArrayList<String> userAccount, String accountName, String accountPin, String transactionType, String userAccountBalance) {

        Scanner askAmount = new Scanner(System.in);
        System.out.println("Enter the withdraw Amount: ");

        try {

            double withdrawAmount = askAmount.nextDouble(); // asking the user to input an amount to withdraw
            double accountBalance = Double.parseDouble(userAccount.get(2)); // converting a string type amount to double type amount
            double newAccountBalance = accountBalance - withdrawAmount; // deducting the withdrawal amount from the user account balance

            DecimalFormat df = new DecimalFormat("0.00");
            userAccountBalance = df.format(newAccountBalance);

            if (userAccount.get(2).equals("0.00") || newAccountBalance < 0) {

                System.out.println("Your account balance is not sufficient to withdraw PHP " + df.format(withdrawAmount));
                userAccountOptions(userAccount, accountName, accountPin, transactionType);

            } else {

                userAccount.set(2, userAccountBalance); // changing the account balance to new account balance after the withdrawal process
                String userAccountName = userAccount.get(0);
                invoice(userAccountName, userAccountBalance, transactionType, df.format(withdrawAmount));

                userAccountOptions(userAccount, accountName, accountPin, transactionType);

            }

        } catch (java.util.InputMismatchException e) {

            System.out.println("====== Input must be numeric! (again) ======");
            userAccountOptions(userAccount, accountName, accountPin, transactionType);

        }

    }

    static void depositMoney(ArrayList<String> userAccount, String accountName, String accountPin, String transactionType, String userAccountBalance) {

        Scanner askAmount = new Scanner(System.in);
        System.out.println("Enter the deposit Amount: ");

        try {
            double depositAmount = askAmount.nextDouble();
            double accountBalance = Double.parseDouble(userAccount.get(2));
            double newAccountBalance = accountBalance + depositAmount;

            DecimalFormat df = new DecimalFormat("0.00");
            userAccountBalance = df.format(newAccountBalance);

            if (userAccount.get(2).equals("50000.00") || newAccountBalance > 50000) {
                System.out.println("Your account balance exceeds the maximum capacity of PHP 50000.00");

                userAccountOptions(userAccount, accountName, accountPin, transactionType);
            } else {
                userAccount.set(2, userAccountBalance);

                String userAccountName = userAccount.get(0);

                invoice(userAccountName, userAccountBalance, transactionType, df.format(depositAmount));

                userAccountOptions(userAccount, accountName, accountPin, transactionType);
            }

        } catch (java.util.InputMismatchException e) {

            System.out.println("====== Input must be numeric! (again) ======");
            userAccountOptions(userAccount, accountName, accountPin, transactionType);

        }


    }

    static void checkBalance(ArrayList<String> userAccount, String accountName, String accountPin, String transactionType, String userAccountBalance) {

        String userAccountName = userAccount.get(0);

        String amount;

        invoice(userAccountName, userAccountBalance, transactionType, amount="0.00");

        userAccountOptions(userAccount, accountName, accountPin, transactionType);

    }

    static void invoice(String userAccountName, String userAccountBalance, String transactionType, String amount){

        LocalDateTime transactionDateTime = LocalDateTime.now(); // getting the current date and time

        System.out.println("\n==================== INVOICE ====================");

        System.out.println("Account's holder name: " + userAccountName);
        System.out.println("Transaction type: " + transactionType.toUpperCase());
        System.out.println("Transaction amount: PHP " + amount);
        System.out.println("Your current account balance: PHP " + userAccountBalance);
        System.out.println("Date and time of the transaction: " +
                transactionDateTime.getMonth() + " " +
                transactionDateTime.getDayOfMonth() + ", " +
                transactionDateTime.getYear() + " | " +
                transactionDateTime.getDayOfWeek() + " | " +
                transactionDateTime.getHour() + ":" +
                transactionDateTime.getMinute() + ":" +
                transactionDateTime.getSecond()) ;

        System.out.println("==================== ======= ====================\n");

    }

}

