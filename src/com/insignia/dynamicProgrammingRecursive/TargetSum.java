package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TargetSum {

  private static boolean isSubsetSumTarget(int[] set, int index, int target, int ssf, int[][] dp) {

    if (ssf == target) {
      dp[index - 1][ssf] = 1;
      return true;
    }

    if (index >= set.length) {
      return false;
    }

    if (dp[index][ssf] != -1) {
      if (dp[index][ssf] == 0) {
        return false;
      } else {
        return true;
      }
    }

    if (ssf + set[index] <= target) {
      boolean val = isSubsetSumTarget(set, index + 1, target, ssf + set[index], dp);
      if (val) {
        dp[index - 1][ssf] = 1;
        return true;
      } else {
        dp[index - 1][ssf] = 0;
      }
    }

    boolean val = isSubsetSumTarget(set, index + 1, target, ssf, dp);

    if (val) {
      dp[index - 1][ssf] = 1;
      return true;
    } else {
      dp[index - 1][ssf] = 0;
    }

    return false;

  }

  private static boolean isSubsetSumTargetTabu(int[] set, int target, int[][] dp) {
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {

        if (j == set[i]) {
          dp[i][j] = 1;
        } else if (j - set[i] >= 0 && dp[i - 1][j - set[i]] == 1) {
          dp[i][j] = 1;

        } else if (dp[i - 1][j] == 1) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = 0;
        }

        if (j == target && dp[i][j] == 1) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] set = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        set[i] = Integer.parseInt(reader.readLine());
      }

      int target = Integer.parseInt(reader.readLine());

      int[][] dp = new int[n + 1][target + 1];

      for (int[] arr : dp) {
        Arrays.fill(arr, -1);
      }

      for (int i = 0; i <= n; i++) {
        dp[i][0] = 1;
      }

      System.out.println(isSubsetSumTargetTabu(set, target, dp));
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
