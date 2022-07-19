package com.insignia.foundation;
import java.util.Scanner;

/**
 * run loop till sqrt of n
 * for any number n where p*q=n, p and q are its factor
 * either one of p or q <=sqrt n
 */
public class PrimeTillN {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int from = sc.nextInt();
            int till = sc.nextInt();

            for (int n = from; n <= till; n++) {
                boolean isPrime = true;
                for (int div = 2; div * div <= n; div++) {
                    if (n % div == 0) {
                        isPrime = false;
                        System.out.println(n + " not prime");
                        break;
                    }
                }

                if (isPrime) {
                    System.out.println(n + " prime");
                }
            }

        }

    }
}