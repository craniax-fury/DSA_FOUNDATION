package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/
public class MergeTwoBinaryMaxHeap {

    public static int[] mergeHeaps(int[] a,int[] b,int n,int m){
        int[] output = new int[n+m];
        
        if(n==0){
            return b;
        }else if(m==0){
            return a;
        }else{
            for(int index=0;index<n;index++){
                output[index]=a[index];
            }

            for(int index=output.length-1;index<output.length-1+m;index++){
                output[index]=b[index];
            }

            for(int index=output.length/2;index>=0;index--){
    
                heapify(output,index);
            }

            return output;
        }

    }

    private static void heapify(int[] output,int parentIndex) {

        int leftIndex = 2*parentIndex+1;
        int rightIndex = 2*parentIndex+2;

        int largerIndex = 0;
        
        if(leftIndex>output.length-1 && rightIndex>output.length-1){
            return;
        
        }else if(rightIndex>output.length-1){
            if(output[leftIndex]>output[parentIndex]){
                largerIndex = leftIndex;
                
                int temp = output[parentIndex];
                output[parentIndex] = output[leftIndex];
                output[leftIndex] = temp;

                heapify(output, largerIndex);
            }        
        }else{
            largerIndex = output[leftIndex]>output[rightIndex]?leftIndex:rightIndex;

            if(output[largerIndex] > output[parentIndex]){
                int temp = output[parentIndex];
                output[parentIndex] = output[largerIndex];
                output[largerIndex] = temp;

                heapify(output, largerIndex);
            }
        }

        
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            int[] a = new int[n];
            int[] b = new int[m];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(br.readLine());
            }

            int[] output = mergeHeaps(a,b,n,m);

            for (int ele : output) {
                System.out.print(ele + " ");
            }
        }
    }
}
