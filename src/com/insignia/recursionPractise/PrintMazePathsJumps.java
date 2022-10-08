package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintMazePathsJumps {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] maze = new int[n][m];
        printMazeJumps(maze, 0, 0, "");
    }

    public static void printMazeJumps(int[][] maze, int row, int col, String out) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(out);
            return;
        }

        if (row >= maze.length || col >= maze[0].length) {
            return;
        }

        for (int i = 1; i < maze.length; i++) {
            printMazeJumps(maze, row, col + i, out + "h" + i);
        }

        for (int i = 1; i < maze[0].length; i++) {
            printMazeJumps(maze, row + i, col, out + "v" + i);
        }
    }
}