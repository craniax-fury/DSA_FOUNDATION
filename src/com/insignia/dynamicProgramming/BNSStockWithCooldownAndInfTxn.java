package com.insignia.dynamicProgramming;

import java.util.Scanner;

public class BNSStockWithCooldownAndInfTxn {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];

        int[] bSbLoan = new int[n];
        int[] bsbsProfit = new int[n];
        int[] bscProfit = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        bSbLoan[0] = price[0];
        
        for(int i=1;i<n;i++){
            if(price[i]-bSbLoan[i-1]>bsbsProfit[i-1]){
                bsbsProfit[i] = price[i]-bSbLoan[i-1];
            }else{
                bsbsProfit[i] = bsbsProfit[i-1];
            }

            if(bsbsProfit[i-1]>bscProfit[i-1]){
                bscProfit[i] = bsbsProfit[i-1];
            }else{
                bscProfit[i] = bscProfit[i-1];
            }

            if(price[i]-bscProfit[i-1] < bSbLoan[i-1]){
                bSbLoan[i] = price[i]-bscProfit[i-1];
            }else{
                bSbLoan[i] = bSbLoan[i-1];
            }

        }

        System.out.println(bscProfit[n-1]);
    }
}
