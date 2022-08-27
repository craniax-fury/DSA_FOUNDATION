package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellRotate {
  public static void display(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void rotateShell(int[][] matrix, int rotations, int shell) {
    int smnr = shell - 1; // shellMinRow
    int smnc = shell - 1; // shellMinCol
    int smxr = matrix.length - shell; // shellMaxRow
    int smxc = matrix[0].length - shell; // shellMaxCol

    int[] oned = getOnedArrayOfShellEle(matrix, smnr, smnc, smxr, smxc);

    rotate(oned, rotations);

    fillShellFromOned(matrix, oned, smnr, smnc, smxr, smxc);

    display(matrix);
  }

  private static void rotate(int[] arr, int rotations) {

    int aR = 0;

    if (rotations % arr.length == 0) {
      return;
    } else if (rotations < 0) {
      aR = arr.length + (rotations % arr.length);
    } else {
      aR = rotations % arr.length;
    }

    reverse(arr, 0, arr.length - aR - 1);

    reverse(arr, arr.length - aR, arr.length - 1);

    reverse(arr, 0, arr.length - 1);
  }

  private static void reverse(int[] arr, int i, int j) {
    int li = i;
    int ri = j;

    while (li < ri) {
      int temp = arr[li];
      arr[li] = arr[ri];
      arr[ri] = temp;

      li++;
      ri--;
    }
  }

  private static void fillShellFromOned(int[][] matrix, int[] oned, int smnr, int smnc, int smxr, int smxc) {

    boolean isRightSameAsLeft = false;
    boolean isTopSameAsBottom = false;

    if (smxc == smnc) {
      isRightSameAsLeft = true;
    }

    if (smxr == smnr) {
      isTopSameAsBottom = true;
    }

    int k = 0;

    // put left wall ele
    for (int i = smnr; i <= smxr; i++) {
      matrix[i][smnc] = oned[k];
      k++;
    }

    smnc++;

    // put bottom wall ele
    for (int i = smnc; i <= smxc; i++) {
      matrix[smxr][i] = oned[k];
      k++;
    }

    smxr--;

    if (!isRightSameAsLeft) {
      // put right wall ele, only when it is not same as left wall
      for (int i = smxr; i >= smnr; i--) {
        matrix[i][smxc] = oned[k];
        k++;
      }
    }

    smxc--;

    if (!isTopSameAsBottom) {
      // put top wall ele, only if it is not same as bottom wall
      for (int i = smxc; i >= smnc; i--) {
        matrix[smnr][i] = oned[k];
        k++;
      }
    }
  }

  private static int[] getOnedArrayOfShellEle(int[][] matrix, int smnr, int smnc, int smxr, int smxc) {
    boolean isRightSameAsLeft = false;
    boolean isTopSameAsBottom = false;

    if (smxc == smnc) {
      isRightSameAsLeft = true;
    }

    if (smxr == smnr) {
      isTopSameAsBottom = true;
    }

    int noe = (smxr - smnr + 1) + (smxc - smnc);

    if (!isTopSameAsBottom) {
      noe += smxc - smnc - 1;
    }

    if (!isRightSameAsLeft) {
      noe += (smxr - smnr);
    }

    int[] result = new int[noe];

    int k = 0;

    // put left wall ele
    for (int i = smnr; i <= smxr; i++) {
      result[k] = matrix[i][smnc];
      k++;
    }

    smnc++;

    // put bottom wall ele
    for (int i = smnc; i <= smxc; i++) {
      result[k] = matrix[smxr][i];
      k++;
    }

    smxr--;

    if (!isRightSameAsLeft) {
      // put right wall ele, only when it is not same as left wall
      for (int i = smxr; i >= smnr; i--) {
        result[k] = matrix[i][smxc];
        k++;
      }
    }

    smxc--;

    if (!isTopSameAsBottom) {
      // put top wall ele , only if its not same as bottom wall
      for (int i = smxc; i >= smnc; i--) {
        result[k] = matrix[smnr][i];
        k++;
      }
    }

    return result;
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

      int s = Integer.parseInt(reader.readLine());
      int r = Integer.parseInt(reader.readLine());

      rotateShell(matrix1, r, s);
    }
  }
}