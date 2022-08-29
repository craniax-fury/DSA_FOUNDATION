package com.insignia.matrices.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiDifference {
    public static String asciiDiff(String str){
        StringBuilder input = new StringBuilder(str);
        StringBuilder result = new StringBuilder();

         for(int i=0;i<input.length()-1;i++){
           result.append(input.charAt(i)).append((input.charAt(i+1) - input.charAt(i)));
         }

         result.append(input.charAt(input.length()-1));

         return result.toString();
	}

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String str = reader.readLine();
            System.out.println(asciiDiff(str));
        }
    }
}
