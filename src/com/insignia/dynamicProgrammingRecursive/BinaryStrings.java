package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryStrings {

  private static int binaryStrings(int n,int lsf,int lim,String ssf) {
    
    if(n==0){
      return 0;
    }

    if(n==1){
      return 2;
    }

    if(lsf==n){
      System.out.println(ssf);
      return 1;
    }

    int count = 0;

    if(lim==1){
      count+=binaryStrings(n, lsf+1,0,"0"+ssf);
      count+=binaryStrings(n, lsf+1, 1,"1"+ssf);
    }else{
      count+=binaryStrings(n, lsf+1,1,"1"+ssf);
    }

    return count;
  }

  private static int binaryStringsMemo(int n,int lsf,int lim,String ssf,int[][] dp) {
    
    if(n==0){
      return 0;
    }

    if(n==1){
      return 2;
    }

    if(lsf==n+1){
      System.out.println(ssf);
      return 1;
    }

    if(lim==1){
      dp[0][lsf]+=binaryStringsMemo(n, lsf+1,0,"0"+ssf,dp);
      dp[1][lsf]+=binaryStringsMemo(n, lsf+1, 1,"1"+ssf,dp);
    }else{
      dp[1][lsf]+=binaryStringsMemo(n, lsf+1,1,"1"+ssf,dp);
    }

    return dp[0][n]+dp[1][n];
  }

  private static int binaryStringsTabu(int n,String ssf,int[][] dp) {
    
    if(n==0){
      return 0;
    }

    if(n==1){
      return 2;
    }

    dp[0][1]=1;
    dp[1][1]=1;

    for(int lsf=2;lsf<dp[0].length;lsf++){
    
      dp[0][lsf]+=dp[1][lsf-1];
      dp[1][lsf]+=dp[1][lsf-1] + dp[0][lsf-1];
      
  }

    return dp[0][n]+dp[1][n];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());

      int[][] dp = new int[2][n+1];
      // System.out.println(knapSack01Memo(wt, val, n - 1, cap,dp));

      System.out.println(binaryStringsTabu(n,"",dp));
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
