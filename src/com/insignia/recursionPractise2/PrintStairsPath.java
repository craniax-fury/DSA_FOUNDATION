package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintStairsPath {

    public static void printStairpaths(int n, String asf) {

        // base case
        if (n == 0) {
            System.out.println(asf);
            return;
        }

        // processing
        if ((n - 1) >= 0) {
            // recursive calls
            printStairpaths(n - 1, asf + "1");
        }

        // processing
        if ((n - 2) >= 0) {
            // recursive calls
            printStairpaths(n - 2, asf + "2");
        } // processing

        if ((n - 3) >= 0) {
            // recursive calls
            printStairpaths(n - 3, asf + "3");
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        printStairpaths(n, "");

    }

}