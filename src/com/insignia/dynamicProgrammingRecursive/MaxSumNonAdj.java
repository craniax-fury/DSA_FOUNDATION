package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumNonAdj {

  private static int maxSumNonAdj(int[] input, int ssf, int index, int islSelected) {

    if (input.length == 0) {
      return 0;
    }

    if (input.length == 1) {
      return input[0];
    }

    if (index == input.length - 1) {
      if (islSelected == 1) {
        return ssf;

      } else {
        return ssf + input[index];
      }
    }

    if (islSelected == 1) {
      int s_out = maxSumNonAdj(input, ssf, index + 1, 0);
      if (s_out > ssf) {
        ssf = s_out;
      }
    } else {
      int s_out = maxSumNonAdj(input, ssf + input[index], index + 1, 1);
      int ns_out = maxSumNonAdj(input, ssf, index + 1, 0);

      if (s_out > ns_out && s_out > ssf) {
        ssf = s_out;
      } else if (ns_out > s_out && ns_out > ssf) {
        ssf = ns_out;
      }
    }

    return ssf;

  }

  private static int maxSumNonAdjMemo(int[] input, int ssf, int index, int islSelected, int[][] dp) {

    if (input.length == 0) {
      return 0;
    }

    if (input.length == 1) {
      return input[0];
    }

    if (index == input.length - 1) {
      if (islSelected == 1) {
        dp[0][index] = ssf;
        return ssf;

      } else {
        dp[1][index] = ssf + input[index];
        return ssf + input[index];
      }
    }

    if (islSelected == 1) {
      int s_out = maxSumNonAdj(input, ssf, index + 1, 0);
      if (s_out > ssf) {
        ssf = s_out;
        dp[0][index] = ssf;
      }
    } else {
      int s_out = maxSumNonAdjMemo(input, ssf + input[index], index + 1, 1, dp);
      int ns_out = maxSumNonAdjMemo(input, ssf, index + 1, 0, dp);

      if (s_out > ns_out && s_out > ssf) {
        ssf = s_out;
        dp[0][index] = ssf;
      } else if (ns_out > s_out && ns_out > ssf) {
        ssf = ns_out;
        dp[1][index] = ssf;
      }
    }

    return ssf;

  }

  private static int maxSumNonAdjTabu(int[] input, int[][] dp) {

    if (input.length == 0) {
      return 0;
    }

    if (input.length == 1) {
      return input[0];
    }

    if(input[0]>0){
      dp[0][0] = input[0];
    }
    

    for (int j = 1; j < dp[0].length; j++) {
      if (input[j] >= 0 && dp[0][j] < dp[1][j - 1] + input[j]) {
        dp[0][j] = dp[1][j - 1] + input[j];
      } else if (input[j] <= 0 && dp[0][j] < dp[1][j - 1]) {
        dp[0][j] = dp[1][j - 1];
      }

      if(dp[0][j-1]>dp[1][j-1]){
        dp[1][j] = dp[0][j - 1];
      }else{
        dp[1][j] = dp[1][j-1];
      }

    }

    return dp[0][dp[0].length - 1] > dp[1][dp[0].length - 1] ? dp[0][dp[0].length - 1] : dp[1][dp[0].length - 1];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] input = new int[n];

      for (int i = 0; i < n; i++) {
        input[i] = Integer.parseInt(reader.readLine());

      }

      int[][] dp = new int[2][input.length];
      System.out.println(maxSumNonAdj(input, 0, 0, 0));
      //System.out.println(maxSumNonAdjMemo(input,0,0,0,dp));
      //display2d(dp);
      System.out.println(maxSumNonAdjTabu(input, dp));
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