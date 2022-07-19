package com.insignia.patterns;

import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int sp = n/2;
        int st = 1;
        for (int i = 1; i <= n; i++) {
            if (i < n / 2+1) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || (i + j == n + 1)) {
                        System.out.print("*\t");

                    } else if (i != 1) {
                        System.out.print("\t");
                    }

                }

                if (i == 1) {
                    for (int l = 1; l <= n - 2; l++) {
                        System.out.print("*\t");

                    }
                }
            }else{
                for (int k = 1; k <= sp; k++) {
                    System.out.print("\t");
                }
                for (int l = 1; l <= st; l++) {
                    System.out.print("*\t");
            
                }

                sp--;
                st+=2;
            }
            System.out.println();
        }
    }
}
