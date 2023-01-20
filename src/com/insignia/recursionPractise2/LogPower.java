package com.insignia.recursionPractise2;

import java.io.*;

public class LogPower {

    public static int logPower(int x, int n) {

        // base case
        if (n == 0) {
            return 1;
        }

        // recursive call
        int logPower = logPower(x, n / 2);

        // processing
        if (n % 2 == 0) {
            return logPower * logPower;
        }

        return logPower * logPower * x;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        System.out.println(logPower(x, n));

    }

}