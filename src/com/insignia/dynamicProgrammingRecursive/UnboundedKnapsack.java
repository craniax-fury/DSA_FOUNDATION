package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnboundedKnapsack {

  private static int unboundSack(int[] wt, int[] val, int index, int capacity) {

    if (capacity < 0) {
      return 0;
    }

    if (index == 0) {
      if (capacity == wt[0]) {
        return val[0];
      } else {
        return 0;
      }
    }

    int pickValue = 0;
    int notPickValue = 0;

    if (wt[index] <= capacity) {
      pickValue = val[index] + unboundSack(wt, val, index, capacity - wt[index]);
    }

    notPickValue = unboundSack(wt, val, index - 1, capacity);

    return pickValue > notPickValue ? pickValue : notPickValue;
  }

  private static int unboundSackMemo(int[] wt, int[] val, int index, int capacity, int[][] dp) {

    if (capacity < 0) {
      return 0;
    }

    if (index == 0) {
      if (capacity == wt[0]) {
        dp[index][capacity] = val[0];
        return dp[index][capacity];
      } else {
        return 0;
      }
    }

    if (dp[index][capacity] != 0) {
      return dp[index][capacity];
    }

    int pickValue = 0;
    int notPickValue = 0;

    if (wt[index] <= capacity) {
      pickValue = val[index] + unboundSackMemo(wt, val, index, capacity - wt[index], dp);
    }

    notPickValue = unboundSackMemo(wt, val, index - 1, capacity, dp);

    dp[index][capacity] = pickValue > notPickValue ? pickValue : notPickValue;
    return dp[index][capacity];
  }

  private static int unboundSackTabu(int[] wt, int[] val, int capacity, int[][] dp) {

    if (capacity < 0) {
      return 0;
    }

    for (int index = 0; index <= capacity; index++) {
      if (index == wt[0]) {
        dp[0][index] = val[0];
      } else {
        dp[0][index] = 0;
      }
    }

    for (int index = 1; index <= wt.length - 1; index++) {
      for (int cap = 0; cap <= capacity; cap++) {
        int pickValue = 0;
        int notPickValue = 0;

        if (wt[index] <= cap) {
          pickValue = val[index] + dp[index][cap - wt[index]];
        }

        notPickValue = dp[index - 1][cap];

        dp[index][cap] = pickValue > notPickValue ? pickValue : notPickValue;
      }
    }

    return dp[wt.length-1][capacity];
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

      System.out.println(unboundSackTabu(wt, val, cap, dp));
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
