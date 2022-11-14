package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackFractional {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of items

            String[] valueLine = reader.readLine().split(" ");
            String[] wtLine = reader.readLine().split(" ");

            double[] values = new double[n]; // item values
            double[] wt = new double[n]; // item weights

            for (int i = 0; i < n; i++) {
                values[i] = Double.parseDouble(valueLine[i]);
            }

            for (int i = 0; i < n; i++) {
                wt[i] = Double.parseDouble(wtLine[i]);
            }

            int cap = Integer.parseInt(reader.readLine()); // bag capacity

            double[][] maxValue = new double[n][cap + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < cap + 1; j++) {

                    if (j <= wt[i]) {
                        if (i - 1 >= 0 && maxValue[i - 1][j] > values[i] / (double)(wt[i] - j + 1)) {
                            maxValue[i][j] = maxValue[i - 1][j];
                        } else {
                            maxValue[i][j] = values[i] / (double) (wt[i] - j + 1);
                        }
                    } else {
                        if (i - 1 >= 0 && maxValue[i - 1][j - (int) wt[i]] + values[i] < maxValue[i - 1][j]) {
                            maxValue[i][j] = maxValue[i - 1][j];
                        } else {
                            maxValue[i][j] = maxValue[i - 1][j - (int) wt[i]] + values[i];
                        }
                    }

                }

            }

            System.out.println(maxValue[n - 1][cap]);
        }
    }
}
