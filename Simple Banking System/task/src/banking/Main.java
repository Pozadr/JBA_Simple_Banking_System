package banking;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Menu menu = new Menu(bankAccount);
        menu.run();
    }
}