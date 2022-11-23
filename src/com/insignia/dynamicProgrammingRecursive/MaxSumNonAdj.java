package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumNonAdj {

  private static int maxSumNonAdj(int[] input, int index) {

    if (input.length == 0 || index < 0) {
      return 0;
    }

    if (input.length == 1 || index == input.length - 1) {
      return input[0];
    }

    int incl = 0;

    if (input[index] >= 0) {
      incl = maxSumNonAdj(input, index - 2) + input[index];
    }

    int excl = maxSumNonAdj(input, index - 1);

    return Math.max(incl, excl);
  }

  private static int maxSumNonAdjMemo(int[] input, int index, int[] dp) {

    if (input.length == 0 || index < 0) {
      return 0;
    }

    if (input.length == 1 || index == 0) {
      return input[0];
    }

    if (dp[index] != -1) {
      return dp[index];
    }

    int incl = 0;

    if (input[index] >= 0) {
      incl = maxSumNonAdjMemo(input, index - 2, dp) + input[index];
    }

    int excl = maxSumNonAdjMemo(input, index - 1, dp);

    dp[index] = Math.max(incl, excl);
    return dp[index];
  }

  private static int maxSumNonAdjTabu(int[] input, int[] dp) {

    if (input[0] > 0) {
      dp[0] = input[0];

    } else {
      dp[0] = 0;
    }

    dp[1] = Math.max(dp[0], input[1]);
    int incl = 0;

    for (int i = 2; i < input.length; i++) {
      if (input[i] >= 0) {
        incl = dp[i - 2] + input[i];
      }

      int excl = dp[i - 1];

      dp[i] = Math.max(incl, excl);
    }

    return dp[input.length - 1];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] input = new int[n];

      for (int i = 0; i < n; i++) {
        input[i] = Integer.parseInt(reader.readLine());

      }

      int[] dp = new int[input.length];
      Arrays.fill(dp, -1);

      // System.out.println(maxSumNonAdj(input, n - 1));
      // System.out.println(maxSumNonAdjMemo(input, n - 1, dp));
      System.out.println(maxSumNonAdjTabu(input, dp));
      display1d(dp);
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