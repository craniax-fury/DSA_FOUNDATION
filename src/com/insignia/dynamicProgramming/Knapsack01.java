package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack01 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of items

            String[] valueLine = reader.readLine().split(" ");
            String[] wtLine = reader.readLine().split(" ");

            int[] values = new int[n]; // item values
            int[] wt = new int[n]; // item weights

            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(valueLine[i]);
            }

            for (int i = 0; i < n; i++) {
                wt[i] = Integer.parseInt(wtLine[i]);
            }
            
            int cap = Integer.parseInt(reader.readLine()); // bag capacity
            
            int[][] maxValue = new int[n][cap+1];


            for(int i=0;i<n;i++){
                for(int j=1;j<cap+1;j++){
                    if(wt[i]==j){
                        if(i-1>=0 && maxValue[i-1][j]>values[i]){
                            maxValue[i][j] = maxValue[i-1][j];
                        }else{
                            maxValue[i][j] = values[i];
                        }
                    }else if(i-1>=0 && j-wt[i]>=0 && maxValue[i-1][j-wt[i]]>=0){
                        if(maxValue[i-1][j]>=0 && maxValue[i-1][j-wt[i]]+values[i] <maxValue[i-1][j]){
                            maxValue[i][j] = maxValue[i-1][j];
                        }else{
                            maxValue[i][j] = maxValue[i-1][j-wt[i]]+values[i];
                        }
                    }else if(i-1>=0 && maxValue[i-1][j]>0){
                        maxValue[i][j] = maxValue[i-1][j];
                    }
                }
            }

            System.out.println(maxValue[n-1][cap]);
        }
    }
}
