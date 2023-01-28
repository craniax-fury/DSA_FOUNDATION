package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftClonedTree {

    public static BinaryTreeNode leftCloning(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }

        leftCloning(node.left);
        leftCloning(node.right);

        BinaryTreeNode leftClone = copyNode(node.left);

        BinaryTreeNode clone = new BinaryTreeNode();
        clone.data = node.data;
        clone.left = leftClone;
        
        node.left = clone;

        return node;

    }

    private static BinaryTreeNode copyNode(BinaryTreeNode node) {

        if(node==null){
            return null;
        }

        BinaryTreeNode tempNode = new BinaryTreeNode();
        tempNode.data = node.data;
        tempNode.left = node.left;
        tempNode.right = node.right;

        return tempNode;
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
            LeftClonedTree.leftCloning(root);
            Display.display(root);
        }
    }
}
