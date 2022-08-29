package com.insignia.matrices.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * binaries hold the permutations
 */
public class PermutationsOfString {
  public static void permutationsIterative(String str) {
    StringBuilder input = new StringBuilder(str);
    int nopp = factorial(input.length());

    for (int i = 0; i < nopp; i++) {
      int temp = i;

      StringBuilder tempStr = new StringBuilder(str);

      for (int j = input.length(); j > 0; j--) {
        int q = temp / j;
        int r = temp % j;

        System.out.print(tempStr.charAt(r));
        tempStr.deleteCharAt(r);

        temp = q;
      }

      System.out.println();
    }

  }

  public static int factorial(int n) {
    int factorial = 1;
    for (int i = 2; i <= n; i++) {
      factorial *= i;
    }

    return factorial;
  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      String str = reader.readLine();
      permutationsIterative(str);
    }
  }
}
