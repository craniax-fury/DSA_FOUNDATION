package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CustomHeap {
    // static int size = 5;
    // static int[] arr = new int[] { 52, 50, 53, 54, 55 };

    static int size = 0;
    static int[] arr = new int[100];
}

public class Utility {

    public static void insert(int ele) {

        CustomHeap.arr[CustomHeap.size] = ele;

        int currentIndex = CustomHeap.size;
        int parentIndex = currentIndex / 2;

        while (currentIndex > parentIndex) {

            if (CustomHeap.arr[parentIndex] < ele) {
                swap(CustomHeap.arr, parentIndex, currentIndex);
                currentIndex = parentIndex;
                parentIndex = currentIndex / 2;

            } else {
                break;
            }

        }

        CustomHeap.size += 1;

    }

    public static int delete() {

        int deleted = CustomHeap.arr[0];
        swap(CustomHeap.arr, CustomHeap.size - 1, 0);
        CustomHeap.size -= 1;

        int parentIndex = 0;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        while (parentIndex < CustomHeap.size) {
            int largerIndex = parentIndex;

            if (leftIndex < CustomHeap.size && CustomHeap.arr[parentIndex] < CustomHeap.arr[leftIndex]) {
                largerIndex = leftIndex;

            }
            if (rightIndex < CustomHeap.size && CustomHeap.arr[largerIndex] < CustomHeap.arr[rightIndex]) {
                largerIndex = rightIndex;
            }

            if (largerIndex != parentIndex) {
                swap(CustomHeap.arr, parentIndex, largerIndex);
                parentIndex = largerIndex;
                leftIndex = 2 * parentIndex + 1;
                rightIndex = 2 * parentIndex + 2;

            } else {
                break;
            }

        }

        return deleted;

    }

    private static void swap(int[] arr, int parentIndex, int currentIndex) {
        int temp = CustomHeap.arr[currentIndex];
        CustomHeap.arr[currentIndex] = CustomHeap.arr[parentIndex];
        CustomHeap.arr[parentIndex] = temp;
    }

    public static void heapify(int[] arr, int parentIndex) {

        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        int largerIndex = parentIndex;

        if (leftIndex < CustomHeap.size && CustomHeap.arr[parentIndex] < CustomHeap.arr[leftIndex]) {
            largerIndex = leftIndex;

        }

        if (rightIndex < CustomHeap.size && CustomHeap.arr[largerIndex] < CustomHeap.arr[rightIndex]) {
            largerIndex = rightIndex;

        }

        if (parentIndex != largerIndex) {
            swap(CustomHeap.arr, parentIndex, largerIndex);
            heapify(CustomHeap.arr, largerIndex);
        }

    }

    public static void buildHeap() {

        int index = CustomHeap.size / 2;

        while (index >= 0) {
            heapify(CustomHeap.arr, index);
            index--;
        }
    }

    public static void heapSort() {
        int tempSize = CustomHeap.size;

        while (CustomHeap.size > 0) {
            delete();
        }

        CustomHeap.size = tempSize;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            insert(54);
            insert(53);
            insert(55);
            insert(50);
            insert(52);

            int index = 0;

            while (index < CustomHeap.size) {
                System.out.print(CustomHeap.arr[index] + " ");
                index += 1;
            }

            index = 0;

            //System.out.println();
            // System.out.println("deleted: " + delete());

            // while (index < CustomHeap.size) {
            //     System.out.print(CustomHeap.arr[index] + " ");
            //     index += 1;
            // }
            
            //buildHeap();

            // while (index < CustomHeap.size) {
            //     System.out.print(CustomHeap.arr[index] + " ");
            //     index += 1;
            // }

            heapSort();

            index = 0;

            System.out.println();

            while (index < CustomHeap.size) {
                System.out.print(CustomHeap.arr[index] + " ");
                index += 1;
            }
        }
    }
}
