package com.insignia.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintZigZag {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // int number = Integer.parseInt(reader.readLine());
            pzz(3);
        }
    }

    public static void pzz(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");

    }
}
