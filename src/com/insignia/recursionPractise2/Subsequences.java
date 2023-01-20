package com.insignia.recursionPractise2;

import java.io.*;
import java.util.ArrayList;

public class Subsequences {

    public static ArrayList<String> getSubsequences(String str) {

        ArrayList<String> strings = new ArrayList<>();

        // base case
        if (str.equals("")) {
            strings.add(str);
            return strings;
        }

        // processing
        String first = str.substring(0, 1);

        // recursive calls
        ArrayList<String> out = getSubsequences(str.substring(1));

        // processing
        for (String ss : out) {
            strings.add(ss);
        }

        for (String ss : out) {
            strings.add(first + ss);
        }

        return strings;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(getSubsequences(input));

    }

}