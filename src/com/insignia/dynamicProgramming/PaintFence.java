package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintFence {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int nof = Integer.parseInt(reader.readLine());
            int noc = Integer.parseInt(reader.readLine());

            int[] l2Same = new int[nof + 1];
            int[] l2Diff = new int[nof + 1];

            l2Same[1] = 1;
            l2Same[2] = noc;

            l2Diff[1] = 1;
            l2Diff[2] = noc * (noc - 1);

            for (int i = 3; i < nof + 1; i++) {
                l2Same[i] = l2Diff[i - 1]; // we can add the same color as the last one in front of l2 diff, but not in
                                           // front of l2same as then it will be 3 consecutive
                l2Diff[i] = (l2Diff[i - 1] + l2Same[i-1]) * (noc - 1); // we can n-1 color on previous choices for diff colors
            }

            System.out.println(l2Same[nof] + l2Diff[nof]);
        }
    }
}
