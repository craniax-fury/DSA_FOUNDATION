package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrderTraverse(GenericTreeNode node){

        if(node==null){
            return;
        }

        Queue<GenericTreeNode> nodeQueue = new ArrayDeque<>();

        nodeQueue.add(node);

        while(!nodeQueue.isEmpty()){
            GenericTreeNode headNode = nodeQueue.remove();
            System.out.print(headNode.data+" ");
            
            for(GenericTreeNode child: headNode.children){
                nodeQueue.add(child);
            }
        }

        System.out.println(".");

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
            
            levelOrderTraverse(root);

        }

    }
}
