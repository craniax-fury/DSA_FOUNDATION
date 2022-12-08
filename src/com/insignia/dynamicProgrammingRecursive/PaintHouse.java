package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintHouse {

  private static int paintHouse(int[][] input, int index, int house) {

    if (house < 0) {
      return 0;
    }
    int red=0;
    int green=0;
    int blue=0;

    if (index == 0) {
      int rg = paintHouse(input, 1, house - 1) + input[house][1];
      int rb = paintHouse(input, 2, house - 1) + input[house][2];
      red = Math.min(rg, rb);
      return red;
    } else if (index == 1) {
      int gr = paintHouse(input, 0, house - 1) + input[house][0];
      int gb = paintHouse(input, 2, house - 1) + input[house][2];
      green = Math.min(gr, gb);
      return green;
    } else if (index == 2) {
      int br = paintHouse(input, 0, house - 1) + input[house][0];
      int bg = paintHouse(input, 1, house - 1) + input[house][1];
      blue = Math.min(br, bg);
      return blue;
    } else {
      red = paintHouse(input, 0, house - 1) + input[house][0];
      green = paintHouse(input, 1, house - 1) + input[house][1];
      blue = paintHouse(input, 2, house - 1) + input[house][2];
      return Math.min(Math.min(red, blue), green);

    }

  }

  private static int paintHouseMemo(int[][] input, int index, int house, int[][] dp) {

    if (house < 0) {
      return 0;
    }

    if (index != -1 && dp[house][index] != 0) {
      return dp[house][index];
    }

    if (index == 0) {
      int rg = paintHouseMemo(input, 1, house - 1, dp) + input[house][1];
      int rb = paintHouseMemo(input, 2, house - 1, dp) + input[house][2];
      dp[house][index] = Math.min(rg, rb);
      return dp[house][index];
    } else if (index == 1) {
      int gr = paintHouseMemo(input, 0, house - 1, dp) + input[house][0];
      int gb = paintHouseMemo(input, 2, house - 1, dp) + input[house][2];
      dp[house][index] = Math.min(gr, gb);
      return dp[house][index];
    } else if (index == 2) {
      int br = paintHouseMemo(input, 0, house - 1, dp) + input[house][0];
      int bg = paintHouseMemo(input, 1, house - 1, dp) + input[house][1];
      dp[house][index] = Math.min(br, bg);
      return dp[house][index];
    } else {
      dp[house][0] = paintHouseMemo(input, 0, house - 1, dp) + input[house][0];
      dp[house][1] = paintHouseMemo(input, 1, house - 1, dp) + input[house][1];
      dp[house][2] = paintHouseMemo(input, 2, house - 1, dp) + input[house][2];
      return Math.min(Math.min(dp[house][0], dp[house][1]), dp[house][2]);
    }

  }

  private static int paintHouseTabu(int[][] input, int index, int house,int[][] dp) {


    for (int j = 0; j < input[0].length; j++) {
      dp[0][j] = input[0][j];
    }

    for (int i = 1; i < house; i++) {
      for (int j = 0; j < input[0].length; j++) {
        dp[i][j] = input[i][j] + findMinNMinus1Level(i - 1, j, dp);
      }
    }

    return findMinNMinus1Level(house - 1, dp[0].length + 1, dp);
  }

  private static int findMinNMinus1Level(int i, int skip, int[][] dp) {
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < dp[0].length; j++) {
      if (j == skip) {
        continue;
      }

      if (dp[i][j] < min) {
        min = dp[i][j];
      }

    }

    return min;
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String[] s1 = reader.readLine().split(" ");
      int n = Integer.parseInt(s1[0]);
      int colors = Integer.parseInt(s1[1]);
      int[][] input = new int[n][colors];

      for (int i = 0; i < n; i++) {
        String[] s = reader.readLine().split(" ");
        for (int j = 0; j < colors; j++) {
          input[i][j] = Integer.parseInt(s[j]);
        }
      }

      //System.out.println(paintHouse(input, -1, n - 1));

      int[][] dp = new int[input.length][colors];
      // System.out.println(paintHouseMemo(input, -1, n - 1, dp));

      System.out.println(paintHouseTabu(input, -1, n,dp));
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