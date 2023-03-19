package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/

public class SmallestRangeInKList {

    static class Pair {
        int row;
        int col;
        int val;

        Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static int[] findSmallestRange(int[][] arr, int n, int k) {

        int ansMin = Integer.MAX_VALUE;
        int ansMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Comparator<Pair> comparator = new Comparator<>() {

            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        };

        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);

        int index = 0;

        while (index != k) {
            queue.add(new Pair(index, 0, arr[index][0]));

            if (arr[index][0] > max) {
                max = arr[index][0];
            }

            index += 1;
        }

        while (!queue.isEmpty()) {
            Pair minPair = queue.poll();

            min = minPair.val;

            int tempDiff = max - min; 

            if (tempDiff < ansMax - ansMin && tempDiff >= 0) {
                ansMin = min;
                ansMax = max;
            }

            if (minPair.col + 1 < n) {

                if (arr[minPair.row][minPair.col + 1] > min) {
                    min = arr[minPair.row][minPair.col + 1];
                }

                queue.add(new Pair(minPair.row, minPair.col + 1, arr[minPair.row][minPair.col + 1]));
            }
        }

        return new int[] { ansMin, ansMax };
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            int[][] arr = new int[k][n];

            for (int index = 0; index < k; index++) {
                for (int subIndex = 0; subIndex < n; subIndex++) {
                    arr[index][subIndex] = Integer.parseInt(br.readLine());
                }
            }

            int[] output = findSmallestRange(arr, n, k);

            for (int ele : output) {
                System.out.print(ele + " ");
            }
        }
    }
}
