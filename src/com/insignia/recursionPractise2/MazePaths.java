package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MazePaths {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        ArrayList<String> out = new ArrayList<>();

        // base case
        if (sr == dr && sc == dc) {
            out.add("");
            return out;
        }

        if (sc + 1 <= dc) {
            ArrayList<String> paths = getMazePaths(sr, sc + 1, dr, dc);
            for (String path : paths) {
                out.add("h" + path);
            }
        }

        if (sr + 1 <= dr) {
            ArrayList<String> paths = getMazePaths(sr+1, sc, dr, dc);
            for (String path : paths) {
                out.add("v" + path);
            }
        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println(getMazePaths(0, 0, n - 1, m - 1));

    }

}