package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintEncodings {

    public static void printencodings(String str, String ssf) {

        // base case
        if (str.length() == 0) {
            System.out.println(ssf);
            return;
        }

        if (str.length() == 1) {
            System.out.println(ssf + String.valueOf((char) ('a' + (str.charAt(0) - '0' - 1))));
            return;
        }

        // processing
        if (str.charAt(0) != '0') {

            String one = String.valueOf((char) ('a' + (str.charAt(0) - '0' - 1)));
            // recursive call

            printencodings(str.substring(1), ssf + one);

            String two = str.substring(0, 2);
            // processing

            if (Integer.parseInt(two) <= 26) {
                // recursive call
                printencodings(str.substring(2), ssf + String.valueOf((char) ('a' + Integer.parseInt(two) - 1)));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        printencodings(str, "");

    }

}