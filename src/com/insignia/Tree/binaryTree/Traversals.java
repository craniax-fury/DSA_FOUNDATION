package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traversals {

    public static void traversal(BinaryTreeNode node) {
        
        if(node==null){
            return;
        }

        System.out.println(node.data+" in preorder");

        if(node.left!=null){
            traversal(node.left);
        }

        System.out.println(node.data+" in inorder");
        
        if(node.right!=null){
            traversal(node.right);
        }

        System.out.println(node.data+" in postOrder");
        
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                if (!(values[index].equals("n"))) {
                    arr[index] = Integer.parseInt(values[index]);
                } else {
                    arr[index] = null;
                }
            }

           BinaryTreeNode root = Constructor.constructor(arr);
            Traversals.traversal(root);
        }
    }
}
