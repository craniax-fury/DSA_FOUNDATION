package com.insignia.recursionPractise2;

import java.io.*;

public class LinearPower {

    public static int linearPower(int x, int n) {

        // base case
        if (n == 0) {
            return 1;
        }

        // recursive call
        int powerValue = linearPower(x, n - 1);

        // processing
        return x * powerValue;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        System.out.println(linearPower(x, n));

    }

}