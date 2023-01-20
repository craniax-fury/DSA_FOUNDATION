package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NodePair {
    int sum = 0;
    GenericTreeNode node = null;
}

public class MaxSumSubTree {

    private static NodePair maxPair = new NodePair();

    public static int maxSumSubTree(GenericTreeNode node) {

        if(node==null){
            return 0;
        }

        if(node.children.size()==0){
            return node.data;
        }
        
        int localmax = 0;

        for (GenericTreeNode child : node.children) {
            localmax += maxSumSubTree(child);
        }

        localmax += node.data;

        if (localmax > maxPair.sum) {
            maxPair.sum = localmax;
            maxPair.node = node;
        }

        return localmax;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            GenericTreeNode root = Constructor.constructGenericTree(arr);

            maxSumSubTree(root);

            System.out.println(maxPair.node.data + "@" + maxPair.sum);
        }

    }
}
