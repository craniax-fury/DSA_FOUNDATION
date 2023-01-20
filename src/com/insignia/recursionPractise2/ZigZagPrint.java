package com.insignia.recursionPractise2;

import java.io.*;

public class ZigZagPrint {

    public static void zigzag(int n) {

        // base case
        if (n == 0) {
            return;
        }

        // processing
        System.out.print(n+" ");
        // recursive call
        zigzag(n - 1);
        // processing
        System.out.print(n+" ");
        // recursive call
        zigzag(n-1);
        // processing
        System.out.print(n+" ");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        zigzag(n);

    }

}