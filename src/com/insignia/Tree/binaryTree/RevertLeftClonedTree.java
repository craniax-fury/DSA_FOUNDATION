package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevertLeftClonedTree {

    public static BinaryTreeNode revertLeftCloning(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }

        node.left=node.left.left;

        revertLeftCloning(node.left);
        revertLeftCloning(node.right);

        
        return node;

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
            RevertLeftClonedTree.revertLeftCloning(root);
            Display.display(root);
        }
    }
}
