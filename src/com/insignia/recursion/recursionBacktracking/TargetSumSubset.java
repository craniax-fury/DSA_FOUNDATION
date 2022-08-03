package com.insignia.recursion.recursionBacktracking;

import java.io.*;
import java.util.Scanner;

public class TargetSumSubset {

    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }

            int tar = scn.nextInt();

            printTargetSumSubsets(arr, 0, "", 0, tar);
        }

    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

        if (sos > tar) {
            return;
        }

        if (idx==arr.length && sos == tar) {
            System.out.println(set+".");
            return;
        }

        if (idx != arr.length) {
            printTargetSumSubsets(arr, idx + 1, set+arr[idx] +", ", arr[idx] + sos, tar);
            printTargetSumSubsets(arr, idx + 1, set, sos, tar);
        }

        return;
    }

}