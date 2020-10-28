package banking;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Bank bank;

    public Menu(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        int userInput = Integer.MAX_VALUE;
        do {
            printMainMenu();
            try {
                userInput = Integer.parseInt(scanner.nextLine().trim());
                System.out.println(); //empty line
                switch (userInput) {
                    case 1: {
                        bank.createAccount();
                        break;
                    }
                    case 2: {
                        if (bank.loginAccount()) {
                            int userMenuInput;
                            do {
                                printUserMenu();
                                userMenuInput = Integer.parseInt(scanner.nextLine().trim());
                                switch (userMenuInput) {
                                    case 1: {
                                        bank.getLoggedInBalance();
                                        break;
                                    }
                                    case 2: {
                                        bank.resetLoggedIn();
                                        break;
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default: {
                                        System.out.println("Wrong number! Try again!");
                                    }
                                }
                            } while (userMenuInput != 0 && userMenuInput != 2);
                        }
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
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    void printUserMenu() {
        System.out.println("\n1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }
}
