package com.insignia.recursion.recursionBacktracking;

import java.io.IOException;
import java.util.Scanner;

public class NQueenWays {

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {

            int n = scn.nextInt();
           System.out.println(totalNQueens(n));
        }

    }

    public static int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return solveNQueen(board,n,0,0,0);
    }

    public static int solveNQueen(int[][] board,int n,int qsf,int row,int output){
        if(n==qsf){
            return 1; 
        }

        for(int col=0;col<board[0].length;col++){
            if(isQueenSafe(board,row,col)){
                board[row][col] = 1;
                int out = solveNQueen(board,n,row+1,qsf+1,output);
                if(out==1){
                    output+=1;
                }
                board[row][col] = 0;
            }
        }
9
        return output;

    }

    public static boolean isQueenSafe(int[][] board,int row,int col){
        for(int rp=row, cp=col;rp>=0;rp--){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;rp>=0 && cp>=0;rp--,cp--){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;cp>=0;cp--){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;rp<=board.length-1 && cp>=0; rp++,cp--){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;rp<=board.length-1;rp++){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;rp<=board.length-1 && cp<board[0].length-1;rp++,cp++){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;cp<=board[0].length-1;cp++){
            if(board[rp][cp] == 1){
                return false;
            }
        }

        for(int rp=row, cp=col;rp>=0 && cp<=board[0].length-1;rp--,cp++){
            if(board[rp][cp] == 1){
                return false;
            }
        }

    return true;
    }

}