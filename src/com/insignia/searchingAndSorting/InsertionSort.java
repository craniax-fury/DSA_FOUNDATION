package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {

    public static void insertionSort(int n) throws IOException {

        int[] arr = new int[n];
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            arr[0] = Integer.parseInt(br.readLine());
        
            for (int index = 1; index < n; index++) {
                arr[index] = Integer.parseInt(br.readLine());

                int i = index;

                while(i-1>=0 && arr[i-1] > arr[i] ){
                    swap(arr,i-1,i);
                    i--;
                }
            }
        }

        for(int num: arr){
            System.out.print(num+" ");
        }

    }

    private static void swap(int[] arr, int index, int sIndex) {
        if (index == sIndex) {
            return;
        }

        int temp = arr[index];
        arr[index] = arr[sIndex];
        arr[sIndex] = temp;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            insertionSort(n);
        }
    }
}