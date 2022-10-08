package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintPermutations {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
    
        printPerm(n, "");
    }

    public static void printPerm(String ros, String out) {
        if(ros.length()==0){
            System.out.println(out);
        }

        for(int i=0;i<ros.length();i++){
            if(i!=0){
                printPerm(ros.substring(0,i)+ros.substring(i+1),out+String.valueOf(ros.charAt(i)));
            }else{
                printPerm(ros.substring(i+1),out+String.valueOf(ros.charAt(i)));
            }
        }
    }
}