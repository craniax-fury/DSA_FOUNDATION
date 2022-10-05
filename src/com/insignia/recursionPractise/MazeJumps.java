package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MazeJumps {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] maze = new int[n][m];

        ArrayList<String> ss = mazePaths(maze, 0, 0);
        System.out.print(ss);
    }

    private static ArrayList<String> mazePaths(int[][] maze, int sr, int sc) {

        if (sr >= maze.length || sc >= maze[0].length) {
            return new ArrayList<>();
        }

        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            ArrayList<String> isPath = new ArrayList<>();
            isPath.add("");
            return isPath;
        }

        ArrayList<String> output = new ArrayList<>();

        ArrayList<String> pth2;
        ArrayList<String> pth1;
        ArrayList<String> pth3;
        
        for (int i = 1; i < maze.length; i++) {
            pth1 = mazePaths(maze, sr + i, sc);
            for (String path : pth1) {
                output.add(path + "v"+i);
            }
        }

        for (int i = 1; i < maze[0].length; i++) {
            pth2 = mazePaths(maze, sr, sc + i);
            for (String path : pth2) {
                output.add(path + "h"+i);
            }
        }

        

        for (int i = 1; i < maze.length; i++) {
            pth3 = mazePaths(maze, sr + i, sc + i);
            for (String path : pth3) {
                output.add(path + "d"+i);
            }

        }

        return output;
    }
}