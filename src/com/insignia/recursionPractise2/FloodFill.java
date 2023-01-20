package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloodFill {

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf) {

        // base case
        if (maze[0][0] == 1) {
            return;
        }

        // base case
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            maze[sr][sc] = 0;
            return;
        }

        maze[sr][sc] = -1;
        // processing
        if (sr - 1 >= 0 && maze[sr - 1][sc] != 1 && maze[sr - 1][sc] != -1) {
            floodfill(maze, sr - 1, sc, asf + "t");

        }

        if (sc - 1 >= 0 && maze[sr][sc - 1] != 1 && maze[sr][sc - 1] != -1) {
            floodfill(maze, sr, sc - 1, asf + "l");
        }

        if (sr + 1 <= maze.length - 1 && maze[sr + 1][sc] != 1 && maze[sr + 1][sc] != -1) {
            floodfill(maze, sr + 1, sc, asf + "d");

        }

        if (sc + 1 <= maze[0].length - 1 && maze[sr][sc + 1] != 1 && maze[sr][sc + 1] != -1) {
            floodfill(maze, sr, sc + 1, asf + "r");

        }

        maze[sr][sc] = 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] sizes = input.split(" ");

        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        int[][] maze = new int[n][m];

        for (int row = 0; row < n; row++) {
            String[] line = br.readLine().split(" ");

            for (int col = 0; col < m; col++) {
                maze[row][col] = Integer.parseInt(line[col]);
            }

        }

        floodfill(maze, 0, 0, "");
    }

}