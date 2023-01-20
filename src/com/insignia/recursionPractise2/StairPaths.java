package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StairPaths {

    public static ArrayList<String> getStairPaths(int n) {

        ArrayList<String> out = new ArrayList<>();

        // base case
        if (n == 0) {
            out.add("");
            return out;
        }

        if ((n - 1) >= 0) {
            // recursive call
            ArrayList<String> step1 = getStairPaths(n - 1);
            // processing
            for (String steps : step1) {
                out.add("1" + steps);
            }
        }

        if ((n - 2) >= 0) {
            // recursive call
            ArrayList<String> step2 = getStairPaths(n - 2);
            // processing

            for (String steps : step2) {
                out.add("2" + steps);
            }

        }

        if ((n - 3) >= 0) {
            // recursive call
            ArrayList<String> step3 = getStairPaths(n - 3);
            // processing

            for (String steps : step3) {
                out.add("3" + steps);
            }

        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        System.out.println(getStairPaths(input));

    }

}