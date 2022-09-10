package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSumSubsets {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of players
            
            int[] ic = new int[n]; // individual capacities

            for (int i = 0; i < n; i++) {
                ic[i] = Integer.parseInt(reader.readLine()); 
            }
            
            int targetRun = Integer.parseInt(reader.readLine());

            boolean[][] scoreMatrix = new boolean[n][targetRun+1];

            for(int i=0;i<n;i++){
                scoreMatrix[i][0] = true;
            }

            for(int row=0;row<n;row++){
                for(int col=1;col<targetRun+1;col++){
                    
                    if(row-1>=0 && scoreMatrix[row-1][col]==true){
                        scoreMatrix[row][col]  = true;
                    }else if(ic[row]==col){
                        scoreMatrix[row][col]  = true;
                    }else if(row-1>=0 && col-ic[row]>=0 && scoreMatrix[row-1][col-ic[row]]==true){
                        scoreMatrix[row][col]  = true;
                    }
                    
                    if(scoreMatrix[row][targetRun]==true){
                        System.out.println(true);
                        return;
                    }
                }
            }
            System.out.println(false);

        }
    }
}
