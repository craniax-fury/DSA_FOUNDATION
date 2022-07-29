package com.insignia.recursion;

import java.io.*;

public class PrintIncreasing {

  public static void main(String[] args) throws Exception {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
    //   int number = Integer.parseInt(reader.readLine());
      printIncreasing(3);
    }
  }

  public static void printIncreasing(int n) {
    if (n == 0) {
      return;
    }
    printIncreasing(n - 1);
    System.out.println(n);
  }

}