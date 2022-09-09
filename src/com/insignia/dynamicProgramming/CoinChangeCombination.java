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

            boolean[][] sumMatrix = new boolean[n][targetSum+1];

            for(int i=0;i<n;i++){
                sumMatrix[i][0] = true;
            }

            int combinations = 0;

            for(int row=0;row<n;row++){
                for(int col=1;col<targetSum+1;col++){
                    
                    if(col%den[row]==0){
                        sumMatrix[row][col]  = true;
                    }else if(row-1>=0 && col-den[row]>=0 && sumMatrix[row-1][col-den[row]]==true){
                        sumMatrix[row][col]  = true;
                    
                    }else if(row-1>=0 && sumMatrix[row-1][col]==true && col!=targetSum){
                        sumMatrix[row][col]  = true;
                    }
                    
                    if(sumMatrix[row][targetSum]==true){
                        combinations+=1;
                    }
                }
            }
            System.out.println(combinations);

        }
    }
}
