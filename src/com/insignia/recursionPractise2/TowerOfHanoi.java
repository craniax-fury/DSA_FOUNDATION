package com.insignia.recursionPractise2;

import java.io.*;

public class TowerOfHanoi {

    public static void toh(int n, int t1, int t2, int t3) {

        // base case
        if (n == 0) {
            return;
        }

        // recursive call
        toh(n - 1, t1, t3, t2);
        // processing
        System.out.println(n + "[" +t1 + "->" + t2 + "]");
        toh(n - 1, t3, t2, t1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());
        int t3 = Integer.parseInt(br.readLine());

        toh(n, t1, t2, t3);

    }

}