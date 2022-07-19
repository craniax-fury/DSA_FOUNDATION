package com.insignia.foundation;
import java.util.Scanner;

public class FibonacciTillN {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int till = sc.nextInt();
            int current = 0;
            int next = 1;
            int temp = 0;
            int n = 0;
            while (n < till) {
                System.out.print(current + " ");
                temp = current + next;
                current = next;
                next = temp;
                n++;
            }

        }
    }
}