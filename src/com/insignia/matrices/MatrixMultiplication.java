package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixMultiplication {

  public static void display(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void multiply(int[][] one, int[][] two) {

    if (one[0].length != two.length) {
      System.out.println("Invalid input");
      return;
    }

    int[][] result = new int[one.length][two[0].length];
  
    for(int i=0;i<result.length;i++){
      for(int j=0;j<result[0].length;j++){
        for(int k=0;k<one[0].length;k++){
          result[i][j]+=one[i][k]*two[k][j];
        }
      }
    }

    display(result);
  }



  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      int rows1 = Integer.parseInt(reader.readLine());
      int cols1 = Integer.parseInt(reader.readLine());

      int[][] matrix1 = new int[rows1][cols1];

      for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols1; j++) {
          matrix1[i][j] = Integer.parseInt(reader.readLine());
        }
      }

      int rows2 = Integer.parseInt(reader.readLine());
      int cols2 = Integer.parseInt(reader.readLine());

      int[][] matrix2 = new int[rows2][cols2];

      for (int i = 0; i < rows2; i++) {
        for (int j = 0; j < cols2; j++) {
          matrix2[i][j] = Integer.parseInt(reader.readLine());
        }
      }

      multiply(matrix1, matrix2);
    }
  }

}