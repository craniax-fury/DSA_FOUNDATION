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
public class MinCostToMergeRopes {

    public static long minCost(long[] arr,int n){
        long output = 0;
        
        PriorityQueue<Long> queue = new PriorityQueue<>();
        
        for(long ele: arr){
            queue.add(ele);
        }
        
        int index=0;
        
        while(index!=n-1){
            
            long first = queue.poll();
            
            long second = queue.poll();
            
            long ans = first+second;
            
            output+=ans;

            queue.add(ans);    
            
            index+=1;
        }
        
        return output;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(br.readLine());
            }

            System.out.println(minCost(a, n));
        }
    }
}
