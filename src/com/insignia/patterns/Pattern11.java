package com.insignia.patterns;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {
        int op=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(op+"\t");
                op++;
            }
            System.out.println();
        }
    }
}
