package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateBy90 {
  public static void display(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void rotate(int[][] matrix) {

    int[][] result = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      int k = matrix.length-1;
      for (int j = 0; j < matrix[0].length; j++) {
        result[i][j] = matrix[k][i];
        k--;
      }
    }
    display(result);
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

      rotate(matrix1);
    }
  }
}