package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KLargest {

    private static PriorityQueue<Integer> queue = new PriorityQueue<>();
    private static int floor = Integer.MIN_VALUE;

    public static void kLargestUsingQueue(GenericTreeNode node, int k) {

        while (queue.size() < k) {
            queue.add(node.data);

            for (GenericTreeNode child : node.children) {
                kLargestUsingQueue(child, k);
            }

            return;
        }

        if (queue.peek() < node.data) {
            queue.remove();
            queue.add(node.data);
        }

        for (GenericTreeNode child : node.children) {
            kLargestUsingQueue(child, k);
        }
    }


    private static void floor(GenericTreeNode node,int data){
        
        if(node.data<data && node.data>floor){
            floor=node.data;
        }

        for(GenericTreeNode child: node.children){
            floor(child,data);
        }
    }

    public static int kLargest(GenericTreeNode node, int k) {

        int largeSoFar = Integer.MAX_VALUE;

        for(int index=0;index<k;index++){
          floor(node,largeSoFar); 
          largeSoFar = floor;
          floor=Integer.MIN_VALUE;
        }

        return largeSoFar;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            int k = Integer.parseInt(reader.readLine());

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            
            kLargestUsingQueue(root, k);
            System.out.println(queue.peek());

            System.out.println(kLargest(root, k));

        }

    }
}
