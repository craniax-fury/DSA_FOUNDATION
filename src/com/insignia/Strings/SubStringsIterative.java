package com.insignia.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubStringsIterative {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            for(int i=0;i<input.length();i++){
                for(int j=i+1;j<=input.length();j++){
                   System.out.println(input.substring(i,j));
                }
            }
        }

    }
}
