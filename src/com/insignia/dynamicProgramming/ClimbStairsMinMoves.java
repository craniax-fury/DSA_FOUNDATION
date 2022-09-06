package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairsMinMoves {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] input = new int[n];

            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(reader.readLine());
            }

            /**
             * using tabulation
             * at each index of nop array i.e number of paths, we will store number of paths
             * to nth stair
             * direction is nth stair to 0th stair as small problem is nth to nth paths i.e.
             * 1
             *
             */
            int[] nop = new int[n + 1];

            nop[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                int options = input[i];
                int minMove = Integer.MAX_VALUE;

                for (int j = 1; j <= options; j++) {

                    if (i + j < n + 1 && nop[i + j] >= 1) {
                        if (nop[i + j] != 0 && nop[i + j] < minMove) {

                            if(i+j!=n){
                                minMove = nop[i + j] + 1;
                            }else{
                                minMove = nop[i + j];
                            }
                        }
                    }

                }

                if (minMove != Integer.MAX_VALUE) {
                    nop[i] += minMove;
                }
            }

            System.out.println(nop[0]);
        }
    }
}
