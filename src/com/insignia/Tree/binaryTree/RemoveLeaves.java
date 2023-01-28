package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveLeaves {

    public static void removeLeaves(BinaryTreeNode node) {

        if (node == null) {
            return ;
        }

        if( node.left!=null && node.left.left==null && node.left.right==null){
            node.left=null;
        }

        if(node.right!=null && node.right.left==null && node.right.right==null){
            node.right=null;
        }

        removeLeaves(node.left);
        removeLeaves(node.right);

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
            RemoveLeaves.removeLeaves(root);
            Display.display(root);
        }
    }
}
