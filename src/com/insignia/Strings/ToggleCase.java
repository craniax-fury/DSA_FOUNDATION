package com.insignia.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleCase {
    public static String toggleCase(String str){
        StringBuilder input = new StringBuilder(str);
		/**
         * To convert 'v'-> 'V'
         * 'v' - 'a'  = 'V' - 'A'
         * 'V' = 'v' - 'a' + 'A'
         * 'V' = char + 'A' - 'a'
         */

         /**
          * To convert 'V' -> 'v'
          * 'v' = 'V' - 'A' + 'a'
          * 'v' = char + 'a' - 'A'
          */

         for(int i=0;i<input.length();i++){
              if(input.charAt(i)<='z' && input.charAt(i)>= 'a'){
                input.setCharAt(i,(char)(input.charAt(i) + 'A' - 'a')); 

              } else if(input.charAt(i)<='Z' && input.charAt(i)>= 'A'){
                input.setCharAt(i,(char)(input.charAt(i) + 'a' - 'A')); 
              }
         }
		return input.toString();
	}

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String str = reader.readLine();
            System.out.println(toggleCase(str));
        }
    }
}
