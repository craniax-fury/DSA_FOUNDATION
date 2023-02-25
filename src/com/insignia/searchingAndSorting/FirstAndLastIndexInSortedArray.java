package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstAndLastIndexInSortedArray {

    public static int[] firstAndLastIndex(long[] v,long x) {

        int startIndex = -1;
        int endIndex = -1;

        startIndex = firstOccurence(v, x);
        endIndex = lastOccurence(v, x);

        return new int[]{startIndex,endIndex};
    }

    public static int firstOccurence(long[] v,long x){
        int start = 0;
        int end = v.length-1;

        int startIndex = -1;

        int mid = start + (end - start)/2;
        
        while(start <= end){

            if(v[mid] == x){
                startIndex = mid;
                end = mid - 1; 
    
            }else if(v[mid] < x){
                start = mid+1;
            
            }else{
                end = mid-1;
            }

            mid = start + (end - start)/2;
        }

        return startIndex;
    }

    public static int lastOccurence(long[] v,long x){
        int start = 0;
        int end = v.length-1;

        int lastIndex = -1;

        int mid = start + (end - start)/2;
        
        while(start <= end){

            if(v[mid] == x){
                lastIndex = mid;
                end = mid - 1; 
    
            }else if(v[mid] < x){
                start = mid+1;
            
            }else{
                end = mid-1;
            }

            mid = start + (end - start)/2;
        }

        return lastIndex;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] input = new long[n];

            int index=0;
            while(index<n){
                input[index] = Integer.parseInt(br.readLine());

                index+=1;
            }

            int ele = Integer.parseInt(br.readLine());

            int[] output = firstAndLastIndex(input,ele);
            
            System.out.println(output[0]+" "+output[1]);
        }
    }
}