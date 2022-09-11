package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangePermutations {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of coins

            int[] den = new int[n]; // denominations

            for (int i = 0; i < n; i++) {
                den[i] = Integer.parseInt(reader.readLine());
            }

            int targetSum = Integer.parseInt(reader.readLine());

            int[] sum = new int[targetSum + 1];
            sum[0] = 1;

            // checking for all denominations at each index,
            // so for 5, 2-3 will be checked and 3-2 will also be checked
            for (int i = 1; i < targetSum + 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (den[j] <= i) {
                        if (sum[i - den[j]] >= 1) {
                            sum[i] += sum[i - den[j]];
                        }
                    }
                }
            }
            System.out.println(sum[targetSum]);

        }
    }
}
