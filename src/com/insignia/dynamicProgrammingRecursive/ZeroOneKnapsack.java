package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneKnapsack {

  private static int knapSack01(int[] wt, int[] val, int index, int cap, int vsf) {

    if (cap == 0) {
      return vsf;
    }
    
    if (index < 0) {
      return 0;
    }

    if (wt[index] > cap) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int pickValue = 0;
    int notPickValue = 0;

    pickValue = knapSack01(wt, val, index - 1, cap - wt[index], vsf + val[index]);

    if (pickValue > max) {
      max = pickValue;
    }

    notPickValue = knapSack01(wt, val, index - 1, cap, vsf);

    if (notPickValue > max) {
      max = notPickValue;
    }

    return max;
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] val = new int[n];

      String[] vals = reader.readLine().split(" ");
      
      for (int i = 0; i < n; i++) {
        val[i] = Integer.parseInt(vals[i]);
      }

      int[] wt = new int[n];
      
      String[] wts = reader.readLine().split(" ");
      
      for (int i = 0; i < n; i++) {
        wt[i] = Integer.parseInt(wts[i]);
      }

      int cap = Integer.parseInt(reader.readLine());

      System.out.println(knapSack01(wt, val, n - 1, cap, 0));
      //display2d(dp);
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
