package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    static void quickSort(int[] arr, int low,int high ) {

        if(low>=high){
            return;
        }

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex-1);
        quickSort(arr, pivotIndex+1, high);
    }

    static int partition(int arr[], int low, int high) {
        
        /*
         * count ele less than pivot
         */

        int pivot = arr[low];
        int count = 0;
       
        for(int i=low+1;i<=high;i++){
            if(arr[i] <= pivot){
                count++;
            }
        }

        int pivotIndex = low + count;

        swap(arr,low,pivotIndex);

        /*
         * arrange left and right elements
         */

        int i=low;
        int j=high;

        while(i<j){
            if(arr[i] > pivot && arr[j] <= pivot){
                swap(arr, i, j);
                i++;
                j--;
            
            } else if(arr[j] <= pivot){
                i++;
            
            } else if(arr[i] > pivot){
                j--;
           
            } else{
                i++;
                j--;
            }    
        }
        return pivotIndex;

    }

    private static void swap(int[] arr, int low, int pivotIndex) {
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[low];
        arr[low] = temp;
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

            quickSort(input, 0, input.length - 1);

            for (int ele : input) {
                System.out.print(ele + " ");
            }
        }
    }
}