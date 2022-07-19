package com.insignia.patterns;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int isp = -1;
        int osp = n / 2;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= osp; k++) {
                System.out.print("\t");
            }

            System.out.print("*\t");

            for (int j = 1; j <= isp; j++) {
                System.out.print("\t");
            }

            if (!(isp < 0)) {
                System.out.print("*\t");
            }

            System.out.println();

            if (i <= n / 2) {
                isp += 2;
                osp--;
            } else {
                isp -= 2;
                osp++;
            }
        }
    }
}
