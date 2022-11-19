package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountEncodings {

  private static int countEncodings(String ros, String ssf) {

    if (ros == null) {
      return 0;
    }

    if (ros.equals("")) {
      // System.out.println(ssf);
      return 1;
    }

    int count = 0;

    String first = ros.substring(0, 1);
    if (Integer.parseInt(first) != 0) {
      count += countEncodings(ros.substring(1), ssf + encode(ros.substring(0, 1)));
    }

    if (ros.length() > 1) {
      String sec = ros.substring(0, 2);
      if (Integer.parseInt(sec.substring(0, 1)) != 0 && Integer.parseInt(sec) <= 26) {
        count += countEncodings(ros.substring(2), ssf + encode(sec));
      }
    }

    return count;
  }

  private static int countEncodingsMemo(String ros, String ssf, int index, int[] dp) {

    if (ros == null) {
      return 0;
    }

    if (ros.equals("")) {
      // System.out.println(ssf);
      return 1;
    }

    String first = ros.substring(0, 1);
    if (Integer.parseInt(first) != 0) {
      dp[index] += countEncodingsMemo(ros.substring(1), ssf + encode(ros.substring(0, 1)), index + 1, dp);
    }

    if (ros.length() > 1) {
      String sec = ros.substring(0, 2);
      if (Integer.parseInt(sec.substring(0, 1)) != 0 && Integer.parseInt(sec) <= 26) {
        dp[index] += countEncodingsMemo(ros.substring(2), ssf + encode(sec), index + 2, dp);
      }
    }

    return dp[index];
  }

  private static int countEncodingsTabu(String ros, int[] dp) {
    dp[0] = 1;

    if(Integer.parseInt(ros.substring(0,1))!=0){
      dp[1] = 1;
    }

    for(int i=2;i<=ros.length();i++){
      if(Integer.parseInt(ros.substring(i-1, i)) != 0){
        dp[i]+=dp[i-1];
      }

      if(i-2>=0 && Integer.parseInt(ros.substring(i-1, i)) != 0 && Integer.parseInt(ros.substring(i-2, i)) <= 26){
        dp[i]+=dp[i-2];
      }
    }
    
    return dp[ros.length()];
  }

  private static String encode(String substring) {
    return String.valueOf((char) ('a' + Integer.parseInt(substring) - 1));
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String input = reader.readLine();
      int[] dp = new int[input.length()+1];
      System.out.println(countEncodingsTabu(input,dp));
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