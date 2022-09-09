package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSumSubsets {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            int[][] input = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] line =  reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    input[i][j] = Integer.parseInt(line[j]);
                }
            }

            int[][] maxGoldMatrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                    maxGoldMatrix[i][m-1] = input[i][m-1];        
            }

            for (int j = m-2; j >= 0; j--) {
                for (int i = 0; i < n; i++) {

                    int poss1 = i-1>=0 && j+1<=m-1 ? maxGoldMatrix[i-1][j+1] : Integer.MIN_VALUE;
                    int poss2 = j+1<=m-1 ? maxGoldMatrix[i][j+1] : Integer.MIN_VALUE;
                    int poss3 = i+1<=n-1 && j+1<=m-1 ? maxGoldMatrix[i+1][j+1] : Integer.MIN_VALUE;

                    maxGoldMatrix[i][j] = input[i][j] + Math.max(Math.max(poss1,poss2),poss3);  
                }
            }
            
            int maxGold = 0;
            
            for(int i=0;i<=n-1;i++){
                maxGold = Math.max(maxGold, maxGoldMatrix[i][0]);    
            }

            System.out.println(maxGold);
        }
    }
}
