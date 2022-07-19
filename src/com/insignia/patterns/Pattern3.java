package com.insignia.patterns;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int sp = n - 1;
            int st = 1;
            for (int i = 1; i <= n; i++) {
                // System.out.println(sp + "," + st);

                for (int j = 1; j <= sp; j++) {
                   System.out.print(" ");
                }

                for(int k=1;k<=st;k++){
                    System.out.print("*");
                }
                sp--;
                st++;
                System.out.println();
            }
        }
    }
}
