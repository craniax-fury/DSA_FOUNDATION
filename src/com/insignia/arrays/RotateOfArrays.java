package com.insignia.arrays;

import java.util.Scanner;

public class RotateOfArrays {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int rotations = sc.nextInt();

            rotate(arr,rotations);
            display(arr);
        }
    }

    private static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void rotate(int[] arr, int rotations) {
        
        int aR = 0;

        if(rotations%arr.length==0){
            return;
        }else if(rotations<0){
            aR= arr.length+(rotations%arr.length);
        }else {
            aR = rotations%arr.length;
        }

        reverse(arr,0,arr.length-aR-1);

        reverse(arr,arr.length-aR,arr.length-1);

        reverse(arr,0,arr.length-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        int li = i;
        int ri = j;
        
        while(li<ri){
            int temp=arr[li];
            arr[li]=arr[ri];
            arr[ri]=temp;
            
            li++;
            ri--;
        }
    }

}