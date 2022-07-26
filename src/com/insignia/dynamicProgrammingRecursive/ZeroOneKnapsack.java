package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneKnapsack {

  private static int knapSack01(int[] wt, int[] val, int index, int cap) {

    if (cap < 0) {
      return 0;
    }

    if (index == 0) {
      if (wt[index] == cap) {
        return val[index];
      } else {
        return 0;
      }
    }

    int pickValue = 0;
    int notPickValue = 0;

    if (wt[index] <= cap) {
      pickValue = val[index] + knapSack01(wt, val, index - 1, cap - wt[index]);
    }

    notPickValue = knapSack01(wt, val, index - 1, cap);

    return pickValue > notPickValue ? pickValue : notPickValue;
  }

  private static int knapSack01Memo(int[] wt, int[] val, int index, int cap, int[][] dp) {

    if (cap < 0) {
      return 0;
    }

    if (index == 0) {
      if (wt[index] == cap) {
        return val[index];
      } else {
        return 0;
      }
    }

    if (dp[index][cap] != 0) {
      return dp[index][cap];
    }

    int pickValue = 0;
    int notPickValue = 0;

    if (wt[index] <= cap) {
      pickValue = val[index] + knapSack01Memo(wt, val, index - 1, cap - wt[index], dp);
    }

    notPickValue = knapSack01Memo(wt, val, index - 1, cap, dp);

    dp[index][cap] = pickValue > notPickValue ? pickValue : notPickValue;

    return dp[index][cap];
  }

  private static int knapSack01Tabu(int[] wt, int[] val, int cap, int[][] dp) {

    if (cap < 0) {
      return 0;
    }

    for (int index = 0; index <= cap; index++) {
      if (wt[0] == index) {
        dp[0][index] = val[0];
      } else {
        dp[0][index] = 0;
      }
    }

    for (int index = 1; index <=wt.length-1; index++) {
      for (int capacity = 0; capacity <= cap; capacity++) {

        int pickValue = 0;
        int notPickValue = 0;

        if (wt[index] <= capacity) {
          pickValue = val[index] + dp[index - 1][capacity - wt[index]];
        }

        notPickValue = dp[index - 1][capacity];

        dp[index][capacity] = pickValue > notPickValue ? pickValue : notPickValue;

      }
    }

    return dp[wt.length - 1][cap];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] val = new int[n];

      String[] vals = reader.readLine().split(" ");

      for (int i = 0; i < n; i++) {
        val[i] = Integer.parseInt(vals[i]);
      }

      int[] wt = new int[n];

      String[] wts = reader.readLine().split(" ");

      for (int i = 0; i < n; i++) {
        wt[i] = Integer.parseInt(wts[i]);
      }

      int cap = Integer.parseInt(reader.readLine());

      int[][] dp = new int[n][cap + 1];
      // System.out.println(knapSack01Memo(wt, val, n - 1, cap,dp));

      System.out.println(knapSack01Tabu(wt, val, cap, dp));
      display2d(dp);
    }
  }

  private static void display1d(int[] soln) {
    for (int ele : soln) {
      if (ele == -1) {
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
