package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintSubsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
    
        printSS(n,"");
    }

    private static void printSS(String str,String out) {
        if(str.length()==0){
            System.out.println(out);
            return;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        printSS(ros,out+ch);
        printSS(ros,out+"");
        
    }
}