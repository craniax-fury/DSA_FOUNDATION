package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nqueens {

    // asf -> answer so far
    public static void nQueens(int[][] chess, String qsf, int row) {

        // base case
        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }

        // recursive calls
        for(int col=0;col<chess.length;col++){
            if(isSafe(chess,row,col)){
                chess[row][col]=1;
                nQueens(chess,qsf+row+"-"+col+", ", row+1);
                chess[row][col]=0;
            }

        }
    }

    private static boolean isSafe(int[][] chess, int row, int col) {
        
        int i=row;
        int j=col;

        while(i>=0 && j>=0){
            if(chess[i][j]==1){
                return false;
            }

            i--;
            j--;
        }

        i=row;
        j=col;

        while(i>=0){
            if(chess[i][j]==1){
                return false;
            }

            i--;
        }

        i=row;
        j=col;

        while(i>=0 && j<=chess.length-1){
            if(chess[i][j]==1){
                return false;
            }
            
            i--;
            j++;
        }
                
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queens = Integer.parseInt(br.readLine());
        int[][] chess = new int[queens][queens];

        nQueens(chess,"",0);
    }

}