package com.insignia.recursion;

import java.io.*;

public class MaxOfArray {

    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
           int number = Integer.parseInt(reader.readLine());
           int[] input = new int[number];
           for(int index=0;index<number;index++){
               input[index] = Integer.parseInt(reader.readLine());
           }
           
          System.out.println(maxOfArray(input,0));
       }
   }

   public static int maxOfArray(int[] arr, int idx){
       int max=-1;
       
       if(idx==arr.length){
           return 0;
       }
       
       max = maxOfArray(arr,idx+1);
       
       if(max<arr[idx]){
           max=arr[idx];
       }
       
       return max;
   }

}