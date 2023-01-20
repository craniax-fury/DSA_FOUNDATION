package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintSubsequences {

    public static void printSubsequences(String str, String ans) {
        
        //base case
        if(str.equals("")){
            System.out.println(ans);
            return;
        }

        //processing
        String first = String.valueOf(str.charAt(0));

        //recursive call
        printSubsequences(str.substring(1), ans+first);
        printSubsequences(str.substring(1), ans);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        printSubsequences(str, "");

    }

}