package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairs {
    public static void main(String[] args) throws IOException{

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            
            /**
             * using tabulation
             * at each index of nop array i.e number of paths, we will store number of paths to that index
             * we can take 1 2 or 3 steps, this means that nop[i] = nop[i-1]+nop[i-2]+nop[i-3]        
             */
            int[] nop = new int[n+1];

            nop[0]=1;

            for(int i=1;i<=n;i++){
                if(i-1>=0){
                    nop[i] += nop[i-1];
                }

                if(i-2>=0){
                    nop[i] += nop[i-2];
                }

                if(i-3>=0){
                    nop[i] += nop[i-3];
                }
            }

            System.out.println(nop[n]);
        }
    }
}
