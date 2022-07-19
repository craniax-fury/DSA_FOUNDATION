package com.insignia.patterns;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int sp = 2;
        int st = 1;
        for (int i = 1; i <= n; i++) {

            if (i == n / 2 + 1) {
                for (int k = 1; k <= n / 2; k++) {
                    System.out.print("*\t");
                }
            } else {
                for (int j = 1; j <= sp; j++) {
                    System.out.print("\t");
                }

            }

            for (int k = 1; k <= st; k++) {
                System.out.print("*\t");
            }

            if (i <= n / 2) {
                st++;
            } else {
                st--;
            }

            System.out.println();
        }
    }
}
