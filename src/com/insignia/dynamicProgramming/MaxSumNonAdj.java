package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumNonAdj {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int noe = Integer.parseInt(reader.readLine());

            int[] ele = new int[noe];

            int[] in = new int[noe];
            int[] ex = new int[noe];

            for (int i = 0; i < noe; i++) {
                ele[i] = Integer.parseInt(reader.readLine());
            }

            in[0] = ele[0];


            // if number is negative then it won't be included as it decreases the value
            // while including a number we will add the sum till last excluded to the current element
            // but while excluding , we have to options to choose from
            // i.e. max of sum till last excluded or sum till last included
            for (int i = 1; i < noe; i++) {
                if (ele[i] >= 0) {
                    in[i] = ex[i - 1] + ele[i];
                    ex[i] = Math.max(in[i - 1],ex[i-1]);
                } else {
                    in[i] = Math.max(in[i - 1],ex[i-1]);
                    ex[i] = Math.max(in[i - 1],ex[i-1]);
                }
            }

            System.out.println(Math.max(in[noe - 1], ex[noe - 1]));
        }
    }
}
