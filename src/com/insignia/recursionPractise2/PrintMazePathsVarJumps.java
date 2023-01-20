package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintMazePathsVarJumps {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePathsVarJumps(int sr, int sc, int dr, int dc, String psf) {
        // base case
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        // recursive calls
        for (int hor = 1; hor <= dc - sc + 1; hor++) {
            printMazePathsVarJumps(sr, sc + hor, dr, dc, psf + "h"+hor);
        }

        // recursive calls
        for (int ver = 1; ver <= dr - sr + 1; ver++) {
            printMazePathsVarJumps(sr+ver, sc, dr, dc, psf + "v"+ver);
        }
        
        // recursive calls
        for (int hor=1,ver = 1; hor<=dc-sc+1 && ver <= dr - sr + 1; hor++,ver++) {
            printMazePathsVarJumps(sr+ver, sc+hor, dr, dc, psf + "d"+ver);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        printMazePathsVarJumps(0, 0, n - 1, m - 1, "");

    }

}