package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MazePathsVarJumps {

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

        for (int hor = 1; hor < dc - sc+1; hor++) {
            //if (sc + hor <= dc) {
                ArrayList<String> paths = getMazePaths(sr, sc + hor, dr, dc);
                for (String path : paths) {
                    out.add("h" + hor + path);
                //}
            }
        }

        for (int ver = 1; ver < dr - sr+1; ver++) {
            //if (sr + ver <= dr) {
                ArrayList<String> paths = getMazePaths(sr + ver, sc, dr, dc);
                for (String path : paths) {
                    out.add("v" + ver + path);
                //}
            }
        }

        for (int hor = 1,ver = 1; hor < dc - sc+1 && ver < dr - sr+1; hor++, ver++) {
            //if (sc + hor <= dc && sr + ver <= dr) {
                ArrayList<String> paths = getMazePaths(sr + ver, sc+hor, dr, dc);
                for (String path : paths) {
                    out.add("d" + ver + path);
                //}
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