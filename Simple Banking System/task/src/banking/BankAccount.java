package banking;

import java.util.Random;

public class BankAccount {
    private int[] accountNumber = new int[16];
    private int[] pin = new int[4];
    /**
     * Whole card number 16-digit length.
     * IIN must be 400000.
     * The checksum can be any digit you like (last digit in card number)
     * 4000 00XX XXXX XXXC
     * X - raandom number
     * C - checksum
     */
    public void createAccount() {
        setAccountNumber();
        setPin();
        getAccountData();
    }

    private void getAccountData() {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(getAccountNumberString());
        System.out.println("Your card PIN:");
        System.out.println(getPinString());

    }


    private String getAccountNumberString() {
        StringBuilder sb = new StringBuilder();
        for (int num : accountNumber) {
            sb.append(num);
        }
        return sb.toString();
    }


    private String getPinString() {
        StringBuilder sb = new StringBuilder();
        for (int num : pin) {
            sb.append(num);
        }
        return sb.toString();
    }


    private void setAccountNumber() {
        Random random = new Random();
        accountNumber[0] = 4;
        for (int i = 1; i < accountNumber.length; i++) {
            if (i < 6) {
                accountNumber[i] = 0;
            } else {
                accountNumber[i] = random.nextInt(9);
            }
        }
    }


    private void setPin() {
        Random random = new Random();
        for (int i = 0; i < pin.length; i++) {
           pin[i] = random.nextInt(9);
        }
    }
}
