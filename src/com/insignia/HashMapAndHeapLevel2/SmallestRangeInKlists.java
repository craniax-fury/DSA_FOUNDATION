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

public class SmallestRangeInKlists {

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

    public static int[] findSmallestRange(int[][] arr, int k) {

        int index = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);

        int max = 0;
        int min = Integer.MAX_VALUE;

        int ansMax = 0;
        int ansMin = Integer.MAX_VALUE;

        while (index < k) {
            queue.add(new Pair(index, 0, arr[index][0]));
           
           if(arr[index][0]>max){
            max = arr[index][0];
           }
           index+=1;
        }

        while(!queue.isEmpty()){
            Pair minPair = queue.poll();
            int n = arr[minPair.row].length;
            min=minPair.val;

            int minDiff = Math.abs(ansMax-ansMin);
            int tempDiff = Math.abs(max-min);

            if(tempDiff<minDiff){
                ansMax = max;
                ansMin = min;
            }

            if(minPair.col+1 < n){
                if(arr[minPair.row][minPair.col+1] > max){
                    max = arr[minPair.row][minPair.col+1];
                }

                queue.add(new Pair(minPair.row, minPair.col+1, arr[minPair.row][minPair.col+1]));
            }else {
                break;
            }
        }

        return new int[]{ansMax,ansMin};
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            int[][] arr = new int[][]{
                {4,10,15,24,26},
                {0,9,12,20},
                {5,18,22,30}
            };

            int k = arr.length;

            int[] output = findSmallestRange(arr, k);

            for (int ele : output) {
                System.out.print(ele + " ");
            }
        }
    }
}
