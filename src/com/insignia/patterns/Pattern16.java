package com.insignia.patterns;

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int sp = n * 2 - 3;
        int st = 1;
        for (int i = 1; i <= n * 2 - i; i++) {
            int val=1;
            for (int k = 1; k <= st; k++) {
                System.out.print((val++)+"\t");
            }

            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }

            if (i == n) {
                st -= 1;
                val--;
            }
            
            val--;

            for (int k = 1; k <= st; k++) {
                System.out.print((val--)+"\t");
            }

            sp -= 2;
            st++;

            System.out.println();
        }
    }
}
