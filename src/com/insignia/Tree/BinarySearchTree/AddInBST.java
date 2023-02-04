package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddInBST {

    public static BSTNode add(BSTNode node, int data) {
        if (node == null) {
            return new BSTNode(data, null, null);
        }

        if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }

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

            int data = Integer.parseInt(reader.readLine());

            BSTNode root = Constructor.constructor(arr);
            add(root, data);
            Utility.display(root);
        }
    }
}
