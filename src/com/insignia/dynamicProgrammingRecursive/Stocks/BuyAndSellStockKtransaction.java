package com.insignia.dynamicProgrammingRecursive.Stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyAndSellStockKtransaction {

  private static int maxProfit(int[] prices, int buy, int index, int transactions, int noTAllowed) {
    int profit = 0;

    if (index == prices.length || transactions == noTAllowed) {
      return 0;
    }

    if (buy == 1) {
      int skip = 0 + maxProfit(prices, 1, index + 1, transactions, noTAllowed);
      int buyProfit = -prices[index] + maxProfit(prices, 0, index + 1, transactions, noTAllowed);
      profit = Math.max(skip, buyProfit);

    } else {
      int skip = 0 + maxProfit(prices, 0, index + 1, transactions, noTAllowed);
      int sellProfit = prices[index] + maxProfit(prices, 1, index + 1, transactions + 1, noTAllowed);
      profit = Math.max(skip, sellProfit);
    }

    return profit;
  }

  private static int maxProfitMemo(int[] prices, int buy, int index, int transactions, int noTAllowed, int[][][] dp) {

    int profit = 0;

    if (index == prices.length || transactions == noTAllowed) {
      return 0;
    }

    if (dp[index][buy][transactions] != 0) {
      return dp[index][buy][transactions];
    }

    if (buy == 1) {
      int skip = 0 + maxProfitMemo(prices, 1, index + 1, transactions, noTAllowed, dp);
      int buyProfit = -prices[index] + maxProfitMemo(prices, 0, index + 1, transactions, noTAllowed, dp);
      profit = Math.max(skip, buyProfit);
    } else {
      int skip = 0 + maxProfitMemo(prices, 0, index + 1, transactions, noTAllowed, dp);
      int sellProfit = prices[index] + maxProfitMemo(prices, 1, index + 1, transactions + 1, noTAllowed, dp);
      profit = Math.max(skip, sellProfit);

    }

    dp[index][buy][transactions] = profit;

    return dp[index][buy][transactions];
  }

  private static int maxProfitTabu(int[] prices, int noTAllowed, int[][][] dp) {

    int profit = 0;

    for (int index = prices.length - 1; index >= 0; index--) {

      for (int buy = 0; buy < 2; buy++) {
        for (int transactions = noTAllowed; transactions >= 1; transactions--) {
          if (buy == 1) {
            int skip = 0 + dp[index + 1][1][transactions];
            int buyProfit = -prices[index] + dp[index + 1][0][transactions];
            profit = Math.max(skip, buyProfit);
          } else {
            int skip = 0 + dp[index + 1][0][transactions];
            int sellProfit = prices[index] + dp[index + 1][1][transactions - 1];
            profit = Math.max(skip, sellProfit);
          }
          dp[index][buy][transactions] = profit;

        }
      }

    }

    return dp[0][1][noTAllowed];

  }

  private static int maxProfitSpaceOptimized(int[] prices, int noTAllowed, int[][] curr, int[][] next) {

    int profit = 0;

    for (int index = prices.length - 1; index >= 0; index--) {

      for (int buy = 0; buy < 2; buy++) {
        for (int transactions = noTAllowed; transactions >= 1; transactions--) {
          if (buy == 1) {
            int skip = 0 + next[1][transactions];
            int buyProfit = -prices[index] + next[0][transactions];
            profit = Math.max(skip, buyProfit);
          } else {
            int skip = 0 + next[0][transactions];
            int sellProfit = prices[index] + next[1][transactions - 1];
            profit = Math.max(skip, sellProfit);
          }
          curr[buy][transactions] = profit;

        }
      }

      next = curr;
    }

    return next[1][noTAllowed];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());

      int[] prices = new int[n];

      for (int i = 0; i < n; i++) {
        prices[i] = Integer.parseInt(reader.readLine());
      }

      int noTAllowed = Integer.parseInt(reader.readLine());

      int[][][] dp = new int[n + 1][2][noTAllowed + 1];
      int[][] curr = new int[2][noTAllowed + 1];
      int[][] next = new int[2][noTAllowed + 1];
      // System.out.println(maxProfit(prices, 1, 0, 0,noTAllowed));
      // System.out.println(maxProfitMemo(prices, 1, 0, 0,noTAllowed, dp));

      // System.out.println(maxProfitTabu(prices,noTAllowed,dp));
      System.out.println(maxProfitSpaceOptimized(prices, noTAllowed, curr, next));
    }
  }

  private static void display1d(int[] soln) {
    for (int ele : soln) {
      if (ele == -1l) {
        System.out.print(ele + " ");
      } else {
        System.out.print(" " + ele + " ");
      }

    }
  }

  private static void display2d(int[][] soln) {
    for (int[] eleArr : soln) {
      display1d(eleArr);
      System.out.println();
    }
  }

}
