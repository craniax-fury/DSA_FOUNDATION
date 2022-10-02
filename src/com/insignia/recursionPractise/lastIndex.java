package com.insignia.recursionPractise;

import java.io.*;

public class lastIndex {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        printar(arr,n-1);

    }

    private static void printar(int[] arr,int n) {
        
        if(n<0){
            return;
        }
        System.out.println(arr[n]);
        printar(arr, n-1);
        

    }
}