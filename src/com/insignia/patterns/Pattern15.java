package com.insignia.patterns;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int sp = n / 2;
        int st = 1;
        int val = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            int out = val;
            for (int k = 1; k <= st; k++) {
                if (k < st / 2 + 1) {
                    System.out.print((out++) + "\t");
                } else {
                    System.out.print((out--) + "\t");

                }
            }

            if (i <= n / 2) {
                sp--;
                st += 2;
                val++;
            } else {
                sp++;
                st -= 2;
                val--;
            }
            System.out.println();
        }
    }
}
