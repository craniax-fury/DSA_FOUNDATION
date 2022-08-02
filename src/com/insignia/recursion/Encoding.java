package com.insignia.recursion;

import java.io.*;

public class Encoding {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

      String str = br.readLine();

      printEncodings(str, "");
    }
  }

  public static void printEncodings(String str, String output) {

    if (str.length() == 0) {
      System.out.println(output);

    } else if (str.length() == 1) {
      char alpha = str.charAt(0);
      if (alpha == '0') {
        return;
      } else {
        output += (char) ('a' + (alpha - '0') - 1);
        System.out.println(output);
      }

    } else {

      char char1 = str.charAt(0);

      if (char1 != '0') {
        printEncodings(str.substring(1), output + (char) ('a' + (char1 - '0') - 1));

        int ch12v = Integer.parseInt(str.substring(0, 2));

        if (ch12v <= 26 && str.charAt(0) != '0') {
          char ch12 = (char) ('a' + ch12v - 1);
          printEncodings(str.substring(2), output + ch12);
        }
      }
      return;
    }
  }

}