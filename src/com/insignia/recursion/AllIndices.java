package com.insignia.recursion;

import java.io.*;

public class AllIndices {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {

        if (arr.length == idx) {
            return new int[fsf];
        }

        int[] tempArr = allIndices(arr, x, idx + 1, arr[idx] == x ? fsf + 1 : fsf);

        if (arr[idx] == x && tempArr.length != 0) {
            tempArr[fsf] = idx;
        }

        return tempArr;

    }

}