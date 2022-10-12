package com.insignia.recursion.recursionBacktracking;

import java.io.*;
import java.util.Scanner;

public class KnightTour {

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {

            int n = scn.nextInt();
            int[][] chess = new int[n][n];

            int start_row = scn.nextInt();
            int start_column = scn.nextInt();

            printKnightsTour(chess, start_row, start_column, 1);
        }

    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

        if (r >= chess.length || r < 0 || c >= chess[0].length || c < 0 || chess[r][c] != 0) {
            return;
        } 


        if (upcomingMove == chess.length * chess.length) {
            displayBoard(chess);
            //chess[r][c]=0;
            return;
        }
        chess[r][c] = upcomingMove;

        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);

        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}