package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] maze = new int[n][m];

        ArrayList<String> ss = mazePaths(maze,0, 0);
        System.out.print(ss);
    }

    private static ArrayList<String> mazePaths(int[][] maze,int sr,int sc) {
        
        if(sr>=maze.length || sc>=maze[0].length){
            return new ArrayList<>();
        }

        if(sr==maze.length-1 && sc==maze[0].length-1){
            ArrayList<String> isPath = new ArrayList<>();
            isPath.add("");
            return isPath;
        }
        

        ArrayList<String> pth2 = mazePaths(maze,sr,sc+1);

        ArrayList<String> pth1 = mazePaths(maze,sr+1,sc);

        ArrayList<String> output = new ArrayList<>();
        
        for(String path:pth1){
            output.add(path+"v");
        }

        for(String path:pth2){
            output.add(path+"h");
        }

        
        

        return output;
    }
}