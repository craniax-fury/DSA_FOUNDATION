package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

public class MergeKSortedArrays {

    static class PairNode {
        int row;
        int col;
        int val;

        PairNode(int row,int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static ArrayList<Integer> mergeKArrays1(int[][] arr, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int index = 0; index < K; index++) {
            for (int subIndex = 0; subIndex < K; subIndex++) {
                queue.add(arr[index][subIndex]);
            }
        }

        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        return list;

    }

    public static ArrayList<Integer> mergeKArrays2(int[][] arr, int K) {

        Comparator<PairNode> comparator = new Comparator<>() {

            @Override
            public int compare(PairNode p1, PairNode p2) {
                return p1.val - p2.val;
            }
        };

        PriorityQueue<PairNode> queue = new PriorityQueue<>(comparator);

        ArrayList<Integer> list = new ArrayList<>();

        int row = 0;
        int col = 0;

        for(int ir=0;ir<K;ir++){
            MergeKSortedArrays.PairNode pair = new MergeKSortedArrays.PairNode(ir,0, arr[ir][0]);
            queue.add(pair);
        }

        while (!queue.isEmpty()) {
            MergeKSortedArrays.PairNode nPair = queue.poll();

            row=nPair.row;
            col=nPair.col;

            list.add(arr[row][col]);

            if(col+1<K){
                MergeKSortedArrays.PairNode pair = new MergeKSortedArrays.PairNode(row,col+1, arr[row][col+1]);
                queue.add(pair);
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(br.readLine());

            int[][] arr = new int[k][k];

            for (int index = 0; index < k; index++) {
                for (int subIndex = 0; subIndex < arr[index].length; subIndex++) {
                    arr[index][subIndex] = Integer.parseInt(br.readLine());
                }
            }

            System.out.println(mergeKArrays2(arr, k));
        }
    }
}
