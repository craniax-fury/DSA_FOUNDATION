package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloodFill {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] islands = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] isle = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                islands[i][j] = Integer.parseInt(isle[j]);
            }
        }

        floodFill(islands, 0, 0, "");
    }

    public static void floodFill(int[][] islands, int row, int col, String psf) {

        if (row < 0 || row >= islands.length || col < 0 || col >= islands[0].length || islands[row][col] == 1) {
            return;
        }

        if (row == islands.length - 1 && col == islands[0].length-1) {
            System.out.println(psf);
            return;
        }

        islands[row][col] = 1;

        floodFill(islands, row - 1, col, psf + "t");
        floodFill(islands, row, col - 1, psf + "l");
        floodFill(islands, row + 1, col, psf + "d");
        floodFill(islands, row, col + 1, psf + "r");

        islands[row][col] = 0;
    }
}