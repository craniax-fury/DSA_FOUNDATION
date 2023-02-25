package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInSortedRotatedArray {

    public static int searchInSortedRotatedArray(int[] arr,int key) {

        int pivot = findPivot(arr);
        int start = 0,end = arr.length-1;
    
        if(arr[0] > key){
            start = pivot;
        }else{
            end = pivot;
        }

        while(start < end){
            int mid = start + (end-start)/2;

            if(arr[mid]==key){
                return mid;
            }

            if(mid==0){
                start=mid+1;
                break;
            }
            
            if(arr[mid]<key){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        if(arr[start]==key){
            return start;
        }

        return -1;
    }

    public static int searchInSortedRotatedArray2(int[] arr,int key) {
        int start = 0,end = arr.length-1;
        
        while(start < end){
            int mid = start + (end-start)/2;

            if(arr[mid]==key){
                return mid;
            }

            if(key==arr[0]){
                return 0;
            }

            if(key >= arr[0]){
                if(arr[mid] < arr[0]){
                    end = mid;
                
                }else if(arr[mid] > key){
                    end = mid;
                }else{
                    start = mid+1;
                }
            
            }else{
                if(arr[mid] >= arr[0]){
                    start = mid+1;
                
                }else if(arr[mid] > key){
                    end = mid;
               
                }else{
                    start = mid+1;
                }
            }
        }

        if(arr[start]==key){
            return start;
        }

        return -1;
    }

    private static int findPivot(int[] arr){
        int start = 0, end = arr.length-1;

        if(arr[end]>arr[start]){
            return 0;
        }

        while(start<end){

            int mid = start + (end - start) / 2;

            if(mid==start || arr[mid]>arr[0]){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];

            int index=0;
            
            while(index<n){
                input[index] = Integer.parseInt(br.readLine());

                index+=1;
            }

            int key = Integer.parseInt(br.readLine());

            int output = searchInSortedRotatedArray2(input,key);
            
            System.out.println(output);
        }
    }
}