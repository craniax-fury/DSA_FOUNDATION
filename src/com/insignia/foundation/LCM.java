package com.insignia.foundation;
import java.util.Scanner;

/**
 * GCD*LCM=num1*num2;
 */
public class LCM {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int gcd = gcd(num1, num2);
            System.out.println((num1*num2)/gcd);
        }
    }

    private static int gcd(int num1, int num2) {
        int div = 1;
        int tempNum1 = num1;
        int tempNum2 = num2;
        while (div > 0) {
            div = tempNum1 % tempNum2;
            tempNum1 = tempNum2;
            tempNum2 = div;
        }

        return tempNum1;
    }
}