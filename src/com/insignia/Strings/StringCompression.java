package com.insignia.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {
    public static String compression1(String str) {
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            if(result.length()==0){
                result.append(str.charAt(i)); 
            
            }else if(result.charAt(result.length()-1)!=str.charAt(i)){
                result.append(str.charAt(i));
            
            }else{

            }
        }

        return result.toString();
    }

    public static String compression2(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (result.length() == 0) {
                result.append(input.charAt(i));
            } else if (result.charAt(result.length() - 1) == input.charAt(i)) {
                count++;
            } else if (count != 1) {
                result.append(count).append(input.charAt(i));
                count = 1;
            } else {
                result.append(input.charAt(i));
            }
        }

        if (count != 1) {
            result.append(count);
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String str = reader.readLine();
            System.out.println(compression1(str));
            System.out.println(compression2(str));
        }
    }
}
