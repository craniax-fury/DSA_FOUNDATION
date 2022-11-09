package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeCombo {

  private static int coinChangeComb(int[] den, int target, int ssf, String psf, int index) {
    int ans = 0;

    if (ssf == target) {
      return 1;
    }

    if (index > den.length - 1) {
      return 0;
    }

    while(index<den.length){
      if (ssf + den[index] <= target) {
        ans += coinChangeComb(den, target, ssf + den[index], psf + den[index], index);
      } 

      index++;  

    }
    
    return ans;

  }

  private static int coinChangeCombMemo(int[] den, int target, int ssf, String psf, int index,int[][] dp) {

    if (ssf == target) {
      dp[index][target]=1;
      return 1;
    }

    if (dp[index][ssf] != 0) {
      return dp[index][ssf];
    }
    
    if (index > den.length - 1) {
      return 0;
    }

    while(index<den.length){
      if (ssf + den[index] <= target) {
        dp[index][ssf]+= coinChangeCombMemo(den, target, ssf + den[index], psf + den[index], index,dp);
      } 

      index++;  

    }
    
    return dp[index-1][ssf];

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
      //dp[0] = 1;
      System.out.println(coinChangeCombMemo(den, target, 0, "", 0,dp));
      // display1d(dp);
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
