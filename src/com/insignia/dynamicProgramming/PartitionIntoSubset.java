package com.insignia.dynamicProgramming;

import java.util.Scanner;

public class PartitionIntoSubset  {
    public static long partitionKSubset(int n, int k) {
        
        long[][] ways = new long[k+1][n+1]; 
        
        for(int i=1;i<k+1;i++){
            for(int j=1;j<n+1;j++){
                if(i>j){
                    ways[i][j]=0l;
                
                }else if(i==j){
                    ways[i][j]=1l;
                
                }else{
                    ways[i][j] = ways[i][j-1] * i + ways[i-1][j-1];
                }
            }
        }

        return ways[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
