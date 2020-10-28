package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    List<BankAccount> bankAccounts = new ArrayList<>();
    BankAccount loggedInAccount;

    public void createAccount() {
        bankAccounts.add(new BankAccount());
    }


    public boolean loginAccount() {
        // load data fromm user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        String[] userCardNumberInput = scanner.nextLine().trim().split("");
        System.out.println("Enter your PIN:");
        String[] userPinInput = scanner.nextLine().trim().split("");

        // if account number is too short or pin number is too short return false
        if (userCardNumberInput.length != 16 || userPinInput.length != 4) {
            return false;
        }

        // check in all BankAccounts
        for(BankAccount account : bankAccounts) {
            // check account number
            boolean accOk = true;
            for (int i = 0; i < account.getAccountNumber().length ; i++) {
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
                    setLoggedIn(account);
                    account.getAccountInfo();
                    return true;
                }
            }
        }
        System.out.println("Wrong card number or PIN!");
        return false;
    }

    public void setLoggedIn(BankAccount loggedIn) {
        this.loggedInAccount = loggedIn;
    }

    public void getAccounts() {
        for (BankAccount account : bankAccounts) {
            account.getAccountInfo();
        }
    }
}
