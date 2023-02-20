package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

    public static int binarySearch(int[] input,int start,int end,int ele) {

        if(start >= end){
            return -1;
        }

        int mid = start + (end-start)/2;

        if(input[mid] == ele){
            return mid;
        }

        if(ele > input[mid]){
            start = mid+1;
        
        }else{
            end = mid-1;
        }

        return binarySearch(input, start, end, ele);

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

            int ele = Integer.parseInt(br.readLine());


            System.out.println(binarySearch(input,0,input.length-1,ele));
        }
    }
}