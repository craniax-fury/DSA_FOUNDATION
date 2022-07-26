package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int find = Integer.parseInt(br.readLine());
        lastIndex(arr,n-1,find);

    }

    private static void lastIndex(int[] arr,int n,int find) {
        if(n<0){
            System.out.println("");
            return;
        }
        
        if(arr[n]==find){
            System.out.println(n);
            return;
        }

        lastIndex(arr, n-1,find);

    }
}