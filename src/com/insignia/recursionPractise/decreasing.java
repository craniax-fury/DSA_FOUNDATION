package com.insignia.recursionPractise;

import java.io.*;

public class decreasing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printDecreasing(n);

        
}

    private static void printDecreasing(int n) {
        
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
  
    }

}