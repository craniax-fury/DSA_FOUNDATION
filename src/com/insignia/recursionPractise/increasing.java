package com.insignia.recursionPractise;

import java.io.*;

public class increasing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printIncreasing(n);

        
}

    private static void printIncreasing(int n) {
        
        if(n==0){
            return;
        }

        printIncreasing(n-1);

        System.out.println(n);
          
    }

}