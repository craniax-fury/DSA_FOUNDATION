package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ArrangeBuildings {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // number of items

            int[] countB = new int[n + 1]; // count[i] = number of ways road ends in building
            int[] countS = new int[n + 1]; // count[i] = number of road ends in space

            countB[1] = 1;
            countS[1] = 1;

            for (int i = 2; i < n + 1; i++) {
                countB[i] = countS[i - 1]; // we can only place Space at end of road ending in building
                countS[i] = countB[i - 1] + countS[i - 1]; // we can place building at end of road ending in building as
                                                           // well as road ending in space

            }

            BigInteger a = BigInteger.valueOf(countB[n] + (long) countS[n]);
            System.out.println(a.multiply(a)); // total number of ways for road of length n = (countB+countS) *
                                               // (countB+countS)
            // as we have calculated arrangement on only one side of road
            // same number of arrangements are possible at the other side of road
            // for each arrangement that we choose for one side of the road, we have
            // countB[n]+countS[n] arrangements to choose from
        }
    }
}
