package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeCombo {

  private static int coinChangeComb(int[] den, int target, int ssf, String psf, int index) {
    int ans = 0;

    if (index > den.length - 1) {
      return 0;
    }

    if (ssf == target) {
      return 1;
    }

    while (index != den.length - 1) {
      if (ssf + den[index] <= target) {
        ans += coinChangeComb(den, target, ssf + den[index], psf + den[index], index);
      }

      index++;
    }

    if (ssf < target && (target - ssf) % den[index] == 0) {
      ans += 1;
    }

    return ans;
  }

  private static int coinChangeCombMemo(int[] den, int target, int ssf, String psf, int index, int[][] dp) {

    if (index > den.length - 1) {
      return 0;
    }

    if (dp[index][ssf] != 0) {
      return dp[index][ssf];
    }

    if (ssf == target) {
      dp[index][ssf] = 1;
      return 1;
    }

    int i = index;

    while (i != den.length - 1) {
      if (ssf + den[i] <= target) {
        int ans = 0;

        ans = coinChangeCombMemo(den, target, ssf + den[i], psf + den[i], i, dp);

        dp[index][ssf] += ans;

      }

      i++;

    }

    if (ssf != target && (target - ssf) % den[i] == 0) {
      dp[index][ssf] += 1;
    }

    return dp[index][ssf];

  }

  private static int coinChangeCombTabu(int[] den, int target, int ssf, String psf, int index, int[][] dp) {

    for (int i = 0; i < den.length; i++) {
      for (int j = 1; j <= target; j++) {
        if(j-den[i]>=0){
          dp[i][j]+=dp[i][j-den[i]];
        }

        if(i>0){
          dp[i][j]+=dp[i-1][j];
        }
      }
    }

    return dp[den.length-1][target];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] den = new int[n];

      for (int i = 0; i < n; i++) {
        den[i] = Integer.parseInt(reader.readLine());
      }

      int target = Integer.parseInt(reader.readLine());
      int[][] dp = new int[den.length][target + 1];
      
      for(int i=0;i<den.length;i++){
        dp[i][0]=1;
      }

      System.out.println(coinChangeCombTabu(den, target, 0, "", 0, dp));
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
