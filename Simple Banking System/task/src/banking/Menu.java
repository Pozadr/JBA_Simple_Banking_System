package banking;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    BankAccount bankAccount;

    public Menu(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        int userInput = Integer.MAX_VALUE;
        do {
            printMainMenu();
            try {
                userInput = Integer.parseInt(scanner.nextLine().trim());
                switch (userInput) {
                    case 1: {
                        bankAccount.createAccount();
                        break;
                    }
                    case 2: {
                        System.out.println("Log into");
                        break;
                    }
                    case 0: {
                        System.out.println("Bye!");
                        break;
                    }
                    default: {
                        System.out.println("Wrong number! Try again!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Wrong input! Type number!");
            }
        } while (userInput != 0);
    }

    void printMainMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    void printUserMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }
}
