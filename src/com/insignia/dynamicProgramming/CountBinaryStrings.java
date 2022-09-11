package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountBinaryStrings {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of items

            int[] count0 = new int[n + 1]; // count[i] = number of binary strings of length i ending in 0
            int[] count1 = new int[n + 1]; // count[i] = number of binary strings of length i ending in 1

            count0[1] = 1;
            count1[1] = 1;
            
            for (int i = 2; i < n + 1; i++) {
                count0[i] = count1[i - 1]; // we can only place 0 in place of strings ending in 1
                count1[i] = count1[i - 1] + count0[i - 1]; // we can place 1 at both strings ending in 0 and strings
                                                           // ending in 1
            }

            System.out.println(count0[n]+count1[n]);
        }
    }
}
