package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {

    static void insert(int arr[], int i) {
        int index = i - 1;

        int ele = arr[i];

        while (index >= 0 && arr[index] > ele) {
            arr[index + 1] = arr[index];
            index--;

        }

        arr[index + 1] = ele;
    }

    // Function to sort the array using insertion sort algorithm.
    public static void insertionSort(int arr[], int n) {

        for (int index = 1; index < n; index++) {
            insert(arr, index);
        }
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

            insertionSort(input,n);

            for(int ele: input){
                System.out.print(ele+" ");
            }
        }
    }
}