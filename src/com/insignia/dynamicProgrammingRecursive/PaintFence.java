package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintFence {

  private static int paintFence(int fence, int colors) {

    if(fence==0){
      return 0;
    }

    if(fence==1){
      return colors;
    }

    if(fence==2){
      return colors + colors*(colors-1);
    }

    int same = paintFence(fence-2,colors) * (colors-1); 
    int diff = paintFence(fence-1, colors)* (colors-1);

    return same+diff;
  }

  private static int paintFenceMemo(int fence, int colors,int[] dp) {

    if(fence==0){
      dp[fence] = 0;
      return dp[fence];
    }

    if(fence==1){
      dp[fence] = colors;
      return dp[fence];
    }

    if(fence==2){
      dp[fence] = colors + colors*(colors-1);
      return dp[fence];
    }

    if(dp[fence]!=0){
      return dp[fence];
    }

    int same = paintFenceMemo(fence-2,colors,dp) * (colors-1); 
    int diff = paintFenceMemo(fence-1, colors,dp)* (colors-1);

    dp[fence] = same+diff;
    return dp[fence];
  }

  private static int paintFenceTabu(int fence, int colors,int[] dp) {

    dp[1] = colors;
    dp[2] = colors + colors*(colors-1);

    for(int i=3;i<=fence;i++){
      int same = dp[i-2] * (colors-1); 
      int diff = dp[i-1] * (colors-1);
  
      dp[i] = same+diff;
    }
    
    return dp[fence];
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int fence =  Integer.parseInt(reader.readLine());
      int colors = Integer.parseInt(reader.readLine());

      int[] dp = new int[fence+1]; 
      //System.out.println(paintFenceMemo(fence,colors,dp));
      System.out.println(paintFenceTabu(fence,colors,dp));
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