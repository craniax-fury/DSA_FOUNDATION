package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteInBST {

    public static BSTNode delete(BSTNode node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            if (node.left == null && node.right == null) {
                // no child
                return null;
            } else if (node.left != null && node.right == null) {
                // one child
                return node.left;
            } else if (node.left == null && node.right != null) {
                // one child
                return node.right;
            } else {
                // two children
                node.data = findMaxofLeft(node.left);
                node.left = delete(node.left, node.data);
                return node;
            }
        } else if (data < node.data) {
            node.left = delete(node.left, data);

        } else {
            node.right = delete(node.right, data);

        }

        return node;

    }

    private static int findMaxofLeft(BSTNode node) {

        if (node.right != null) {
            return findMaxofLeft(node.right);
        }

        return node.data;
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

            int data = Integer.parseInt(reader.readLine());
            BSTNode root = Constructor.constructor(arr);
            delete(root, data);

        }
    }
}
