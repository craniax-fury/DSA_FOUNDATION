package com.insignia.dynamicProgramming;

import java.util.Scanner;

public class BNSStock1Txn  {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        
        int[] profitAtDayWithLeastPrice = new int[n];
        
        int maxProfit = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            price[i] = scn.nextInt();
        }

        int leastPrice = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(price[i]<leastPrice){
                leastPrice=price[i];
            }
            profitAtDayWithLeastPrice[i]  = price[i] - leastPrice;

            if(profitAtDayWithLeastPrice[i]>maxProfit){
                maxProfit=profitAtDayWithLeastPrice[i];
            }
        }
        System.out.println(maxProfit);
    }
}
