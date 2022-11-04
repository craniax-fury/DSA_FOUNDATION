package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostMazeTraversal {

    private static int minCostMaze(int sr, int sc, int dr, int dc, int[][] maze, int[][] dp) {
        if (sr == dr && sc == dc) {
            dp[sr][sc] = maze[sr][sc];
            return maze[sr][sc];
        }

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        if (sc + 1 <= dc) {
            int cost = minCostMaze(sr, sc + 1, dr, dc, maze, dp);

            if (dp[sr][sc] == 0) {
                dp[sr][sc] = cost + maze[sr][sc];

            } else if (cost + maze[sr][sc] < dp[sr][sc]) {
                dp[sr][sc] = cost + maze[sr][sc];
            }
        }

        if (sr + 1 <= dr) {
            int cost = minCostMaze(sr + 1, sc, dr, dc, maze, dp);

            if (dp[sr][sc] == 0) {
                dp[sr][sc] = cost + maze[sr][sc];

            } else if (cost + maze[sr][sc] < dp[sr][sc]) {
                dp[sr][sc] = cost + maze[sr][sc];
            }
        }

        return dp[sr][sc];
    }

    private static int minCostMazeTabu(int sr, int sc, int dr, int dc, int[][] maze, int[][] dp) {

        for (int i = dr; i >= 0; i--) {
          for (int j = dc; j >= 0; j--) {
    
            if (i == dr && j == dc) {
              dp[i][j] = maze[i][j];
              continue;
            }
    
            if (j + 1 <= dc) {
              int cost = dp[i][j + 1];
    
              if (dp[i][j] == 0) {
                dp[i][j] = cost + maze[i][j];
    
              } else if (cost + maze[i][j] < dp[i][j]) {
                dp[i][j] = cost + maze[i][j];
              }
            }
    
            if (i + 1 <= dr) {
              int cost = dp[i+1][j];
    
              if (dp[i][j] == 0) {
                dp[i][j] = cost + maze[i][j];
    
              } else if (cost + maze[i][j] < dp[i][j]) {
                dp[i][j] = cost + maze[i][j];
              }
            }
          }
        }
        return dp[sr][sc];
    
      }
    
      public static void main(String[] args) throws IOException {
    
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
          int n = Integer.parseInt(reader.readLine());
          int m = Integer.parseInt(reader.readLine());
          int[][] maze = new int[n][m];
    
          for (int i = 0; i < n; i++) {
            String cost[] = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
              maze[i][j] = Integer.parseInt(cost[j]);
            }
          }
    
          int[][] dp = new int[n][m];
    
          System.out.println(minCostMazeTabu(0, 0, maze.length - 1, maze[0].length - 1, maze, dp));
    
        }
      }

    private static void display1d(int[] soln) {
        for (int ele : soln) {
            System.out.print(ele + " ");
        }
    }

    private static void display2d(int[][] soln) {
        for (int[] eleArr : soln) {
            display1d(eleArr);
            System.out.println();
        }
    }
    
}
