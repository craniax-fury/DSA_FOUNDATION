package com.insignia.recursionPractise2;

import java.io.*;

public class FirstIndex {

    public static int firstIndex(int[] arr, int idx, int x) {

        // base case
        if (idx == arr.length) {
            return -1;
        }

        // processing
        if(arr[idx]==x){
            return idx;
        }
        
        // recursive call
        return firstIndex(arr, idx + 1, x);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = Integer.parseInt(br.readLine());
        
        System.out.println(firstIndex(arr, 0,x));
    }

}