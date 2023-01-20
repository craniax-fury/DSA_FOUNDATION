package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightTour {

    public static void printKnightsTour(int[][] chess, int row, int col, int upcomingMove) {

        // base case
        if (upcomingMove == chess.length * chess.length) {
            chess[row][col]=upcomingMove;
            displayBoard(chess);
            chess[row][col]=0;
            return;
        }

        // recursive calls
        chess[row][col] = upcomingMove;

        if (row - 2 >= 0 && col + 1 <= chess.length - 1 && chess[row-2][col+1] == 0) {
            printKnightsTour(chess, row - 2, col + 1, upcomingMove + 1);
        }

        if (row - 1 >= 0 && col + 2 <= chess.length - 1 && chess[row-1][col+2] == 0) {
            printKnightsTour(chess, row - 1, col + 2, upcomingMove + 1);
        }
        if (row + 1 <= chess.length - 1 && col + 2 <= chess.length - 1 && chess[row+1][col+2] == 0) {
            printKnightsTour(chess, row + 1, col + 2, upcomingMove + 1);
        }
        if (row + 2 <= chess.length - 1 && col + 1 <= chess.length - 1 && chess[row+2][col+1] == 0) {
            printKnightsTour(chess, row + 2, col + 1, upcomingMove + 1);
        }
        if (row + 2 <= chess.length - 1 && col - 1 >= 0 && chess[row+2][col-1] == 0) {
            printKnightsTour(chess, row + 2, col - 1, upcomingMove + 1);
        }
        if (row + 1 <= chess.length - 1 && col - 2 >= 0 && chess[row+1][col-2] == 0) {
            printKnightsTour(chess, row + 1, col - 2, upcomingMove + 1);
        }
        if (row - 1 >= 0 && col - 2 >= 0 && chess[row-1][col-2] == 0) {
            printKnightsTour(chess, row - 1, col - 2, upcomingMove + 1);
        }
        if (row - 2 >= 0 && col - 1 >= 0 && chess[row-2][col-1] == 0) {
            printKnightsTour(chess, row - 2, col - 1, upcomingMove + 1);
        }

        chess[row][col] = 0;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] chess = new int[size][size];

        int row = Integer.parseInt(br.readLine());
        int col = Integer.parseInt(br.readLine());

        printKnightsTour(chess, row, col, 1);
    }

}