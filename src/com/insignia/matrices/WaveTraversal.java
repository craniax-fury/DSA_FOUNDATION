package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WaveTraversal {

  public static void waveTraversal(int[][] matrix) {
    int row = 0;
    int col = 0;

    int np = 0;
    int noe = matrix.length * matrix[0].length;
    int i = 0;

    while (np != noe) {

      for (int j = 0; j < matrix.length; j++) {
        System.out.println(matrix[row][col]);
        np++;
        if (i % 2 == 0) {
          row++;
        }else{
          row--;
        }
      }

      if(i%2==0){
        row--;
      }else{
        row++;
      }

      i++;
      col++;
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

      waveTraversal(matrix1);
    }
  }

}