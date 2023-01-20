package com.insignia.recursionPractise2;

import java.io.*;

public class Decreasing {


    public static void printDecreasing(int n){
        
        //base case
        if(n==0){
            return;
        }
        
        // processing
        System.out.println(n);
        
        //recursive call
        printDecreasing(n-1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printDecreasing(n);

    }

}