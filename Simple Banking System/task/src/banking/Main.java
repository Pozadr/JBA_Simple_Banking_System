package banking;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Menu menu = new Menu(bank);
        menu.runMenu();
    }

}