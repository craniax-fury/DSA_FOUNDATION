package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TotalNumberOfOccurence {

    public static int totalOccurence(long[] v,long x) {

        int startIndex = FirstAndLastIndexInSortedArray.firstOccurence(v, x);
        int lastIndex = FirstAndLastIndexInSortedArray.lastOccurence(v, x);

        return lastIndex-startIndex+1;
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

            int output = totalOccurence(input,ele);
            
            System.out.println(output);
        }
    }
}