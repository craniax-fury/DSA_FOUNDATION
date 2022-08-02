package com.insignia.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MazePathWithJumps {

    // public static void main(String[] args) throws Exception {
    // try (BufferedReader br = new BufferedReader(new
    // InputStreamReader(System.in))) {

    // int n = Integer.parseInt(br.readLine());

    // int m = Integer.parseInt(br.readLine());

    // getMazePathWithJumps(n, m, 0, 0, "");
    // }
    // }

    // // sr - source row
    // // sc - source column
    // // dr - destination row
    // // dc - destination column
    // public static void getMazePathWithJumps(int sr, int sc, int dr, int dc,
    // String pathToEnd) {
    // if (dr > sr - 1 || dc > sc - 1) {
    // return;
    // }

    // if (dr == sr - 1 && dc == sc - 1) {
    // System.out.println(pathToEnd);
    // }

    // for (int row = 0; row < sr - row + 1; row++) {
    // getMazePathWithJumps(sr, sc, dr + row + 1, dc, "v" + (row + 1) + pathToEnd);
    // }

    // for (int column = 0; column < sc - column + 1; column++) {
    // getMazePathWithJumps(sr, sc, dr, dc + column + 1, "h" + (column + 1) +
    // pathToEnd);
    // }

    // for (int diag = 0; (diag < sc - diag + 1) && (diag < sr - diag + 1); diag++)
    // {
    // getMazePathWithJumps(sr, sc, dr + diag + 1, dc + diag + 1, "d" + (diag + 1) +
    // pathToEnd);
    // }

    // }
    static ArrayList<String> paths = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            int m = Integer.parseInt(br.readLine());

            ArrayList<String> output = getMazePathWithJumps(n, m, 0, 0, "");

            System.out.print(output);
        }
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc, String pathToEnd) {
        if (dr > sr - 1 || dc > sc - 1) {
            return new ArrayList<String>();
        }

        if (dr == sr - 1 && dc == sc - 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(pathToEnd);
            return path;
        }

        ArrayList<String> paths1 = new ArrayList<>();
        ArrayList<String> paths2 = new ArrayList<>();
        ArrayList<String> paths3 = new ArrayList<>();

        for (int row = 0; row < sr - row + 1; row++) {
            paths1 = getMazePathWithJumps(sr, sc, dr + row + 1, dc, "v" + (row + 1) + pathToEnd);
            int i = 0;

            Iterator<String> itr1 = paths1.iterator();

            while (itr1.hasNext()) {
                if (i < paths1.size()) {
                    paths.add(paths1.get(i++));
                }
                itr1.next();
            }
        }

        for (int column = 0; column < sc - column + 1; column++) {
            paths2 = getMazePathWithJumps(sr, sc, dr, dc + column + 1, "h" + (column + 1) + pathToEnd);
            int j = 0;

            Iterator<String> itr2 = paths2.iterator();

            while (itr2.hasNext()) {
                if (j < paths2.size()) {
                    paths.add(paths2.get(j++));
                }
                itr2.next();

            }
        }

        for (int diag = 0; (diag < sc - diag + 1) && (diag < sr - diag + 1); diag++) {
            paths3 = getMazePathWithJumps(sr, sc, dr + diag + 1, dc + diag + 1, "d" + (diag + 1) + pathToEnd);

            int k = 0;

            Iterator<String> itr3 = paths3.iterator();

            while (itr3.hasNext()) {
                if (k < paths3.size()) {
                    paths.add(paths3.get(k++));
                }
                itr3.next();
            }
        }

        return paths;
    }

}