package com.insignia.recursionPractise2;

import java.io.*;

public class LastIndex {

    public static int lastIndex(int[] arr, int idx, int x) {

        // base case
        if (idx == arr.length-1){
            if(arr[idx]==x) {
                return idx;
            }else{
                return -1;
            }
        }
        
        // recursive call
        int li = lastIndex(arr, idx + 1, x);

        // processing
        if(li==-1 && arr[idx]==x){
            return idx;
        }

        return li;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = Integer.parseInt(br.readLine());
        
        System.out.println(lastIndex(arr, 0,x));
    }

}