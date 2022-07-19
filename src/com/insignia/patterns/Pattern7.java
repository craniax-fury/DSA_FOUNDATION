package com.insignia.patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method1(n);
            method2(n);

        }
    }

    private static void method1(int n) {
        int sp = 0;
        int st = 1;

        for (int i = 1; i <=n; i++) {
            // System.out.print(sp + "," + st + " ");

            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= st; k++) {
                System.out.print("*");
            }

            sp++;
            System.out.println();
        }
    }

    private static void method2(int n) {
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
