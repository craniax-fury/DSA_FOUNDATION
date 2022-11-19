package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSequences {

  private static int countSequences(String ros, String ssf,int index,int size) {

    if (ros == null) {
      return 0;
    }

    if (index==size && ssf.matches("a+b+c+")) {
      System.out.println(ssf);
      return 1;
    }else if(index==size){
      return 0;
    }

    int count = 0;

    count+= countSequences(ros,ssf+ros.substring(index>0?index-1:0,index),index+1,size);
    count+= countSequences(ros,ssf,index+1,size);

    return count;
  }

  // private static int countSequencesTabu(String ros, int[][] dp) {

  //   // 0:a+, 1:a+b+, 2:a+b+c+
  //   for(int i=1;i<=dp.length;i++){
  //     String sub = ros.substring(i-1, i);

  //     if(sub.equals("a")){
  //       dp[0][i]+=1;
  //     }else if(sub.equals("b")){
  //       dp[0][i]
  //     }
  //   }

  // }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String input = reader.readLine();
      int[][] dp = new int[3][input.length()+1];
      System.out.println(countSequences(input, "", 0, 0));
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