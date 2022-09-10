package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeCombination {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of coins
            
            int[] den = new int[n]; // denominations

            for (int i = 0; i < n; i++) {
                den[i] = Integer.parseInt(reader.readLine()); 
            }
            
            int targetSum = Integer.parseInt(reader.readLine());

            int[] sum = new int[targetSum+1];
            sum[0]=1;

            for(int i=0;i<n;i++){
                for(int j=den[i];j<targetSum+1;j++){
                    if(j==den[i]){
                        sum[j]+=1;
                    }else if(j-den[i]>=0 && sum[j-den[i]]>=1){
                        sum[j] += sum[j-den[i]];
                    }
                }
            }

            System.out.println(sum[targetSum]);

        }
    }
}
