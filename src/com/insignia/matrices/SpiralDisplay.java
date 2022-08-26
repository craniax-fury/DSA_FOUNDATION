package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiralDisplay {

  public static void spiralDisplay(int[][] matrix) {
    int minRow = 0;
    int minCol = 0;

    int maxRow = matrix.length-1;
    int maxCol = matrix[0].length-1;

    int np = 0;

    int noe=matrix.length * matrix[0].length;

    while (!(np >= noe)) {
      /**
       * print left wall
       */

      for (int i = minRow, j = minCol; i <= maxRow && !(np >= noe); i++) {
        System.out.println(matrix[i][j]);
        np++;
      }

      minCol += 1;

      /**
       * print bottom wall
       */

      for (int i = maxRow, j = minCol; j <= maxCol && !(np >= noe); j++) {
        System.out.println(matrix[i][j]);
        np++;
      }

      maxRow -= 1;

      /**
       * print right wall
       */

      for (int i = maxRow, j = maxCol; i >= minRow && !(np >= noe); i--) {
        System.out.println(matrix[i][j]);
        np++;
      }

      maxCol -= 1;

      /**
       * print top wall
       */

      for (int i = minRow, j = maxCol; j >= minCol && !(np >= noe); j--) {
        System.out.println(matrix[i][j]);
        np++;
      }

      minRow += 1;
    }
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

      spiralDisplay(matrix1);
    }
  }

}