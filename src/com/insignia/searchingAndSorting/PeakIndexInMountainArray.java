package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeakIndexInMountainArray {

    public static int peakIndex(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        
        int mid = start + (end-start)/2;

        while(start < end){
           if(arr[mid]<arr[mid+1]){
                //at left line
                start = mid; 
           }else{
                //at right line
                end=mid;
           }

           mid = start + (end-start)/2;
        }

        return -1;
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

            int output = peakIndex(input);
            
            System.out.println(output);
        }
    }
}