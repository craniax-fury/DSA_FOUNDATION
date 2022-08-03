package com.insignia.recursion.recursionBacktracking;

import java.io.*;
import java.util.Scanner;

public class NQueen {

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {

            int n = scn.nextInt();
            int[][] chess = new int[n][n];

            printNQueens(chess, "", 0);
        }

    }

    // asf -> answer so far
    public static void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isQueenSafeAtPlace(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            } 
        }

    }

    private static boolean isQueenSafeAtPlace(int[][] chess, int row, int col) {

        for (int i = row; i < chess.length; i++) {
            if (chess[i][col] == 1) {
                return false;
            }
        }

        for (int i = row; i >= 0; i--) {
            if (chess[i][col] == 1) {
                return false;
            }
        }

        for (int i = col; i < chess.length; i++) {
            if (chess[row][i] == 1) {
                return false;
            }
        }

        for (int i = col; i >=0 ; i--) {
            if (chess[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j=col; i >= 0 && j>=0; i--,j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j=col; i >= 0 && j< chess.length; i--,j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j=col; i < chess.length && j>=0; i++,j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j=col; i < chess.length && j< chess.length; i++,j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }

}