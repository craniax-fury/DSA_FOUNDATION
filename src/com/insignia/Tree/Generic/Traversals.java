package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traversals {

    public static void traverse(GenericTreeNode node){

        if(node==null){
            return;
        }


        System.out.println("Node Pre "+node.data);

        for(GenericTreeNode child: node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traverse(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }

        System.out.println("Node Post "+node.data);

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
            
            traverse(root);

        }

    }
}
