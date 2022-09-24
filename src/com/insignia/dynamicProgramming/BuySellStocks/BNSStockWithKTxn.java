package com.insignia.dynamicProgramming.BuySellStocks;

import java.util.Scanner;

public class BNSStockWithKTxn {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n+1];
        
        for(int i=1;i<=n;i++){
            price[i] = scn.nextInt();
        }

        int txns = scn.nextInt();

        int[][] maxProfit = new int[txns+1][n+1];

        for(int i=1;i<=txns;i++){
            int max = Integer.MIN_VALUE; // ==> profit[k] - price[k]
            for(int j=2;j<=n;j++){
                
                if(maxProfit[i-1][j-1] - price[j-1] + price[j]>max){
                    max = maxProfit[i-1][j-1] - price[j-1];
                }

                if(maxProfit[i][j-1]<=max + price[j]){
                    maxProfit[i][j] = max + price[j];  // price[j]- price[k] + profit [k] ==> profit[k] - price[k] + price[j]
                }else{
                    maxProfit[i][j] = maxProfit[i][j-1];
                }
            }
        }
        System.out.println(maxProfit[txns][n]);
    }
}