package com.insignia.patterns;

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {

                System.out.print(a + "\t");
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }
    }
}
