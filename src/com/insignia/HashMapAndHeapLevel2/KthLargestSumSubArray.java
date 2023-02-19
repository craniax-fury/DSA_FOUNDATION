package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/
public class KthLargestSumSubArray {

    public static int kthlargestSum(int N,int K,int[] ARR){
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int arrIndex=0;arrIndex<N;arrIndex++){
            int ssf = 0;

            for(int subArrIndex=arrIndex;subArrIndex<N;subArrIndex++){
                ssf+=ARR[subArrIndex];
                if(queue.size()!=K){
                    queue.add(ssf);
                }else{
                    if(queue.peek() < ssf){
                        queue.poll();
                        queue.add(ssf);
                    }
                }
            }
        }

        return queue.poll();


    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());

            int[] ARR = new int[N];

            for (int index = 0; index < N; index++) {
                ARR[index] = Integer.parseInt(br.readLine());
            }

            System.out.println(kthlargestSum(N, K, ARR));
        }
    }
}
