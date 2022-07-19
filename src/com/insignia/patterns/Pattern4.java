package com.insignia.patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int sp = 0;
            int st = n;

            for (int i = 1; i <= n; i++) {
                // System.out.println(sp+","+st+" ");
                for (int j = 1; j <= sp; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= st; k++) {
                    System.out.print("*");
                }
                sp++;
                st--;
                System.out.println();
            }

        }
    }
}
