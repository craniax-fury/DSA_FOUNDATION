package com.insignia.dynamicProgrammingRecursive;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairs {
    
    private static int climb(int dest,int[] soln){
        if(dest<0){
            return 0;   
        }

        if(soln[dest]!=0){
            return soln[dest];
        }

        int path1 = climb(dest-1,soln);
        int path2 = climb(dest-2,soln);
        int path3 = climb(dest-3,soln);

        soln[dest]=path1+path2+path3;
        return soln[dest];

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] soln = new int[n+1];
            soln[0]=1;
            System.out.println(climb(n,soln));

        }
    }
}
