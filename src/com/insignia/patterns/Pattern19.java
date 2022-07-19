package com.insignia.patterns;

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        for (int i = 1; i <= n; i++) {
            if (i <= n / 2) {
                for (int j = 1; j <= n; j++) {
                    if ((i == 1 && j < n / 2 + 1) || j == n / 2 + 1 || j == n) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            } else if (i == n / 2 + 1) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("*\t");
                }
            }else{
                for (int j = 1; j <= n; j++) {
                    if ((i == n && j > n / 2 + 1) || j == n / 2 + 1 || j == 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}
