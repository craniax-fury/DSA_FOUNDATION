package com.insignia.dynamicProgramming.BuySellStocks;

import java.util.Scanner;

public class BNSStockInfiniteTxn  {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        
        int[] profitAtDayWithLeastPrice = new int[n];
        
        int profit = 0;

        for(int i=0;i<n;i++){
            price[i] = scn.nextInt();
        }

        int leastPrice = price[0];

        for(int i=1;i<n;i++){
            if(i==n-1 && price[i]>price[i-1]){
                profitAtDayWithLeastPrice[i-1]  = price[i] - leastPrice;
                profit+=profitAtDayWithLeastPrice[i-1];
                leastPrice=price[i];
            
            }else if(price[i]<price[i-1]){
                profitAtDayWithLeastPrice[i-1]  = price[i-1] - leastPrice;
                profit+=profitAtDayWithLeastPrice[i-1];
                leastPrice=price[i];
            }

            if(price[i]<leastPrice){
                leastPrice=price[i];
            }
        }
        System.out.println(profit);
    }
}
