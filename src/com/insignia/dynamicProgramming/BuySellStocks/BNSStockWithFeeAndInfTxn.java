package com.insignia.dynamicProgramming.BuySellStocks;

import java.util.Scanner;

public class BNSStockWithFeeAndInfTxn {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];

        int[] bSbLoan = new int[n];
        int[] sellProfit = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        int fee = scn.nextInt();

        bSbLoan[0] = price[0];
        
        for(int i=1;i<n;i++){
            if(price[i] - bSbLoan[i-1] - fee>sellProfit[i-1]){
                sellProfit[i] = price[i] - bSbLoan[i-1] - fee;
            }else{
                sellProfit[i] = sellProfit[i-1];
            }

            if(price[i]-sellProfit[i-1]<bSbLoan[i-1]){
                bSbLoan[i] = price[i]-sellProfit[i-1];
            }else{
                bSbLoan[i] = bSbLoan[i-1];
            }
        }

        System.out.println(sellProfit[n-1]);
    }
}
