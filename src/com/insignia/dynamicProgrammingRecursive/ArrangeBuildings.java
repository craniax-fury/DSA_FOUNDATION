package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrangeBuildings {

  private static long arrangeBuildings(int n, int isLBuilding, int bsf, String ab) {

    if (n < 0) {
      return 0;
    }

    if (n == 1) {
      return 2;
    }

    if (bsf == n) {
      System.out.println(ab + " :" + isLBuilding);
      return 1;
    }

    long count = 0;

    if (isLBuilding == 1) {
      count += arrangeBuildings(n, 0, bsf + 1, ab + "s ");
    } else {
      count += arrangeBuildings(n, 0, bsf + 1, ab + "s ");
      count += arrangeBuildings(n, 1, bsf + 1, ab + "b ");
    }

    return count;
  }

  private static long arrangeBuildingsMemo(int n, int isLBuilding, int bsf, String ab, long[][] dp) {

    if (n < 0) {
      return 0;
    }

    if (n == 1) {
      return 2;
    }

    if (bsf == n) {
      System.out.println(ab);
      return 1;
    }

    if (dp[isLBuilding][bsf] != 0) {
      return dp[isLBuilding][bsf];
    }

    if (isLBuilding == 1) {
      dp[isLBuilding][bsf] += arrangeBuildingsMemo(n, 0, bsf + 1, ab + "s ", dp);
    } else {
      dp[isLBuilding][bsf] += arrangeBuildingsMemo(n, 0, bsf + 1, ab + "s ", dp);
      dp[isLBuilding][bsf] += arrangeBuildingsMemo(n, 1, bsf + 1, ab + "b ", dp);
    }

    return dp[isLBuilding][bsf];
  }

  private static long arrangeBuildingsTabu(int n, long[][] dp) {

    if (dp[0][n] != 0) {
      return dp[0][n] + dp[1][n];
    }

    dp[0][1] = 1;
    dp[1][1] = 1;

    for (int j = 2; j <= n; j++) {
      dp[1][j] += dp[0][j - 1];

      dp[0][j] += dp[0][j - 1] + dp[1][j - 1];
    }

    return dp[0][n] + dp[1][n];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());

      long[][] dp = new long[2][n + 1];
      // System.out.println(knapSack01Memo(wt, val, n - 1, cap,dp));

      // System.out.println(arrangeBuildings(n,0,0,"") * arrangeBuildings(n,0,0,""));
      long ans = arrangeBuildingsTabu(n, dp);
      ans=ans*ans;
      System.out.println(ans);
      display2d(dp);
    }
  }

  private static void display1d(long[] soln) {
    for (long ele : soln) {
      if (ele == -1l) {
        System.out.print(ele + " ");
      } else {
        System.out.print(" " + ele + " ");
      }

    }
  }

  private static void display2d(long[][] soln) {
    for (long[] eleArr : soln) {
      display1d(eleArr);
      System.out.println();
    }
  }

}
