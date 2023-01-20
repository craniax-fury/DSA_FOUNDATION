package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max {

    public static int max(GenericTreeNode node) {

        int max=Integer.MIN_VALUE;

        if (node == null) {
            return -1;
        }

        for (GenericTreeNode child : node.children) {
           int child_max =  max(child);
           if(child_max>max){
                max=child_max;
           }
        }

        if(node.data>max){
            max=node.data;
        }

        return max;
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
            int max = max(root);
            System.out.println(max);

        }

    }
}
