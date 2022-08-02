package com.insignia.recursion;

import java.io.*;

public class PermutationsOfAString {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String str = br.readLine();

            printPermutations(str, "");
        }
    }

    public static void printPermutations(String str, String asf) {
    
        if (str.length() == 1) {
          System.out.println(asf + str);
          return;
        }
    
        for (int index = 0; index < str.length(); index++) {
          String left =  str.substring(0, index);
          String right = left + str.substring(index + 1);
          String resultTillNow = asf + String.valueOf(str.charAt(index));
          printPermutations (right, resultTillNow);
        }
      }

}