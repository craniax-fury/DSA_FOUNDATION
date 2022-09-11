package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackUnbounded {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of items

            String[] valueLine = reader.readLine().split(" ");
            String[] wtLine = reader.readLine().split(" ");

            int[] values = new int[n]; // item values
            int[] wt = new int[n]; // item weights

            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(valueLine[i]);
            }

            for (int i = 0; i < n; i++) {
                wt[i] = Integer.parseInt(wtLine[i]);
            }

            int cap = Integer.parseInt(reader.readLine()); // bag capacity

            int[] maxValue = new int[cap + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < cap + 1; j++) {
                    if (j>=wt[i]) {
                        if (wt[i] == j) {
                            if (maxValue[j] < values[i]) {
                                maxValue[j] = values[i];
                            }
                        } else if(j - wt[i] >= 0 && maxValue[j-wt[i]]+values[i]>maxValue[j]) {
                            maxValue[j] = maxValue[j-wt[i]]+values[i];
                        }
                    }
                }

            }

            System.out.println(maxValue[cap]);
        }
    }
}
