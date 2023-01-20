package com.insignia.recursionPractise2;

import java.io.*;

public class IncreasingDecreasing {

    public static void printIncDec(int n) {

        // base case
        if (n == 0) {
            return;
        }

        // processing
        System.out.println(n);

        // recursive call
        printIncDec(n - 1);

        // processing
        System.out.println(n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printIncDec(n);

    }

}