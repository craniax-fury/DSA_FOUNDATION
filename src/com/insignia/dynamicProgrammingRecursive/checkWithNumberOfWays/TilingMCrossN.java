package com.insignia.dynamicProgrammingRecursive.checkWithNumberOfWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TilingMCrossN {

  private static int tilingMCrossN(int m,int n) {
    if (n<m) {
      return 1;
    }

    if (n == m) {
      return 2;
    }

    int ans = tilingMCrossN(m,n - 1) + tilingMCrossN(m,n - m);

    return ans;
  }

  private static int tilingMCrossNMemo(int m,int n,int[] dp) {
    if (n<m) {
      dp[n] = 1;
      return dp[n];
    }

    if (n == m) {
      dp[n] = 2;
      return dp[n];
    }

    if(dp[n]!=0){
      return dp[n];
    }

    int ans = tilingMCrossNMemo(m,n - 1,dp) + tilingMCrossNMemo(m,n - m,dp);
    dp[n] = ans;
    return dp[n];
  }

  private static int tilingMCrossNTabu(int m,int n,int[] dp) {
    if(n<m){
      return 1;
    }

    if(n==m){
      return 2;
    }

    for(int i=1;i<m;i++) {
      dp[i] = 1;
    }

    dp[m]=2;         
    for(int j=m+1;j<=n;j++){
      dp[j] = dp[j - 1] + dp[j - m];
    }

    return dp[n];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int m = Integer.parseInt(reader.readLine());
      //System.out.println(tilingMCrossN(m,n));
      int[] dp = new int[n + 1];

      //System.out.println(tilingMCrossNMemo(m,n, dp));      
      System.out.println(tilingMCrossNTabu(m,n, dp));
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















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    

    