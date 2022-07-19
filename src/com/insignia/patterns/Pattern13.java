package com.insignia.patterns;

import java.util.Scanner;
/**
 * Solve using permutation property
 * nc0 = ncn
 * nck = nck-1
 * icj+1 = (icj * (i-j))/(j+1)
 */
public class Pattern13 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
       
        for (int i = 0; i < n; i++) {
            int icj = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(icj + "\t");
                int icjp1 = (icj* (i-j))/(j+1);
                icj = icjp1;
            }
            System.out.println();
        }
    }
}
