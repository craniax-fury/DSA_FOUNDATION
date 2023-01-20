package com.insignia.recursionPractise2;

import java.io.*;

public class MaxOfArray {

    public static int maxOfArray(int[] arr,int idx) {
        
        // base case
        if (idx == arr.length-1) {
            return arr[idx];
        }

        // recursive call
        int ele = maxOfArray(arr, idx+1);

        // processing
        if(ele>arr[idx]){
            return ele;
        }
        
        return arr[idx];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(maxOfArray(arr, 0));
    }

}