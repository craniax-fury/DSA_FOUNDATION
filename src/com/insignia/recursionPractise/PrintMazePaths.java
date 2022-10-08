package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintMazePaths {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] maze = new int[n][m];
        printMaze(maze, 0, 0, "");
    }

    public static void printMaze(int[][] maze,int row,int col,String out){
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(out);
            return;
        }

        if(row>=maze.length || col>=maze[0].length){
            return;
        }

        printMaze(maze, row, col+1, out+"h");
        printMaze(maze, row+1, col, out+"v");

    }
}