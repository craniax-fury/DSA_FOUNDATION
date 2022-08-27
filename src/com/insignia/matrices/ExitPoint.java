package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExitPoint {

  public static void exitPoint(int[][] matrix) {

    int currDir = 0; /** 0:r,1:d,2:l,3:u */
    int i = 0;
    int j = 0;

    boolean run = true;

    while (run) {

      if (matrix[i][j] == 1) {
        switch (currDir) {
          case 0:
            i++;
            currDir = 1;
            break;
          case 1:
            j--;
            currDir = 2;
            break;
          case 2:
            i--;
            currDir = 3;
            break;
          case 3:
            j++;
            currDir = 0;
            break;
        }
      } else {
        switch (currDir) {
          case 0:
            j++;
            break;
          case 1:
            i++;
            break;
          case 2:
            j--;
            break;
          case 3:
            i--;
        }

        if (i > matrix.length - 1) {
          i--;
          System.out.println(i);
          System.out.println(j);
          run = false;
        } else if (i < 0) {
          i++;
          System.out.println(i);
          System.out.println(j);
          run = false;
        } else if (j > matrix[0].length - 1) {
          j--;
          System.out.println(i);
          System.out.println(j);
          run = false;
        } else if (j < 0) {
          j++;
          System.out.println(i);
          System.out.println(j);
          run = false;
        }

      }
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

      exitPoint(matrix1);
    }
  }
}