package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairsVarJumps {

    private static int climb(int dest, int[] jumps, int curr, int[] soln) {
        if (dest < 0) {
            return 0;
        }

        if (soln[dest] != 0) {
            return soln[dest];
        }

        for (int j = 1; j <= jumps[curr]; j++) {
            soln[dest] += climb(dest - j, jumps, curr + j, soln);
        }
        return soln[dest];

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] jumps = new int[n];

            for (int i = 0; i < n; i++) {
                jumps[i] = Integer.parseInt(reader.readLine());
            }

            int[] soln = new int[n + 1];
            soln[0] = 1;

            System.out.println(climb(n, jumps, 0, soln));

        }
    }
}
