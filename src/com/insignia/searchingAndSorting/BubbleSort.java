package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        for (int index = 0; index < arr.length-1 && swap; index++) {

            int i = 0;
            boolean swap = false;
            
            for (int sIndex = 1; sIndex < arr.length - index; sIndex++) {
                if(arr[i] > arr[sIndex]){
                    swap(arr,i,sIndex,swap);
                }
                i+=1;
            }
        }

        for(int num: arr){
            System.out.print(num+" ");
        }

    }

    private static void swap(int[] arr,int index, int sIndex,boolean swap) {
        if(index==sIndex){
            return;
        }

        int temp = arr[index];
        arr[index] = arr[sIndex];
        arr[sIndex] = temp;

        swap = true;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(br.readLine());
            }

            bubbleSort(arr);
        }
    }
}