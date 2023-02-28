package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

    static void merge(int arr[], int l, int m, int r) {

        //l - m
        int[] a3 = new int[r-l+1];
        //m+1 - r

        int i = l;
        int j = m+1;

        int index = 0;
       
        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                a3[index] = arr[i];
                i++;
            }else{
                a3[index] = arr[j];
                j++;
            }

            index+=1;
        }

        while(i<=m){
            a3[index] = arr[i];
            index+=1;
            i+=1;
        }

        while(j<=r){
            a3[index] = arr[j];
            j+=1;
            index+=1;
        }

        index = 0;

        for(int in=l;in<=r;in++){
            arr[in] = a3[index++];
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

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

            mergeSort(input, 0, input.length - 1);

            for (int ele : input) {
                System.out.print(ele + " ");
            }
        }
    }
}