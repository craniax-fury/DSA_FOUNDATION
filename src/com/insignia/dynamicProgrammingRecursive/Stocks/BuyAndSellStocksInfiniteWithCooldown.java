package com.insignia.dynamicProgrammingRecursive.Stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyAndSellStocksInfiniteWithCooldown {

  private static int maxProfit(int[] prices, int buy, int index) {
    int profit = 0;

    if (index == prices.length) {
      return 0;
    }

    if (buy == 1) {
      int skip = 0 + maxProfit(prices, 1, index + 1);
      int buyProfit = -prices[index] + maxProfit(prices, 0, index + 1);
      profit = Math.max(skip, buyProfit);

    } else if (buy == 2) {
      profit = 0 + maxProfit(prices, 1, index + 1);

    } else {
      int skip = 0 + maxProfit(prices, 0, index + 1);
      int sellProfit = prices[index] + maxProfit(prices, 2, index + 1);
      profit = Math.max(skip, sellProfit);
    }

    return profit;
  }

  private static int maxProfitMemo(int[] prices, int buy, int index, int[][] dp) {

    int profit = 0;

    if (index == prices.length) {
      return 0;
    }

    if (dp[buy][index] != 0) {
      return dp[buy][index];
    }

    if (buy == 1) {
      int skip = 0 + maxProfitMemo(prices, 1, index + 1, dp);
      int buyProfit = -prices[index] + maxProfitMemo(prices, 0, index + 1, dp);
      profit = Math.max(skip, buyProfit);
      dp[buy][index] = profit;
    } else if (buy == 2) {
      profit = 0 + maxProfitMemo(prices, 1, index + 1, dp);
      dp[buy][index] = profit;

    } else {
      int skip = 0 + maxProfitMemo(prices, 0, index + 1, dp);
      int sellProfit = prices[index] + maxProfitMemo(prices, 2, index + 1, dp);
      profit = Math.max(skip, sellProfit);
      dp[buy][index] = profit;

    }

    return dp[buy][index];
  }

  private static int maxProfitTabu(int[] prices, int[][] dp) {

    int profit = 0;

    for (int index = prices.length - 1; index >= 0; index--) {
      for (int buy = 0; buy <= 2; buy++) {
        if (buy == 1) {
          int skip = 0 + dp[1][index + 1];
          int buyProfit = -prices[index] + dp[0][index + 1];
          profit = Math.max(skip, buyProfit);
          dp[buy][index] = profit;
        } else if (buy == 2) {
          profit = 0 + dp[1][index + 1];
          dp[buy][index] = profit;

        } else {
          int skip = 0 + dp[0][index + 1];
          int sellProfit = prices[index] + dp[2][index + 1];
          profit = Math.max(skip, sellProfit);
          dp[buy][index] = profit;

        }
      }
    }

    return dp[1][0];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());

      int[] prices = new int[n];

      for (int i = 0; i < n; i++) {
        prices[i] = Integer.parseInt(reader.readLine());
      }

      int[][] dp = new int[3][n + 1];

      // System.out.println(maxProfit(prices, 1, 0));
      //System.out.println(maxProfitMemo(prices, 1, 0, dp));

       System.out.println(maxProfitTabu(prices,dp));
       display2d(dp);

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
