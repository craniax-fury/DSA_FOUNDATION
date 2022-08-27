package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalTraversal {

  public static void diagonalTraversal(int[][] matrix) {
    int minRow = 0;
    int minCol = 0;

    int maxRow = matrix.length - 1;
    int maxCol = matrix[0].length - 1;

    while (maxRow>=0 && minCol<matrix.length) {
      for (int i = minRow, j = minCol; i <= maxRow && j <= maxCol; i++, j++) {
        System.out.println(matrix[i][j]);
      }
      
      maxRow--;
      minCol++;
    }
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

      diagonalTraversal(matrix1);
    }
  }

}