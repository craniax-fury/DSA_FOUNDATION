package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairsMinMoves {

    private static int climb(int dest, int curr, int[] jumps, int[] soln) {

        if (curr == dest) {
            soln[dest] = 1;
            return 1;
        }

        if (soln[curr] != 0) {
            return soln[curr] + 1;
        }

        if (jumps[curr] == 0) {
            return 0;
        }

        for (int i = 1; i <= jumps[curr]; i++) {
            if (i + curr <= dest) {
                int move = climb(dest, curr + i, jumps, soln);

                if (soln[curr] == 0) {
                    soln[curr] = move;
                } else if (move != 0 && move < soln[curr]) {
                    soln[curr] = move;
                }
            }
        }

        if (curr != 0 && soln[curr] != 0) {
            return soln[curr] + 1;
        } else {
            return soln[curr];
        }

    }

    private static int climbTabu(int dest, int curr, int[] jumps, int[] soln) {

        for (int i = dest; i >= 0; i--) {
            if (i == dest) {
                soln[i] = 1;
                continue;
            }

            if (jumps[i] == 0) {
                continue;
            }

            for (int j = 1; j <= jumps[i]; j++) {
                if (j + i <= dest) {

                    if(soln[i+j]!=0 && i+j!=dest && soln[i+j]+1<soln[i]){
                        soln[i] = soln[i+j]+1;
                    
                    }else if(i+j==dest){
                        soln[i] = soln[i+j];
                    
                    }else if (soln[i] == 0 && soln[i+j]!=0) {
                        soln[i] = soln[i+j]+1;
                    }
                }
            }
        }

        return soln[0];

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] jumps = new int[n + 1];

            for (int i = 0; i < n; i++) {
                jumps[i] = Integer.parseInt(reader.readLine());
            }

            int[] soln = new int[n + 1];

            // System.out.println(climb(n, 0, jumps, soln));

            // display(soln);

            System.out.println(climbTabu(n, 0, jumps, soln));

        }
    }

    private static void display(int[] soln) {
        for (int i = 0; i < soln.length; i++) {
            System.out.print(soln[i] + " ");
        }
    }
}
