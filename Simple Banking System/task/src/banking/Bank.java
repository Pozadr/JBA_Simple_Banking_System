package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    List<BankAccount> bankAccounts = new ArrayList<>();
    //BankAccount loggedInAccount;
    boolean isLoggedIn = false;


    public void createAccount() {
        bankAccounts.add(new BankAccount());
    }


    /*
    private void setLoggedIn(BankAccount loggedIn) {
        this.loggedInAccount = loggedIn;
    }
     */

    public void resetLoggedIn() {
        isLoggedIn = false;
        System.out.println("You have successfully logged out!\n");
    }


    public void getAccounts() {
        for (BankAccount account : bankAccounts) {
            account.getAccountInfo();
        }
    }


    public void getLoggedInBalance() {
        System.out.println("Balance: 0\n");
        //loggedInAccount.getBalance();
    }


    public boolean loginAccount() {
        // load data from user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your card number:");
        String inputCard = scanner.nextLine().trim();
        String[] userCardNumberInput = inputCard.split(""); //scanner.nextLine().trim().split("");

        System.out.println("Enter your PIN:");
        String inputPin = scanner.nextLine().trim();
        String[] userPinInput = inputPin.split("");

        // if account number is too short or pin number is too short return false
        if (userCardNumberInput.length != 16 || userPinInput.length != 4) {
            System.out.println("Wrong card number or PIN!");
            return false;
        }

        // check in all BankAccounts
        for (BankAccount account : bankAccounts) {
            // check account number
            boolean accOk = true;
            for (int i = 0; i < account.getAccountNumber().length; i++) {
                if (account.getAccountNumber()[i] != Integer.parseInt(userCardNumberInput[i])) {
                    accOk = false;
                    break;
                }
            }
            // check pin number
            if (accOk) { // if account number was wrong skip pin checking
                boolean pinOk = true;
                for (int i = 0; i < account.getPin().length; i++) {
                    if (account.getPin()[i] != Integer.parseInt(userPinInput[i])) {
                        pinOk = false;
                        break;
                    }
                }
                // account found
                if (pinOk) {
                    //setLoggedIn(account);
                    isLoggedIn = true;
                    System.out.println("You have successfully logged in!\n");
                    return true;
                }
            }
        }
        System.out.println("Wrong card number or PIN!");
        return false;
    }
}
