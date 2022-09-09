package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostInMazeTraversal {
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

            int[][] minCostMatrix = new int[n][m];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if(i==n-1 && j==m-1){
                        minCostMatrix[i][j] = input[i][j]; 
                        continue;
                    }

                    int poss1 = i<=n-1 && j+1<=m-1 ? minCostMatrix[i][j+1] : Integer.MAX_VALUE;
                    int poss2 = i+1<=n-1 && j<=m-1 ? minCostMatrix[i+1][j] : Integer.MAX_VALUE;

                    minCostMatrix[i][j] = input[i][j]+ Math.min(poss1,poss2);  
                }
            }
            

            System.out.println(minCostMatrix[0][0]);
        }
    }
}
