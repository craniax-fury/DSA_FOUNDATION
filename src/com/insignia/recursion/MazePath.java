package com.insignia.recursion;

import java.io.*;

public class MazePath {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            int m = Integer.parseInt(br.readLine());

            getMazePaths(n, m, 0, 0, "");
        }
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void getMazePaths(int sr, int sc, int dr, int dc, String pathToEnd) {
        if (dr > sr - 1 || dc > sc - 1) {
            return;
        }

        if (dr == sr - 1 && dc == sc - 1) {
            System.out.println(pathToEnd);
        }
        
        getMazePaths(sr, sc, dr + 1, dc, "v" + pathToEnd);
        getMazePaths(sr, sc, dr, dc + 1, "h" + pathToEnd);

    }

}