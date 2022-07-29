package com.insignia.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Power {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        //   int number = Integer.parseInt(reader.readLine());
        //   int power = Integer.parseInt(reader.readLine());
    
          System.out.println(power(2, 5));
        }
      }
    
      public static int power(int x, int n) {
        if (n == 0) {
          return 1;
        }
        return x * power(x, n - 1);
    
      }
    
}
