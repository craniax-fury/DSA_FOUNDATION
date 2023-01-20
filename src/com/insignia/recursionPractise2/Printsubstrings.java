package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Printsubstrings {

    public static void printPermutations(String str, String asf) {
        // base case
        if (str.length() <= 1) {
            System.out.println(asf + str);
            return;
        }

        // recursive calls
        for (int index = 0; index < str.length(); index++) {
            printPermutations(str.substring(0, index) + str.substring(index + 1), asf + str.charAt(index));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        printPermutations(str, "");

    }

}