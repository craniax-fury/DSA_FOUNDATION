package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {

    static int inversionCount = 0;

    static int[] merge(int[] a1, int[] a2) {

        int start = a1.length;
        int end = a2.length;

        int[] a3 = new int[start + end];

        int i = 0;
        int j = 0;

        int index = 0;

        while (i < start && j < end) {

            if (a1[i] <= a2[j]) {
                a3[index] = a1[i];
                i++;
            } else {
                inversionCount+= a1.length-i;
                a3[index] = a2[j];
                j++;
            }

            index += 1;
        }

        while (i < start) {
            a3[index] = a1[i++];
            index += 1;
        }

        while (j < end) {

            a3[index] = a2[j++];
            index += 1;

        }

        return a3;
    }

    static int[] mergeSort(int arr[], int l, int r) {
        if (l == r) {
            int[] a = new int[1];
            a[0] = arr[l];
            return a;
        }

        int mid = l + (r - l) / 2;
        int[] a1 = mergeSort(arr, l, mid);
        int[] a2 = mergeSort(arr, mid + 1, r);
        return merge(a1, a2);

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];

            int index = 0;
            while (index < n) {
                input[index] = Integer.parseInt(br.readLine());
                index += 1;
            }

            int[] a3 = mergeSort(input, 0, input.length - 1);

            for (int ele : a3) {
                System.out.print(ele + " ");
                System.out.println();
            }

            System.out.println(inversionCount);
        }
    }
}