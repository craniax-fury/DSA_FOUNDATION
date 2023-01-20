package com.insignia.recursionPractise2;

import java.io.*;

public class Increasing {

    public static void printIncreasing(int n) {

        // base case
        if (n == 0) {
            return;
        }

        // recursive call
        printIncreasing(n - 1);

        // processing
        System.out.println(n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printIncreasing(n);

    }

}