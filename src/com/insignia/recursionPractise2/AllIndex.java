package com.insignia.recursionPractise2;

import java.io.*;

public class AllIndex {

    public static int[] allIndex(int[] arr, int idx, int x, int esf) {

        // base case
        if (idx == arr.length) {
            return new int[esf];
        }

        int size = esf;

        // pre processing
        if (arr[idx] == x) {
            size += 1;
        }

        // recursive call
        int[] iarr = allIndex(arr, idx + 1, x, size);

        // processing
        if (arr[idx] == x) {
            iarr[esf] = idx;
        }

        return iarr;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndex(arr, 0, x, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        display1dArray(iarr);
    }

    private static void display1dArray(int[] allIndex) {
        for (int i = 0; i < allIndex.length; i++) {
            System.out.println(allIndex[i]);
        }
    }

}