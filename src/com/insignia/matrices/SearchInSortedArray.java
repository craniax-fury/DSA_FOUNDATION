package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchInSortedArray {
  public static void searchSorted(int[][] matrix, int ele) {
    int str = 0;
    int stc = matrix[0].length-1;

    while(str<matrix.length && matrix[str][stc]<ele){
      str++;
    }
    
    if(str==matrix.length){
      str--;
    }
    

    if(str==matrix.length-1 && ele>matrix[str][stc]){
      System.out.println("Not Found");
      return;
    }

    for(int i=str,j=0;j<stc;j++){
      if(matrix[i][j]==ele){
        System.out.println(i);
        System.out.println(j);
        return;
      }
    }

    System.out.println("Not Found");
  }

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      int rows1 = Integer.parseInt(reader.readLine());

      int[][] matrix1 = new int[rows1][rows1];

      for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < rows1; j++) {
          matrix1[i][j] = Integer.parseInt(reader.readLine());
        }
      }
      int ele = Integer.parseInt(reader.readLine());
      searchSorted(matrix1,ele);
    }
  }
}