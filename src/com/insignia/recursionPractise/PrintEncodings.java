package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        printEncodings("", n);
    }

    public static void printEncodings(String out, String ros) {
        if (ros.length() == 0) {
            System.out.println(out);
            return;
        }

        if (ros.charAt(0) != '0') {
            printEncodings(out + (char) ('a' + ros.charAt(0) - '0' - 1), ros.substring(1));
        }

        if (ros.length()>1 && ros.charAt(0) != '0' && Integer.valueOf(ros.substring(0, 2)) <= 26) {
            printEncodings(out + (char) ('a' + (Integer.valueOf(ros.substring(0, 2)) - 1)), ros.substring(2));
        }
    }
}