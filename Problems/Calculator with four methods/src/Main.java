// Don't delete this import statement

import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

    }

    // Implement your methods here
    public static void subtractTwoNumbers(long n1, long n2) {
        System.out.println(n1 - n2);
    }


    public static void sumTwoNumbers(long n1, long n2) {
        System.out.println(n1 + n2);
    }


    public static void divideTwoNumbers(long n1, long n2) {
        if (n2 == 0) {
            System.out.println("Division by 0!");
        } else {
            System.out.println(n1 / n2);
        }
    }


    public static void multiplyTwoNumbers(long n1, long n2) {
        System.out.println(n1 * n2);
    }
}