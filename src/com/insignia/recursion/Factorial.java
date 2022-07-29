package com.insignia.recursion;

import java.io.*;

public class Factorial {

  public static void main(String[] args) throws Exception {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
    //   int number = Integer.parseInt(reader.readLine());
      System.out.println(factorial(5));
    }
  }

  public static int factorial(int n) {

    if (n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

}