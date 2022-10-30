package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbStairsVarJumps {

    private static int climb(int dest, int curr, int[] jumps, Integer[] soln) {

        if (curr > dest) {
            return 0;
        }

        if (soln[curr] !=null) {
            return soln[curr];
        }

        while (curr != 0) {
            for (int j = 1; j <= jumps[curr]; j++) {
                int move = climb(dest, curr + j, jumps, soln);
                if(move!=-1){
                    soln[curr]=move+1;
                }
            }

            if(soln[curr]==null){
                soln[curr] = -1;
            }
            curr--;
        }

        return soln[1];

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] jumps = new int[n];

            for (int i = 0; i < n; i++) {
                jumps[i] = Integer.parseInt(reader.readLine());
            }

            Integer[] soln = new Integer[n + 1];
            Arrays.fill(soln, null);
            soln[n] = 0;

            System.out.println(climb(n, n - 1, jumps, soln));

        }
    }
}
