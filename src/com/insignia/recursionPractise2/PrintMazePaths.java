package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintMazePaths {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        // base case
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        // processing
        if (sc + 1 <= dc) {
            // recursive calls
            printMazePaths(sr, sc + 1, dr, dc, psf+"h");
        }

        // processing

        if (sr + 1 <= dr) {
            // recursive calls
            printMazePaths(sr + 1, sc, dr, dc, psf+"v");

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        printMazePaths(0, 0, n-1, m-1, "");

    }

}