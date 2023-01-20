package com.insignia.recursionPractise2;

import java.io.*;

public class Factorial {

    public static int factorial(int n) {

        // base case
        if (n == 1) {
            return 1;
        }
        
        // recursive call
        int factValue = factorial(n - 1);

        // processing
        return factValue * n;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));

    }

}