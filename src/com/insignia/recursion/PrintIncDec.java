package com.insignia.recursion;

import java.io.*;

public class PrintIncDec {

  public static void main(String[] args) throws Exception {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
    //   int number = Integer.parseInt(reader.readLine());
      pdi(3);
    }
  }

  public static void pdi(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    pdi(n - 1);
    System.out.println(n);
  }

}