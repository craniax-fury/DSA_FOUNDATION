package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Height {

    public static int height(GenericTreeNode node) {

        int height=-1;

        if (node == null) {
            return -1;
        }

        for (GenericTreeNode child : node.children) {
           int child_max =  height(child)+1;
           if(child_max>height){
                height=child_max;
           }
        }

        height+=1;
        return height;
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
            int max = height(root);
            System.out.println(max);

        }

    }
}
