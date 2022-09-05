package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci {
    public static void main(String[] args) throws IOException{

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            
            /**
             * using tabulation
             * at each index of fib array , we will store fib of that index        
             */
            int[] fib = new int[n+1];

            fib[1]=1;

            if(n==0){
                System.out.println(0);
                return;
            
            }else if(n==1){
                System.out.println(1);
                return;
            }

            for(int i=2;i<=n;i++){
                fib[i] = fib[i-1]+fib[i-2];
            }

            System.out.println(fib[n]);
        }
    }
}
