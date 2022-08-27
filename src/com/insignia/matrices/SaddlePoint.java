package com.insignia.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SaddlePoint {
  public static boolean saddlePoint(int[][] matrix) {
    int possSaddle = Integer.MAX_VALUE;
    int psdR = 0;
    int psdC = 0;

    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++){
          if(matrix[i][j]<possSaddle){
            possSaddle=matrix[i][j];
            psdR=i;
            psdC=j;
          }   
      }

      boolean isSaddle = true;
      
      for(int k=0;k<matrix.length;k++){
        if(matrix[k][psdC]>possSaddle && k!=psdR){
          isSaddle=false;
        }
      }

      if(isSaddle){
        System.out.println(possSaddle);
        return isSaddle;
      }

      possSaddle=Integer.MAX_VALUE;
    }

    return false;
    
  }

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      int rows1 = Integer.parseInt(reader.readLine());

      int[][] matrix1 = new int[rows1][rows1];

      for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < rows1; j++) {
          matrix1[i][j] = Integer.parseInt(reader.readLine());
        }
      }

      if(!saddlePoint(matrix1)){
        System.out.println("Invalid input");
      }
    }
  }
}