// package com.insignia.recursionPractise;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;

// public class NQueen {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int in = Integer.parseInt(br.readLine());

//         int[][] board = new int[in][in];

//        System.out.print(solveNQueens(in));
//     }

//     public List<List<String>> solveNQueens(int n) {
        
//         int[][] board = new int[n][n];
//         List<List<String>> output = new ArrayList<>();

//         solve(board,n,0,new ArrayList<String>(),output);

//         return output;
//     }

//     public void solve(int[][] board,int n,int row, ArrayList<String> qsf,ArrayList<ArrayList<String>> output){
//         if(row==n){
//             output.add(qsf);
//             return;
//         }

//         for(int col=0;col<board[0].length;col++){
//             if(isQueenSafetoPlace(board,row,col)){
//                 board[row][col] = 1;
//                 solve(board,n,row+1,qsf.add(getQueenConf(col,n)));
//                 board[row][col] = 0;
//             }
//         }
//     }

//     public String  getQueenConf(int col,int n){
//         StringBuilder qc= new StringBuilder();
//         for(int i=0;i<n;i++){
//             if(i==col){
//                 qc.append("Q");
//             }else{
//                 qc.append(".");
//             }
//         }

//         return qc.toString();
//     }

//     public boolean isQueenSafetoPlace(int[][] board,int row,int col){

//         for(int rp=row, cp=col;rp>=0;rp--){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;rp>=0 && cp>=0;rp--,cp--){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;cp>=0;cp--){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;rp<=board.length-1 && cp>=0; rp++,cp--){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;rp<=board.length;rp++){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;rp<=board.length && cp<board[0].length;rp++,cp++){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;cp<=board[0].length;cp++){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }

//         for(int rp=row, cp=col;rp>=0 && cp<=board[0].length;rp--,cp++){
//             if(board[rp][col] == 1){
//                 return false;
//             }
//         }
//     }
// }