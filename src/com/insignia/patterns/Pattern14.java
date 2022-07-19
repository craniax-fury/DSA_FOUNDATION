package com.insignia.patterns;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            method2(n);
        }
    }

    private static void method2(int n) {

        for (int i = 1; i <= 10; i++) {
            System.out.print(n+"*"+i+"="+n*i);
            System.out.println();
        }
    }
}
