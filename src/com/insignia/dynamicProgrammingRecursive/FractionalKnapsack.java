package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FractionalKnapsack {

  private static double fractionalSack(double[] wt, double[] val, int index, int capacity) {

    if (capacity <= 0) {
      return 0;
    }

    if (index == 0) {
      if (capacity < wt[0]) {
        return convertAmount(val[0] / wt[0]) * capacity;
      } else {
        return val[0];
      }
    }

    double pickValue = 0;
    double notPickValue = 0;

    if (capacity < wt[index]) {
      pickValue = convertAmount(val[index] / wt[index]) * capacity + fractionalSack(wt, val, index - 1, 0);
    } else {
      pickValue = convertAmount(val[index] + fractionalSack(wt, val, index - 1, capacity - (int) wt[index]));
    }

    notPickValue = convertAmount(fractionalSack(wt, val, index - 1, capacity));

    return pickValue > notPickValue ? pickValue : notPickValue;
  }

  private static double fractionalSackMemo(double[] wt, double[] val, int index, int capacity, double[][] dp) {

    if (capacity <= 0) {
      return 0;
    }

    if (index == 0) {
      if(capacity<wt[0]){
        return convertAmount(val[0]/wt[0]) * capacity;
      }else{
        return val[0];
      }
    }

    double pickValue = 0;
    double notPickValue = 0;

    if(capacity<wt[index]){
      pickValue = convertAmount(val[index]/wt[index]) * capacity  + fractionalSackMemo(wt, val, index - 1, 0,dp);
    }else{
      pickValue = convertAmount(val[index] + fractionalSackMemo(wt, val, index - 1, capacity - (int) wt[index],dp));
    }
    
    notPickValue = convertAmount(fractionalSackMemo(wt, val, index - 1, capacity,dp));

    dp[index][capacity] = pickValue > notPickValue ? pickValue : notPickValue;
    return dp[index][capacity];
  }

  private static double convertAmount(double value){
    return BigDecimal.valueOf(value).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
  }
  private static double fractionalSackTabu(double[] wt, double[] val, int capacity, double[][] dp) {

    if (capacity <= 0) {
      return 0;
    }

    for(int index=0;index<=capacity;index++) {
      if(index<wt[0]){
        dp[0][index] = convertAmount(val[0]/wt[0]) * index;
      }else{
        dp[0][index] = val[0];
      }
    }

    for(int index=1;index<wt.length;index++){
      for(int cap=0;cap<=capacity;cap++){
        double pickValue = 0;
        double notPickValue = 0;
    
        if(cap<wt[index]){
          pickValue = convertAmount(val[index]/wt[index]) * cap  + dp[index - 1][0];
        }else{
          pickValue = convertAmount(val[index] + dp[index - 1][cap - (int) wt[index]]);
        }
        
        notPickValue = dp[index - 1][cap];
    
        dp[index][cap] = convertAmount(pickValue > notPickValue ? pickValue : notPickValue);
        
      }
    }
    return dp[wt.length-1][capacity];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      double[] val = new double[n];

      String[] vals = reader.readLine().split(" ");

      for (int i = 0; i < n; i++) {
        val[i] = Integer.parseInt(vals[i]);
      }

      double[] wt = new double[n];

      String[] wts = reader.readLine().split(" ");

      for (int i = 0; i < n; i++) {
        wt[i] = Double.parseDouble(wts[i]);
      }

      int cap = Integer.parseInt(reader.readLine());

      double[][] dp = new double[n][cap + 1];
      // System.out.println(knapSack01Memo(wt, val, n - 1, cap,dp));

      double ans = fractionalSackTabu(wt, val, cap,dp);
      System.out.println(ans);
      display2d(dp);
    }
  }

  private static void display1d(double[] soln) {
    for (double ele : soln) {
      if (ele == -1) {
        System.out.print(ele + " ");
      } else {
        System.out.print(" " + ele + " ");
      }

    }
  }

  private static void display2d(double[][] soln) {
    for (double[] eleArr : soln) {
      display1d(eleArr);
      System.out.println();
    }
  }

}
