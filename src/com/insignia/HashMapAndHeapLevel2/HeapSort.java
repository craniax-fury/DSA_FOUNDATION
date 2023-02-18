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
public class HeapSort {

    public static int[] heapSort(int[] data,int index) {

        if(index<=0){
            return data;
        }

        int temp = data[0];

        data[0] = data[index];
        data[index] = temp;

        downHeapify(data,0,index-1);

        return heapSort(data, index-1);
    }

    private static void downHeapify(int[] data,int parentIndex,int size){

        int leftIndex = (2 * parentIndex) + 1;
        int rightIndex = (2 * parentIndex) + 2;

        int largerIndex = 0;

        if(leftIndex>size && rightIndex>size){
            return;
        }else if(leftIndex>size && rightIndex<size+1){
            largerIndex = rightIndex;
        }else if(leftIndex<size+1 && rightIndex>size){
            largerIndex = leftIndex;
        }else{
            if(data[leftIndex]>data[rightIndex]){
                largerIndex = leftIndex;
            }else{
                largerIndex = rightIndex;
            }
        }

        if(data[parentIndex]<data[largerIndex]){
            int temp = data[parentIndex];
            data[parentIndex] = data[largerIndex];
            data[largerIndex] = temp;
        }

        downHeapify(data, largerIndex,size);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] data = new int[n];

            for (int index = 0; index < n; index++) {
                data[index] = Integer.parseInt(br.readLine());
            }

            int[] output = heapSort(data,data.length-1);

            for (int ele : output) {
                System.out.print(ele + " ");
            }
        }
    }
}
