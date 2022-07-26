package com.insignia.recursion.recursionBacktracking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {

            int n = scn.nextInt();
           System.out.println(solveNQueens(n));
        }

    }

    public static List<List<String>> solveNQueens(int n) {
        
        int[][] board = new int[n][n];

        List<String> outConf = new ArrayList<>();
        List<List<String>> output= new ArrayList<>();
    
        solve(board,n,0,outConf,output);

        return output;
    }

    public static void solve(int[][] board,int n,int row, List<String> qsf,List<List<String>> output){
        if(row==n){
            List<String> qConf = new ArrayList<>();
             
            for(int i=0;i<qsf.size();i++){
                qConf.add(qsf.get(i));
            }

            output.add(qConf);
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(isQueenSafetoPlace(board,row,col)){
                board[row][col] = 1;
                qsf.add(getQueenConf(col,n));
                solve(board,n,row+1,qsf,output);
                qsf.remove(qsf.size()-1);
                board[row][col] = 0;
            }
        }
    }

    public static String  getQueenConf(int col,int n){
        StringBuilder qc= new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==col){
                qc.append("Q");
            }else{
                qc.append(".");
            }
        }

        return qc.toString();
    }

    public static boolean isQueenSafetoPlace(int[][] board,int row,int col){

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