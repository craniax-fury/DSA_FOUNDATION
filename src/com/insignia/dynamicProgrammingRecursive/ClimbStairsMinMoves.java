package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairsMinMoves {

    private static int climb(int dest,int curr, int[] jumps,int[] soln) {
        
        int min = Integer.MAX_VALUE;

        if(dest>dest){
            return 0;
        }

        if(soln[dest]!=0){
            return soln[dest];
        }

        climb(dest+1, jumps, soln);

        if(jumps[dest]!=0){
            for(int i=1;i<=jumps[dest];i++){
                int path = climb(dest+i, jumps, soln);
                if(soln[dest]+path<min){
                    min=path+soln[dest];
                }
            }
        }else{
            int path = climb(dest-1, jumps, soln);
                if(soln[dest]+path<min){
                    min=path+soln[dest];
                }
        }

        if(min!=0 && min<soln[dest]){
            soln[dest]+=min;
        }

        return soln[dest];

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] jumps = new int[n+1];

            for (int i = 1; i <= n; i++) {
                jumps[i] = Integer.parseInt(reader.readLine());
            }

            int[] soln = new int[n + 1];
            soln[n] = 0;

            System.out.println(climb(n, jumps, soln));

        }
    }
}
