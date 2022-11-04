package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbStairsVarJumps {

    private static int climb(int dest, int curr, int[] jumps, Integer[] soln) {

        if (curr > dest) {
            return 0;
        }

        if (soln[curr] != null) {
            return soln[curr];
        }

        while (curr != -1) {
            for (int j = 1; j <= jumps[curr]; j++) {
                int move = climb(dest, curr + j, jumps, soln);
                if (move != -1) {
                    if (soln[curr] == null) {
                        soln[curr] = move==0?1:move;
                    } else {
                        soln[curr] +=  move;
                    }

                }
            }

            if (soln[curr] == null) {
                soln[curr] = -1;
            }
            curr--;
        }

        return soln[0];

    }

    private static int climbR(int dest, int[] dp,int curr,int[] jumps){
        if(dp[curr]!=0){
            return dp[curr];
        }

        if(curr==dest){
            dp[curr]=1;
            return 1;
        }

        if(jumps[curr]==0){
            dp[curr]=0;
            return 0;
        }

        for(int jump=1;jump<=jumps[curr];jump++){
            if(jump+curr<=dest){
                dp[curr]+= climbR(dest, dp, curr+jump, jumps);
            }
        }

        return dp[curr];
    } 
    
    private static int climbTab(int dest, int[] dp,int curr,int[] jumps){
        
        for(int i=dest;i>=0;i--){
            
            if(jumps[i]==0){
                continue;
            }
    
            for(int jump=1;jump<=jumps[i];jump++){
                if(jump+i<=dest){
                    dp[i]+= dp[i+jump];
                }
            }   
        }

        return dp[0];  
    } 

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] jumps = new int[n+1];

            for (int i = 0; i < n; i++) {
                jumps[i] = Integer.parseInt(reader.readLine());
            }

            int[] dp = new int[n + 1];
dp[n]=1;
            System.out.println(climbTab(n,dp,n , jumps));

        }
    }
}
