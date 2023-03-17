package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for (int index = 0; index < arr.length-1; index++) {
            int minIndex = index;

            for (int sIndex = index+1; sIndex < arr.length; sIndex++) {
                if(arr[sIndex] < arr[minIndex]){
                    minIndex=sIndex;
                }
            }

            swap(arr,index,minIndex);
        }

    }

    private static void swap(int[] arr,int index, int sIndex) {
        if(index==sIndex){
            return;
        }

        int temp = arr[index];
        arr[index] = arr[sIndex];
        arr[sIndex] = temp;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(br.readLine());
            }

            selectionSort(arr);
        }
    }
}