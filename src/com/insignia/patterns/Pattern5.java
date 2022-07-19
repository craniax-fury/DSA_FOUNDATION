package com.insignia.patterns;

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int sp = 2;
            int st = 1;

            for (int i = 1; i <= n; i++) {
                // System.out.print(sp + "," + st + " ");
                for (int j = 1; j <= sp; j++) {
                    System.out.print(" ");
                }

                for (int k = 1; k <= st; k++) {
                    System.out.print("*");
                }
                if (i <= n / 2) {
                    sp--;
                    st += 2;
                } else {
                    sp++;
                    st -= 2;
                }
                System.out.println();
            }

        }
    }
}
