package banking;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Bank bank;

    public Menu(Bank bank) {
        this.bank = bank;
    }

    public void runMenu() {
        while (true) {
            printMenu();
            switch (scanner.nextLine().trim()) {
                case "1": {
                    bank.createAccount();
                    break;
                }

                case "2": {
                    if (bank.loginAccount()) {
                        if (!runUserMenu()) {
                            return;
                        }
                    }
                    break;
                }

                case "0": {
                    System.out.println("Bye!");
                    return;
                }

                default: {
                    System.out.println("Wrong number! Try again!");
                }
            }
        }
    }

    public boolean runUserMenu() {
        while (true) {
            printUserMenu();
            switch (scanner.nextLine().trim()) {
                case "1": {
                    bank.getLoggedInBalance();
                    break;
                }


                case "2": {
                    //bank.resetLoggedIn();
                    //System.out.println("You have successfully logged out!\n");
                    return true;
                }


                case "0": {
                    return false;
                }

                default: {
                    System.out.println("Wrong number! Try again!");
                    return true;
                }
            }
        }

    }

    public void printMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public void printUserMenu() {
        System.out.println("\n1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }
}
