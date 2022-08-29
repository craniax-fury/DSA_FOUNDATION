package com.insignia.matrices.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicStrings {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            for(int i=0;i<input.length();i++){
                for(int j=i+1;j<=input.length();j++){
                    printIfPalindrome(input.substring(i,j));
                }
            }
        }

    }

    private static void printIfPalindrome(String substring) {
        int li=0;
        int ri=substring.length()-1;
        
        while(li<ri){
            if(substring.charAt(li)!=substring.charAt(ri)){
                return;
            }
            li++;
            ri--;
        }

        System.out.println(substring);
    }
}
