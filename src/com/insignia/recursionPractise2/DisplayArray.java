package com.insignia.recursionPractise2;

import java.io.*;

public class DisplayArray {

    public static void displayArray(int[] arr,int idx) {

        // base case
        if (idx == arr.length) {
            return;
        }

        // processing
        System.out.println(arr[idx]);

        // recursive call
        displayArray(arr, idx+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        displayArray(arr, 0);
    }

}