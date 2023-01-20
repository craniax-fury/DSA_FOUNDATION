package com.insignia.dynamicProgrammingRecursive.checkWithNumberOfWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2Cross1 {

  private static int tiling2Cross1(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    if (n == 3) {
      return 3;
    }

    int ans = tiling2Cross1(n - 1) + tiling2Cross1(n - 2);

    return ans;
  }

  private static int tiling2Cross1Memo(int n, int[] dp) {
    if (n == 0) {
      return 0;
    }

    if (n == 1 || n == 2 || n == 3) {
      dp[n] = n;
      return dp[n];
    }

    if (dp[n] != 0) {
      return dp[n];
    }

    dp[n] = tiling2Cross1Memo(n - 1, dp) + tiling2Cross1Memo(n - 2, dp);

    return dp[n];
  }

  private static int tiling2Cross1Tabu(int n, int[] dp) {

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      // System.out.println(paintFenceMemo(fence,colors,dp));
      int[] dp = new int[n + 1];

      //System.out.println(tiling2Cross1Memo(n, dp));
      System.out.println(tiling2Cross1Tabu(n, dp));
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