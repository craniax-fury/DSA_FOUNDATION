package com.insignia.dynamicProgramming.BuySellStocks;
/**
input : 
20
5
6 7 8 12 14 15
5 8 5 3 1
5
*/
import java.util.Scanner;

public class HighwayBillboard {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        scn.nextInt();

        int boards = scn.nextInt();

        int[] boardAt = new int[boards + 1];
        int[] boardProfit = new int[boards + 1];

        for (int i = 1; i <= boards; i++) {
            boardAt[i] = scn.nextInt();
        }

        for (int i = 1; i <= boards; i++) {
            boardProfit[i] = scn.nextInt();
        }

        int[] incMax = new int[boards + 1];
        int[] excMax = new int[boards + 1];

        int boardGap = scn.nextInt();

        for (int i = 1; i <= boards; i++) {

            if (boardAt[i] - boardAt[i - 1] >= boardGap) {
                incMax[i] += incMax[i - 1] + boardProfit[i];

            } else if (excMax[i - 1] + boardProfit[i] > incMax[i - 1]) {
                incMax[i] = excMax[i - 1] + boardProfit[i];

            } else {
                incMax[i] = incMax[i - 1];
            }

            if (excMax[i - 1] > incMax[i - 1]) {
                excMax[i] = excMax[i - 1];
            } else {
                excMax[i] = incMax[i - 1];
            }
        }

        System.out.println(incMax[boards] > excMax[boards] ? incMax[boards] : excMax[boards]);
    }
}
