package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PivotInSortedArray {

    public static int pivot(int[] arr) {

        int start = 0,end = arr.length-1;
    
        while(start < end){
            int mid = start + (end-start)/2;

            if(mid==start || arr[mid] > arr[0]){
                //at left line
                start=mid+1; 
            }else{
                //at right line
                end=mid;
           }
        }

        return arr[end];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];

            int index=0;
            while(index<n){
                input[index] = Integer.parseInt(br.readLine());

                index+=1;
            }

            int output = pivot(input);
            
            System.out.println(output);
        }
    }
}