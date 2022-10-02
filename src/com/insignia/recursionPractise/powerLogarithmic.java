package com.insignia.recursionPractise;

import java.io.*;

public class PowerLogarithmic {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        System.out.println(power(x, n));

    }

    private static int power(int x, int n) {

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);
        } else {
            return power(x, n / 2) * power(x, n / 2) * x;
        }

    }

}