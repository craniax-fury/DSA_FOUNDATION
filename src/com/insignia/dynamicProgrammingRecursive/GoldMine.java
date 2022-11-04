package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldMine {

  private static int maxGoldDigger(int sr, int sc, int dr, int dc, int[][] mine, int[][] dp) {

    if (sc == dc) {
      dp[sr][sc] = mine[sr][sc];
      return dp[sr][sc];
    }

    if (dp[sr][sc] != 0) {
      return dp[sr][sc];
    }

    if (sr - 1 >= 0 && sc + 1 <= dc) {
      int value = maxGoldDigger(sr - 1, sc + 1, mine.length - 1, mine[0].length - 1, mine, dp);
      if (value + mine[sr][sc] > dp[sr][sc]) {
        dp[sr][sc] = value + mine[sr][sc];
      }
    }

    if (sc + 1 <= dc) {
      int value = maxGoldDigger(sr, sc + 1, mine.length - 1, mine[0].length - 1, mine, dp);
      if (value + mine[sr][sc] > dp[sr][sc]) {
        dp[sr][sc] = value + mine[sr][sc];
      }
    }

    if (sr + 1 <= dr && sc + 1 <= dc) {
      int value = maxGoldDigger(sr + 1, sc + 1, mine.length - 1, mine[0].length - 1, mine, dp);
      if (value + mine[sr][sc] > dp[sr][sc]) {
        dp[sr][sc] = value + mine[sr][sc];
      }
    }

    return dp[sr][sc];
  }

  private static int goldDigger(int[][] mine, int[][] dp) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < mine.length; i++) {
      int value = maxGoldDigger(i, 0, mine.length - 1, mine[0].length - 1, mine, dp);
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  private static int maxGoldDiggerTabu(int sr, int sc, int dr, int dc, int[][] mine, int[][] dp) {
    for (int j = sc; j >= 0; j--) {

      for (int i = sr; i <= dr; i++) {

        if (j == dc) {
          dp[i][j] = mine[i][j];
          continue;
        }

        if (i - 1 >= 0 && j + 1 <= dc) {
          int value = dp[i - 1][j + 1];
          if (value + mine[i][j] > dp[i][j]) {
            dp[i][j] = value + mine[i][j];
          }
        }

        if (j + 1 <= dc) {
          int value = dp[i][j + 1];
          if (value + mine[i][j] > dp[i][j]) {
            dp[i][j] = value + mine[i][j];
          }
        }

        if (i + 1 <= dr && j + 1 <= dc) {
          int value = dp[i + 1][j + 1];
          if (value + mine[i][j] > dp[i][j]) {
            dp[i][j] = value + mine[i][j];
          }
        }
      }
    }

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < mine.length; i++) {
      if (dp[i][0] > max) {
        max = dp[i][0];
      }
    }
    return max;

  }

  private static int goldDiggerTabu(int[][] mine, int[][] dp) {

    return maxGoldDiggerTabu(0, mine[0].length - 1, mine.length - 1, mine[0].length - 1, mine, dp);
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int m = Integer.parseInt(reader.readLine());
      int[][] mine = new int[n][m];

      for (int i = 0; i < n; i++) {
        String value[] = reader.readLine().split(" ");
        for (int j = 0; j < m; j++) {
          mine[i][j] = Integer.parseInt(value[j]);
        }
      }

      int[][] dp = new int[n][m];

      System.out.println(goldDiggerTabu(mine, dp));

    }
  }

  private static void display1d(int[] soln) {
    for (int ele : soln) {
      System.out.print(ele + " ");
    }
  }

  private static void display2d(int[][] soln) {
    for (int[] eleArr : soln) {
      display1d(eleArr);
      System.out.println();
    }
  }

}
