package com.insignia.dynamicProgrammingRecursive.LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {

    private static void lps(String ros,String ssf) {
        if(ros.length()==0){
            System.out.println(ssf);
        }

        String lps = "";

        lps(ros.substring(1),ssf+ros.substring(0,1));
        lps(ros.substring(1),ssf);

        // System.out.println("pick: "+pick);
        // System.out.println("skip: "+skip);


        // // if(isPalindrome(pick)){
        // //     lps=pick;
        // // }

        // // if(isPalindrome(skip) && skip.length()>lps.length()){
        // //     lps=skip;
        // // }

        // //System.out.println(lps);
        
        // return lps;
        
    }

    private static boolean isPalindrome(String string) {
        int start = 0;
        int end = string.length()-1;

        while(start<end){
            if(!(string.charAt(start)==string.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String n = reader.readLine();

            lps(n,"");

        }
    }

    private static void display(int[] soln) {
        for (int i = 0; i < soln.length; i++) {
            System.out.print(soln[i] + " ");
        }
    }
}
