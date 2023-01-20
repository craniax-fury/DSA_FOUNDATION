package com.insignia.recursionPractise2;

import java.io.*;

public class DisplayArrayInReverse {

    public static void displayArray(int[] arr,int idx) {

        // base case
        if (idx == arr.length) {
            return;
        }

        // recursive call
        displayArray(arr, idx+1);

        // processing
        System.out.println(arr[idx]);
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