package com.insignia.recursionPractise;

import java.io.*;

public class Power {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(power(n));

        
}

    private static int power(int n) {
        
        if(n==0){
            return 1;
        }
        
        return 2 * power(n-1);
  
    }

}