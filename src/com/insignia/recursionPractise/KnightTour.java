package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightTour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sr = Integer.parseInt(br.readLine());
        int sc = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        knightTour(board, n,1, sr, sc);
    }

    private static void knightTour(int[][] board, int n,int move, int sr, int sc) {
        if(sr<0 || sr>board.length-1 || sc<0 || sc>board[0].length-1 || board[sr][sc]!=0){
            return;
        }
        
        board[sr][sc] = move;

        if(move==n*n){
            printBoard(board);
            board[sr][sc]=0;
            return;
        }

        knightTour(board, n, move+1, sr-2, sc+1);
        knightTour(board, n, move+1, sr-1, sc+2);
        knightTour(board, n, move+1, sr+1, sc+2);
        knightTour(board, n, move+1, sr+2, sc+1);
        knightTour(board, n, move+1, sr+2, sc-1);
        knightTour(board, n, move+1, sr+1, sc-2);
        knightTour(board, n, move+1, sr-1, sc-2);
        knightTour(board, n, move+1, sr-2, sc-1);
        board[sr][sc] = 0;
    }

    private static void printBoard(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}