package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Display {

  public static void display(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      int rows = Integer.parseInt(reader.readLine());
      int cols = Integer.parseInt(reader.readLine());

      int[][] matrix = new int[rows][cols];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = Integer.parseInt(reader.readLine());
        }
      }

      display(matrix);
    }
  }

}